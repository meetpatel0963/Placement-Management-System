/**
 * @fileoverview gRPC-Web generated client stub for com.jobportal.studentserviceproto
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
proto.com.jobportal.studentserviceproto = require('./student_pb.js');

/**
 * @param {string} hostname
 * @param {?Object} credentials
 * @param {?Object} options
 * @constructor
 * @struct
 * @final
 */
proto.com.jobportal.studentserviceproto.StudentServiceClient =
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
proto.com.jobportal.studentserviceproto.StudentServicePromiseClient =
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
 *   !proto.com.jobportal.studentserviceproto.GetStudentContactRequest,
 *   !proto.com.jobportal.studentserviceproto.GetStudentContactResponse>}
 */
const methodDescriptor_StudentService_getStudentContactDetails = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentserviceproto.StudentService/getStudentContactDetails',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentserviceproto.GetStudentContactRequest,
  proto.com.jobportal.studentserviceproto.GetStudentContactResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.GetStudentContactRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.GetStudentContactResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentserviceproto.GetStudentContactRequest,
 *   !proto.com.jobportal.studentserviceproto.GetStudentContactResponse>}
 */
const methodInfo_StudentService_getStudentContactDetails = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentserviceproto.GetStudentContactResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.GetStudentContactRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.GetStudentContactResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentserviceproto.GetStudentContactRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentserviceproto.GetStudentContactResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentserviceproto.GetStudentContactResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentserviceproto.StudentServiceClient.prototype.getStudentContactDetails =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/getStudentContactDetails',
      request,
      metadata || {},
      methodDescriptor_StudentService_getStudentContactDetails,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentserviceproto.GetStudentContactRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentserviceproto.GetStudentContactResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentserviceproto.StudentServicePromiseClient.prototype.getStudentContactDetails =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/getStudentContactDetails',
      request,
      metadata || {},
      methodDescriptor_StudentService_getStudentContactDetails);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentserviceproto.GetAllStudentsRequest,
 *   !proto.com.jobportal.studentserviceproto.GetAllStudentsResponse>}
 */
const methodDescriptor_StudentService_getAllStudents = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentserviceproto.StudentService/getAllStudents',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentserviceproto.GetAllStudentsRequest,
  proto.com.jobportal.studentserviceproto.GetAllStudentsResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.GetAllStudentsRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.GetAllStudentsResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentserviceproto.GetAllStudentsRequest,
 *   !proto.com.jobportal.studentserviceproto.GetAllStudentsResponse>}
 */
const methodInfo_StudentService_getAllStudents = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentserviceproto.GetAllStudentsResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.GetAllStudentsRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.GetAllStudentsResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentserviceproto.GetAllStudentsRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentserviceproto.GetAllStudentsResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentserviceproto.GetAllStudentsResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentserviceproto.StudentServiceClient.prototype.getAllStudents =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/getAllStudents',
      request,
      metadata || {},
      methodDescriptor_StudentService_getAllStudents,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentserviceproto.GetAllStudentsRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentserviceproto.GetAllStudentsResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentserviceproto.StudentServicePromiseClient.prototype.getAllStudents =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/getAllStudents',
      request,
      metadata || {},
      methodDescriptor_StudentService_getAllStudents);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentserviceproto.GetStudentByIdRequest,
 *   !proto.com.jobportal.studentserviceproto.GetStudentByIdResponse>}
 */
const methodDescriptor_StudentService_getStudentById = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentserviceproto.StudentService/getStudentById',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentserviceproto.GetStudentByIdRequest,
  proto.com.jobportal.studentserviceproto.GetStudentByIdResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.GetStudentByIdRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.GetStudentByIdResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentserviceproto.GetStudentByIdRequest,
 *   !proto.com.jobportal.studentserviceproto.GetStudentByIdResponse>}
 */
const methodInfo_StudentService_getStudentById = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentserviceproto.GetStudentByIdResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.GetStudentByIdRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.GetStudentByIdResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentserviceproto.GetStudentByIdRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentserviceproto.GetStudentByIdResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentserviceproto.GetStudentByIdResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentserviceproto.StudentServiceClient.prototype.getStudentById =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/getStudentById',
      request,
      metadata || {},
      methodDescriptor_StudentService_getStudentById,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentserviceproto.GetStudentByIdRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentserviceproto.GetStudentByIdResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentserviceproto.StudentServicePromiseClient.prototype.getStudentById =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/getStudentById',
      request,
      metadata || {},
      methodDescriptor_StudentService_getStudentById);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentserviceproto.SaveStudentRequest,
 *   !proto.com.jobportal.studentserviceproto.SaveStudentResponse>}
 */
const methodDescriptor_StudentService_saveStudent = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentserviceproto.StudentService/saveStudent',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentserviceproto.SaveStudentRequest,
  proto.com.jobportal.studentserviceproto.SaveStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.SaveStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.SaveStudentResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentserviceproto.SaveStudentRequest,
 *   !proto.com.jobportal.studentserviceproto.SaveStudentResponse>}
 */
const methodInfo_StudentService_saveStudent = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentserviceproto.SaveStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.SaveStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.SaveStudentResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentserviceproto.SaveStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentserviceproto.SaveStudentResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentserviceproto.SaveStudentResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentserviceproto.StudentServiceClient.prototype.saveStudent =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/saveStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_saveStudent,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentserviceproto.SaveStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentserviceproto.SaveStudentResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentserviceproto.StudentServicePromiseClient.prototype.saveStudent =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/saveStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_saveStudent);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentserviceproto.UpdateStudentRequest,
 *   !proto.com.jobportal.studentserviceproto.UpdateStudentResponse>}
 */
const methodDescriptor_StudentService_updateStudent = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentserviceproto.StudentService/updateStudent',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentserviceproto.UpdateStudentRequest,
  proto.com.jobportal.studentserviceproto.UpdateStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.UpdateStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.UpdateStudentResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentserviceproto.UpdateStudentRequest,
 *   !proto.com.jobportal.studentserviceproto.UpdateStudentResponse>}
 */
const methodInfo_StudentService_updateStudent = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentserviceproto.UpdateStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.UpdateStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.UpdateStudentResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentserviceproto.UpdateStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentserviceproto.UpdateStudentResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentserviceproto.UpdateStudentResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentserviceproto.StudentServiceClient.prototype.updateStudent =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/updateStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_updateStudent,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentserviceproto.UpdateStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentserviceproto.UpdateStudentResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentserviceproto.StudentServicePromiseClient.prototype.updateStudent =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/updateStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_updateStudent);
};


/**
 * @const
 * @type {!grpc.web.MethodDescriptor<
 *   !proto.com.jobportal.studentserviceproto.DeleteStudentRequest,
 *   !proto.com.jobportal.studentserviceproto.DeleteStudentResponse>}
 */
const methodDescriptor_StudentService_deleteStudent = new grpc.web.MethodDescriptor(
  '/com.jobportal.studentserviceproto.StudentService/deleteStudent',
  grpc.web.MethodType.UNARY,
  proto.com.jobportal.studentserviceproto.DeleteStudentRequest,
  proto.com.jobportal.studentserviceproto.DeleteStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.DeleteStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.DeleteStudentResponse.deserializeBinary
);


/**
 * @const
 * @type {!grpc.web.AbstractClientBase.MethodInfo<
 *   !proto.com.jobportal.studentserviceproto.DeleteStudentRequest,
 *   !proto.com.jobportal.studentserviceproto.DeleteStudentResponse>}
 */
const methodInfo_StudentService_deleteStudent = new grpc.web.AbstractClientBase.MethodInfo(
  proto.com.jobportal.studentserviceproto.DeleteStudentResponse,
  /**
   * @param {!proto.com.jobportal.studentserviceproto.DeleteStudentRequest} request
   * @return {!Uint8Array}
   */
  function(request) {
    return request.serializeBinary();
  },
  proto.com.jobportal.studentserviceproto.DeleteStudentResponse.deserializeBinary
);


/**
 * @param {!proto.com.jobportal.studentserviceproto.DeleteStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @param {function(?grpc.web.Error, ?proto.com.jobportal.studentserviceproto.DeleteStudentResponse)}
 *     callback The callback function(error, response)
 * @return {!grpc.web.ClientReadableStream<!proto.com.jobportal.studentserviceproto.DeleteStudentResponse>|undefined}
 *     The XHR Node Readable Stream
 */
proto.com.jobportal.studentserviceproto.StudentServiceClient.prototype.deleteStudent =
    function(request, metadata, callback) {
  return this.client_.rpcCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/deleteStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_deleteStudent,
      callback);
};


/**
 * @param {!proto.com.jobportal.studentserviceproto.DeleteStudentRequest} request The
 *     request proto
 * @param {?Object<string, string>} metadata User defined
 *     call metadata
 * @return {!Promise<!proto.com.jobportal.studentserviceproto.DeleteStudentResponse>}
 *     Promise that resolves to the response
 */
proto.com.jobportal.studentserviceproto.StudentServicePromiseClient.prototype.deleteStudent =
    function(request, metadata) {
  return this.client_.unaryCall(this.hostname_ +
      '/com.jobportal.studentserviceproto.StudentService/deleteStudent',
      request,
      metadata || {},
      methodDescriptor_StudentService_deleteStudent);
};


module.exports = proto.com.jobportal.studentserviceproto;

