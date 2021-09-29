const PROTO_PATH = './proto/placementService.proto';
const nconf = require('nconf');

const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');

const { tracer } = require('./zipkin/zipkinClient');
const grpcInstrumentation = require('zipkin-instrumentation-grpc-client');

const interceptor = grpcInstrumentation(grpc, { tracer });

var packageDefinition = protoLoader.loadSync(PROTO_PATH, {
  keepCase: true,
  longs: String,
  enums: String,
  arrays: true,
});

const PlacementService =
  grpc.loadPackageDefinition(packageDefinition).com.jobportal
    .placementserviceproto.PlacementService;
const CompanyService =
  grpc.loadPackageDefinition(packageDefinition).com.jobportal
    .placementserviceproto.CompanyService;
const placementService = new PlacementService(
  `localhost:${nconf.get('config').grpc_port}`,
  grpc.credentials.createInsecure(),
  { interceptors: [interceptor] }
);
const companyService = new CompanyService(
  `localhost:${nconf.get('config').grpc_port}`,
  grpc.credentials.createInsecure(),
  { interceptors: [interceptor] }
);

module.exports.placementService = placementService;
module.exports.companyService = companyService;
