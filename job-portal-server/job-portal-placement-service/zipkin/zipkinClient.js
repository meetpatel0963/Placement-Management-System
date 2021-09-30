const {
  Tracer,
  ExplicitContext,
  BatchRecorder,
  jsonEncoder: { JSON_V2 },
  sampler
} = require('zipkin');
const { HttpLogger } = require('zipkin-transport-http');
const nconf = require('nconf');

// setup zipkin tracer
const ctxImpl = new ExplicitContext();
// const sampler = new sampler.CountingSampler(100);
const tracer = new Tracer({
  ctxImpl,
  recorder: new BatchRecorder({
    logger: new HttpLogger({
      endpoint: `${nconf.get('config').zipkin_endpoint_url}`,
      jsonEncoder: JSON_V2,
    }),
  }),
  localServiceName: 'placement-service',
});

module.exports.tracer = tracer;
