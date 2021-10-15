const PROTO_PATH = './proto/studentService.proto';
const nconf = require('nconf');

const grpc = require('grpc');
const protoLoader = require('@grpc/proto-loader');

var packageDefinition = protoLoader.loadSync(PROTO_PATH, {
  keepCase: true,
  longs: String,
  enums: String,
  arrays: true,
});

const StudentService =
  grpc.loadPackageDefinition(packageDefinition).com.jobportal.studentserviceproto.StudentService;

const studentService = new StudentService(
  `localhost:${nconf.get('config').student_service_port}`,
  grpc.credentials.createInsecure()
);

module.exports.studentService = studentService;
