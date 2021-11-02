const express = require('express');
const cors = require('cors');
const bodyParser = require('body-parser');
const eureka = require('./eurekaClient');
const nconf = require('nconf');
const childProcess = require('child_process');
nconf.argv().env().file({ file: process.cwd() + '/config/config.json' });

function createChild(scriptPath, callback, config) {
  var invoked = false;
  var process = childProcess.fork(scriptPath, [config]);

  process.on('error', function (err) {
    console.log("grpc error");
    if (invoked) return;
    invoked = true;
    callback(err);
  });

  process.on('exit', function (code) {
    console.log("EXIT");
    if (invoked) return;
    invoked = true;
    var err = code === 0 ? null : new Error('exit code ' + code);
    callback(err);
  });
  return process;
}

const { configServerReq } = require('./configServerReq');

configServerReq()
  .then((response) => {
    nconf.set('config', response.data.propertySources[0].source);

    const child = createChild(
        './placement-service-grpc.js',
        function (err) {
          if (err) throw err;
          console.log('finished running some-script.js');
        },
        JSON.stringify(nconf.get('config'))
      );

    console.log(nconf.get('config'));
    
    const placementRoutes = require('./routes/placement.routes');
    const companyRoutes = require('./routes/company.routes');
    const { tracer } = require('./zipkin/zipkinClient');
    const zipkinMiddleware =
      require('zipkin-instrumentation-express').expressMiddleware;

    const app = express();

    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({ extended: false }));
    app.use(cors());
    app.use(zipkinMiddleware({ tracer }));

    app.use('/api/v1/placement/', placementRoutes);
    app.use('/api/v1/company/', companyRoutes);

    const REST_PORT = nconf.get('config').rest_port || 3000;
    app.listen(REST_PORT, () => {
      console.log('Server running at port %d 🚀🚀🚀', REST_PORT);
      eureka.registerWithEureka();
      
      console.log('here');
      const { amqpConnect } = require('./amqp/amqp');
      amqpConnect(child);
    });
  })
  .catch((err) => {
    if (err.message) throw err;
    throw new Error(err);
  });
