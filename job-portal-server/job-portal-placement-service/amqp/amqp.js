const amqp = require('amqplib');
const nconf = require('nconf');
const { configServerReq } = require('../configServerReq');

const CONSUMER_TAG = 'placement-service';
const QUEUE_NAME = 'config-event-queue';

async function amqpConnect(child) {
  try {
    const conn = await amqp.connect('amqp://guest:guest@rabbitmq:5672/');
    const channel = await conn.createChannel();
    await channel.assertExchange(nconf.get('config').config_event_bus, 'topic');
    await channel.assertQueue(QUEUE_NAME);
    await channel.bindQueue(
      QUEUE_NAME,
      nconf.get('config').config_event_bus,
      nconf.get('config').config_event_bus
    );

    console.log('Ready to consume messages...');
    channel.consume(
      QUEUE_NAME,
      async (rawMsg) => {
        const updateToken = JSON.parse(rawMsg.content);
        if (updateToken.destinationService.includes('placement-service')) {
          configServerReq()
            .then((response) => {
              nconf.set('config', response.data.propertySources[0].source);
              child.send({ config: nconf.get('config') });
            })
            .catch((err) => {
              throw err;
            });
        }
      },
      {
        noAck: true,
        consumerTag: CONSUMER_TAG,
      }
    );

    process.on('SIGTERM', async () => {
      await channel.cancel(CONSUMER_TAG);

      console.log('Closing channel...');
      await channel.close();

      console.log('Closing connection...');
      await conn.close();

      console.log('Ready to shutdown!');
    });
  } catch (error) {
    throw error;
  }
}

module.exports.amqpConnect = amqpConnect;
