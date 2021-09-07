/**
 * @fileoverview gRPC-Web generated client stub for com.jobportal.studentservice
 * @enhanceable
 * @public
 */

// GENERATED CODE -- DO NOT EDIT!


/* eslint-disable */
// @ts-nocheck



const grpc = {};
grpc.web = require('grpc-web');

const proto = {};
proto.com = {};
proto.com.jobportal = {};
proto.com.jobportal.studentservice = require('./student_pb.js');

/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.com.jobportal.studentservice.StudentServiceClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

};


/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.com.jobportal.studentservice.StudentServicePromiseClient =
    function(hostname, credentials, options) {
  if (!options) options = {};
  options['format'] = 'text';

  /**
   * @private @const {!grpc.web.GrpcWebClientBase} The client
   */
  this.client_ = new grpc.web.GrpcWebClientBase(options);

  /**
   * @private @const {string} The hostname
   */
  this.hostname_ = hostname;

};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentservice.GetStudentContactRequest,
 *   !proto.com.jobportal.studentservice.GetStudentContactResponse>}
 */
const methodDescriptor_StudentService_getStudentContactDetails = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentservice.StudentService/getStudentContactDetails',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentservice.GetStudentContactRequest,
  proto.com.jobportal.studentservice.GetStudentContactResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.GetStudentContactRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.GetStudentContactResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentservice.GetStudentContactRequest,
 *   !proto.com.jobportal.studentservice.GetStudentContactResponse>}
 */
const methodInfo_StudentService_getStudentContactDetails = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentservice.GetStudentContactResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.GetStudentContactRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.GetStudentContactResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentservice.GetStudentContactRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentservice.GetStudentContactResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentservice.GetStudentContactResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentservice.StudentServiceClient.prototype.getStudentContactDetails =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/getStudentContactDetails',
      request,
      metadata || {},
      methodDescriptor_StudentService_getStudentContactDetails,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentservice.GetStudentContactRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentservice.GetStudentContactResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentservice.StudentServicePromiseClient.prototype.getStudentContactDetails =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/getStudentContactDetails',
      request,
      metadata || {},
      methodDescriptor_StudentService_getStudentContactDetails);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentservice.GetAllStudentsRequest,
 *   !proto.com.jobportal.studentservice.GetAllStudentsResponse>}
 */
const methodDescriptor_StudentService_getAllStudents = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentservice.StudentService/getAllStudents',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentservice.GetAllStudentsRequest,
  proto.com.jobportal.studentservice.GetAllStudentsResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.GetAllStudentsRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.GetAllStudentsResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentservice.GetAllStudentsRequest,
 *   !proto.com.jobportal.studentservice.GetAllStudentsResponse>}
 */
const methodInfo_StudentService_getAllStudents = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentservice.GetAllStudentsResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.GetAllStudentsRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.GetAllStudentsResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentservice.GetAllStudentsRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentservice.GetAllStudentsResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentservice.GetAllStudentsResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentservice.StudentServiceClient.prototype.getAllStudents =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/getAllStudents',
      request,
      metadata || {},
      methodDescriptor_StudentService_getAllStudents,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentservice.GetAllStudentsRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentservice.GetAllStudentsResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentservice.StudentServicePromiseClient.prototype.getAllStudents =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/getAllStudents',
      request,
      metadata || {},
      methodDescriptor_StudentService_getAllStudents);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentservice.GetStudentByIdRequest,
 *   !proto.com.jobportal.studentservice.GetStudentByIdResponse>}
 */
const methodDescriptor_StudentService_getStudentById = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentservice.StudentService/getStudentById',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentservice.GetStudentByIdRequest,
  proto.com.jobportal.studentservice.GetStudentByIdResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.GetStudentByIdRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.GetStudentByIdResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentservice.GetStudentByIdRequest,
 *   !proto.com.jobportal.studentservice.GetStudentByIdResponse>}
 */
const methodInfo_StudentService_getStudentById = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentservice.GetStudentByIdResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.GetStudentByIdRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.GetStudentByIdResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentservice.GetStudentByIdRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentservice.GetStudentByIdResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentservice.GetStudentByIdResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentservice.StudentServiceClient.prototype.getStudentById =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/getStudentById',
      request,
      metadata || {},
      methodDescriptor_StudentService_getStudentById,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentservice.GetStudentByIdRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentservice.GetStudentByIdResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentservice.StudentServicePromiseClient.prototype.getStudentById =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/getStudentById',
      request,
      metadata || {},
      methodDescriptor_StudentService_getStudentById);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentservice.SaveStudentRequest,
 *   !proto.com.jobportal.studentservice.SaveStudentResponse>}
 */
const methodDescriptor_StudentService_saveStudent = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentservice.StudentService/saveStudent',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentservice.SaveStudentRequest,
  proto.com.jobportal.studentservice.SaveStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.SaveStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.SaveStudentResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentservice.SaveStudentRequest,
 *   !proto.com.jobportal.studentservice.SaveStudentResponse>}
 */
const methodInfo_StudentService_saveStudent = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentservice.SaveStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.SaveStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.SaveStudentResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentservice.SaveStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentservice.SaveStudentResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentservice.SaveStudentResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentservice.StudentServiceClient.prototype.saveStudent =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/saveStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_saveStudent,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentservice.SaveStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentservice.SaveStudentResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentservice.StudentServicePromiseClient.prototype.saveStudent =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/saveStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_saveStudent);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentservice.UpdateStudentRequest,
 *   !proto.com.jobportal.studentservice.UpdateStudentResponse>}
 */
const methodDescriptor_StudentService_updateStudent = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentservice.StudentService/updateStudent',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentservice.UpdateStudentRequest,
  proto.com.jobportal.studentservice.UpdateStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.UpdateStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.UpdateStudentResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentservice.UpdateStudentRequest,
 *   !proto.com.jobportal.studentservice.UpdateStudentResponse>}
 */
const methodInfo_StudentService_updateStudent = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentservice.UpdateStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.UpdateStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.UpdateStudentResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentservice.UpdateStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentservice.UpdateStudentResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentservice.UpdateStudentResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentservice.StudentServiceClient.prototype.updateStudent =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/updateStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_updateStudent,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentservice.UpdateStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentservice.UpdateStudentResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentservice.StudentServicePromiseClient.prototype.updateStudent =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/updateStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_updateStudent);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentservice.DeleteStudentRequest,
 *   !proto.com.jobportal.studentservice.DeleteStudentResponse>}
 */
const methodDescriptor_StudentService_deleteStudent = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentservice.StudentService/deleteStudent',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentservice.DeleteStudentRequest,
  proto.com.jobportal.studentservice.DeleteStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.DeleteStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.DeleteStudentResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentservice.DeleteStudentRequest,
 *   !proto.com.jobportal.studentservice.DeleteStudentResponse>}
 */
const methodInfo_StudentService_deleteStudent = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentservice.DeleteStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentservice.DeleteStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentservice.DeleteStudentResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentservice.DeleteStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentservice.DeleteStudentResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentservice.DeleteStudentResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentservice.StudentServiceClient.prototype.deleteStudent =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/deleteStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_deleteStudent,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentservice.DeleteStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentservice.DeleteStudentResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentservice.StudentServicePromiseClient.prototype.deleteStudent =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentservice.StudentService/deleteStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_deleteStudent);
};


module.exports = proto.com.jobportal.studentservice;

