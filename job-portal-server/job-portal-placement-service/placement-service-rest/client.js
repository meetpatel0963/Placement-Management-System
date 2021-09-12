const PROTO_PATH = "./proto/placementService.proto";
const dotenv = require("dotenv");

const grpc = require("grpc");
const protoLoader = require("@grpc/proto-loader");
dotenv.config({ path: "./config/config.env" });

var packageDefinition = protoLoader.loadSync(PROTO_PATH, {
  keepCase: true,
  longs: String,
  enums: String,
  arrays: true,
});

const PlacementService =
  grpc.loadPackageDefinition(packageDefinition).PlacementService;
const CompanyService =
  grpc.loadPackageDefinition(packageDefinition).CompanyService;
const placementService = new PlacementService(
  `localhost:${process.env.GRPC_PORT}`,
  grpc.credentials.createInsecure()
);
const companyService = new CompanyService(
  `localhost:${process.env.GRPC_PORT}`,
  grpc.credentials.createInsecure()
);

module.exports.placementService = placementService;
module.exports.companyService = companyService;
