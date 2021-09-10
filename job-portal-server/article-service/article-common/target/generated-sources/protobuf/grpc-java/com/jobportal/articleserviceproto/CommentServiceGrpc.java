package com.jobportal.articleserviceproto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: articleService.proto")
public final class CommentServiceGrpc {

  private CommentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.jobportal.articleserviceproto.CommentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse> getGetAllCommentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllComments",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse> getGetAllCommentsMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse> getGetAllCommentsMethod;
    if ((getGetAllCommentsMethod = CommentServiceGrpc.getGetAllCommentsMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getGetAllCommentsMethod = CommentServiceGrpc.getGetAllCommentsMethod) == null) {
          CommentServiceGrpc.getGetAllCommentsMethod = getGetAllCommentsMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllComments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("getAllComments"))
              .build();
        }
      }
    }
    return getGetAllCommentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse> getGetCommentByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCommentById",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse> getGetCommentByIdMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse> getGetCommentByIdMethod;
    if ((getGetCommentByIdMethod = CommentServiceGrpc.getGetCommentByIdMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getGetCommentByIdMethod = CommentServiceGrpc.getGetCommentByIdMethod) == null) {
          CommentServiceGrpc.getGetCommentByIdMethod = getGetCommentByIdMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCommentById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("getCommentById"))
              .build();
        }
      }
    }
    return getGetCommentByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse> getSaveCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveComment",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse> getSaveCommentMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse> getSaveCommentMethod;
    if ((getSaveCommentMethod = CommentServiceGrpc.getSaveCommentMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getSaveCommentMethod = CommentServiceGrpc.getSaveCommentMethod) == null) {
          CommentServiceGrpc.getSaveCommentMethod = getSaveCommentMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("saveComment"))
              .build();
        }
      }
    }
    return getSaveCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse> getUpdateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateComment",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse> getUpdateCommentMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse> getUpdateCommentMethod;
    if ((getUpdateCommentMethod = CommentServiceGrpc.getUpdateCommentMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getUpdateCommentMethod = CommentServiceGrpc.getUpdateCommentMethod) == null) {
          CommentServiceGrpc.getUpdateCommentMethod = getUpdateCommentMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("updateComment"))
              .build();
        }
      }
    }
    return getUpdateCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse> getDeleteCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteComment",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse> getDeleteCommentMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse> getDeleteCommentMethod;
    if ((getDeleteCommentMethod = CommentServiceGrpc.getDeleteCommentMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getDeleteCommentMethod = CommentServiceGrpc.getDeleteCommentMethod) == null) {
          CommentServiceGrpc.getDeleteCommentMethod = getDeleteCommentMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("deleteComment"))
              .build();
        }
      }
    }
    return getDeleteCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse> getGetAllCommentsByPostIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllCommentsByPostId",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse> getGetAllCommentsByPostIdMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse> getGetAllCommentsByPostIdMethod;
    if ((getGetAllCommentsByPostIdMethod = CommentServiceGrpc.getGetAllCommentsByPostIdMethod) == null) {
      synchronized (CommentServiceGrpc.class) {
        if ((getGetAllCommentsByPostIdMethod = CommentServiceGrpc.getGetAllCommentsByPostIdMethod) == null) {
          CommentServiceGrpc.getGetAllCommentsByPostIdMethod = getGetAllCommentsByPostIdMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllCommentsByPostId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CommentServiceMethodDescriptorSupplier("getAllCommentsByPostId"))
              .build();
        }
      }
    }
    return getGetAllCommentsByPostIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CommentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceStub>() {
        @java.lang.Override
        public CommentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceStub(channel, callOptions);
        }
      };
    return CommentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CommentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceBlockingStub>() {
        @java.lang.Override
        public CommentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceBlockingStub(channel, callOptions);
        }
      };
    return CommentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CommentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CommentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CommentServiceFutureStub>() {
        @java.lang.Override
        public CommentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CommentServiceFutureStub(channel, callOptions);
        }
      };
    return CommentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CommentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllComments(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCommentsMethod(), responseObserver);
    }

    /**
     */
    public void getCommentById(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCommentByIdMethod(), responseObserver);
    }

    /**
     */
    public void saveComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveCommentMethod(), responseObserver);
    }

    /**
     */
    public void updateComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateCommentMethod(), responseObserver);
    }

    /**
     */
    public void deleteComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCommentMethod(), responseObserver);
    }

    /**
     */
    public void getAllCommentsByPostId(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCommentsByPostIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllCommentsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse>(
                  this, METHODID_GET_ALL_COMMENTS)))
          .addMethod(
            getGetCommentByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse>(
                  this, METHODID_GET_COMMENT_BY_ID)))
          .addMethod(
            getSaveCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse>(
                  this, METHODID_SAVE_COMMENT)))
          .addMethod(
            getUpdateCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse>(
                  this, METHODID_UPDATE_COMMENT)))
          .addMethod(
            getDeleteCommentMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse>(
                  this, METHODID_DELETE_COMMENT)))
          .addMethod(
            getGetAllCommentsByPostIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse>(
                  this, METHODID_GET_ALL_COMMENTS_BY_POST_ID)))
          .build();
    }
  }

  /**
   */
  public static final class CommentServiceStub extends io.grpc.stub.AbstractAsyncStub<CommentServiceStub> {
    private CommentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllComments(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCommentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCommentById(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCommentByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCommentsByPostId(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllCommentsByPostIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CommentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CommentServiceBlockingStub> {
    private CommentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse getAllComments(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCommentsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse getCommentById(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCommentByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse saveComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse updateComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse deleteComment(com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCommentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse getAllCommentsByPostId(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllCommentsByPostIdMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CommentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CommentServiceFutureStub> {
    private CommentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CommentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CommentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse> getAllComments(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCommentsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse> getCommentById(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCommentByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse> saveComment(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse> updateComment(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse> deleteComment(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCommentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse> getAllCommentsByPostId(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllCommentsByPostIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_COMMENTS = 0;
  private static final int METHODID_GET_COMMENT_BY_ID = 1;
  private static final int METHODID_SAVE_COMMENT = 2;
  private static final int METHODID_UPDATE_COMMENT = 3;
  private static final int METHODID_DELETE_COMMENT = 4;
  private static final int METHODID_GET_ALL_COMMENTS_BY_POST_ID = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CommentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CommentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_COMMENTS:
          serviceImpl.getAllComments((com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse>) responseObserver);
          break;
        case METHODID_GET_COMMENT_BY_ID:
          serviceImpl.getCommentById((com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse>) responseObserver);
          break;
        case METHODID_SAVE_COMMENT:
          serviceImpl.saveComment((com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse>) responseObserver);
          break;
        case METHODID_UPDATE_COMMENT:
          serviceImpl.updateComment((com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse>) responseObserver);
          break;
        case METHODID_DELETE_COMMENT:
          serviceImpl.deleteComment((com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_COMMENTS_BY_POST_ID:
          serviceImpl.getAllCommentsByPostId((com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CommentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CommentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.jobportal.articleserviceproto.ArticleServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CommentService");
    }
  }

  private static final class CommentServiceFileDescriptorSupplier
      extends CommentServiceBaseDescriptorSupplier {
    CommentServiceFileDescriptorSupplier() {}
  }

  private static final class CommentServiceMethodDescriptorSupplier
      extends CommentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CommentServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CommentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CommentServiceFileDescriptorSupplier())
              .addMethod(getGetAllCommentsMethod())
              .addMethod(getGetCommentByIdMethod())
              .addMethod(getSaveCommentMethod())
              .addMethod(getUpdateCommentMethod())
              .addMethod(getDeleteCommentMethod())
              .addMethod(getGetAllCommentsByPostIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
