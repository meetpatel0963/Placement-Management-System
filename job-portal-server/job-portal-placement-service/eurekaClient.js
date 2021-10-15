const Eureka = require('eureka-js-client').Eureka;
const config = require('./config/config');
const nconf = require('nconf');

exports.registerWithEureka = function () {
  const client = new Eureka({
    instance: {
      app: config.APP_NAME,
      hostName: nconf.get('config').host_name,
      ipAddr: nconf.get('config').ip_address,
      port: {
        $: nconf.get('config').rest_port,
        '@enabled': 'true',
      },
      vipAddress: config.APP_NAME,
      dataCenterInfo: {
        '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
        name: 'MyOwn',
      },
    },
    //retry 10 time for 3 minute 20 seconds.
    eureka: {
      host: nconf.get('config').eureka_host,
      port: nconf.get('config').eureka_port,
      servicePath: '/eureka/apps/',
      maxRetries: 10,
      heartbeatInterval: nconf.get('config').heartbeat_interval,
      registryFetchInterval: nconf.get('config').registry_fetch_interval,
    },
  });

  client.start((error) => {
    console.log(error || 'user service registered');
  });

  function exitHandler(options, exitCode) {
    if (options.cleanup) {
    }
    if (exitCode || exitCode === 0) console.log(exitCode);
    if (options.exit) {
      client.stop();
    }
  }

  client.on('deregistered', () => {
    process.exit();
    console.log('after deregistered');
  });

  client.on('started', () => {
    console.log('eureka host  ' + nconf.get('config').eureka_host);
  });

  process.on('SIGINT', exitHandler.bind(null, { exit: true }));
};
