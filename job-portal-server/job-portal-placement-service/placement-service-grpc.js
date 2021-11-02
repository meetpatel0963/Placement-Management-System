const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');
const nconf = require('nconf');

process.on('message', function(msg) {
  nconf.set('config', msg.config);  
});

nconf.argv().env().file({ file: './config/config.json' });
nconf.set('config', JSON.parse(process.argv[2]));

const db = require('./models');
const placementService = require('./service/placement_details_service.service');
const companyService = require('./service/company_service.service');

db.sequelize
  .sync()
  .then(() => {
    console.log('Completed database sync.');
  })
  .catch((err) => {
    console.log("Couldn't sync to the database.");
    throw err;
  });

const PROTO_PATH = './proto/placementService.proto';
const SERVER_URI = `0.0.0.0:${nconf.get('config').grpc_port}`;

var packageDefinition = protoLoader.loadSync(PROTO_PATH, {
  keepCase: true,
  longs: String,
  enums: String,
  arrays: true,
});

var placementServiceProto = grpc.loadPackageDefinition(packageDefinition);

const server = new grpc.Server();

server.addService(
  placementServiceProto.com.jobportal.placementserviceproto.PlacementService
    .service,
  {
    getAllPlacementEntries: placementService.getAllPlacementEntries,
    getPlacementEntryById: placementService.getPlacementEntryById,
    savePlacementEntry: placementService.savePlacementEntry,
    updatePlacementEntry: placementService.updatePlacementEntry,
    deletePlacementEntry: placementService.deletePlacementEntry,
  }
);

server.addService(
  placementServiceProto.com.jobportal.placementserviceproto.CompanyService
    .service,
  {
    getAllCompanies: companyService.getAllCompanies,
    getCompanyById: companyService.getCompanyById,
    saveCompany: companyService.saveCompany,
    updateCompany: companyService.updateCompany,
    deleteCompany: companyService.deleteCompany,
    getPlacementDetails: companyService.getPlacementDetails,
    isCompanyExist: companyService.isCompanyExist,
  }
);

server.bind(SERVER_URI, grpc.ServerCredentials.createInsecure());
console.log(`gRPC Server running at port ${nconf.get('config').grpc_port}.`);
server.start();
