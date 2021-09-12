const dotenv = require('dotenv');
const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');

const db = require('./models');
const placementService = require('./service/placement_details_service.service');
const companyService = require('./service/company_service.service');

// Load config
dotenv.config({ path: './config/config.env' });

db.sequelize
  .sync()
  .then(() => {
    console.log('Completed database sync.');
  })
  .catch((err) => {
    console.log("Couldn't sync to the database.");
  });

const PROTO_PATH = './proto/placementService.proto';
const SERVER_URI = `0.0.0.0:${process.env.GRPC_PORT}`;

var packageDefinition = protoLoader.loadSync(PROTO_PATH, {
  keepCase: true,
  longs: String,
  enums: String,
  arrays: true,
});

var placementServiceProto = grpc.loadPackageDefinition(packageDefinition);

const server = new grpc.Server();

server.addService(placementServiceProto.PlacementService.service, {
  getAllPlacementEntries: placementService.getAllPlacementEntries,
  getPlacementEntryById: placementService.getPlacementEntryById,
  savePlacementEntry: placementService.savePlacementEntry,
  updatePlacementEntry: placementService.updatePlacementEntry,
  deletePlacementEntry: placementService.deletePlacementEntry,
});

server.addService(placementServiceProto.CompanyService.service, {
  getAllCompanies: companyService.getAllCompanies,
  getCompanyById: companyService.getCompanyById,
  saveCompany: companyService.saveCompany,
  updateCompany: companyService.updateCompany,
  deleteCompany: companyService.deleteCompany,
  getPlacementDetails: companyService.getPlacementDetails,
});

server.bind(SERVER_URI, grpc.ServerCredentials.createInsecure());
console.log(`gRPC Server running at port ${process.env.GRPC_PORT}.`);
server.start();
