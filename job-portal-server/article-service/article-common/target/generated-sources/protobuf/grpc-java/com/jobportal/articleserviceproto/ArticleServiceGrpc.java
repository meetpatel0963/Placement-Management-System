package com.jobportal.articleserviceproto;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.35.0)",
    comments = "Source: articleService.proto")
public final class ArticleServiceGrpc {

  private ArticleServiceGrpc() {}

  public static final String SERVICE_NAME = "com.jobportal.articleserviceproto.ArticleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse> getGetAllArticlesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllArticles",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse> getGetAllArticlesMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse> getGetAllArticlesMethod;
    if ((getGetAllArticlesMethod = ArticleServiceGrpc.getGetAllArticlesMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getGetAllArticlesMethod = ArticleServiceGrpc.getGetAllArticlesMethod) == null) {
          ArticleServiceGrpc.getGetAllArticlesMethod = getGetAllArticlesMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllArticles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("getAllArticles"))
              .build();
        }
      }
    }
    return getGetAllArticlesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse> getGetArticleByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getArticleById",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse> getGetArticleByIdMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse> getGetArticleByIdMethod;
    if ((getGetArticleByIdMethod = ArticleServiceGrpc.getGetArticleByIdMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getGetArticleByIdMethod = ArticleServiceGrpc.getGetArticleByIdMethod) == null) {
          ArticleServiceGrpc.getGetArticleByIdMethod = getGetArticleByIdMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getArticleById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("getArticleById"))
              .build();
        }
      }
    }
    return getGetArticleByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse> getSaveArticleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "saveArticle",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse> getSaveArticleMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse> getSaveArticleMethod;
    if ((getSaveArticleMethod = ArticleServiceGrpc.getSaveArticleMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getSaveArticleMethod = ArticleServiceGrpc.getSaveArticleMethod) == null) {
          ArticleServiceGrpc.getSaveArticleMethod = getSaveArticleMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "saveArticle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("saveArticle"))
              .build();
        }
      }
    }
    return getSaveArticleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse> getUpdateArticleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateArticle",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse> getUpdateArticleMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse> getUpdateArticleMethod;
    if ((getUpdateArticleMethod = ArticleServiceGrpc.getUpdateArticleMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getUpdateArticleMethod = ArticleServiceGrpc.getUpdateArticleMethod) == null) {
          ArticleServiceGrpc.getUpdateArticleMethod = getUpdateArticleMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateArticle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("updateArticle"))
              .build();
        }
      }
    }
    return getUpdateArticleMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse> getDeleteArticleMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteArticle",
      requestType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest.class,
      responseType = com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest,
      com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse> getDeleteArticleMethod() {
    io.grpc.MethodDescriptor<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse> getDeleteArticleMethod;
    if ((getDeleteArticleMethod = ArticleServiceGrpc.getDeleteArticleMethod) == null) {
      synchronized (ArticleServiceGrpc.class) {
        if ((getDeleteArticleMethod = ArticleServiceGrpc.getDeleteArticleMethod) == null) {
          ArticleServiceGrpc.getDeleteArticleMethod = getDeleteArticleMethod =
              io.grpc.MethodDescriptor.<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest, com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteArticle"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ArticleServiceMethodDescriptorSupplier("deleteArticle"))
              .build();
        }
      }
    }
    return getDeleteArticleMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ArticleServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArticleServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ArticleServiceStub>() {
        @java.lang.Override
        public ArticleServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ArticleServiceStub(channel, callOptions);
        }
      };
    return ArticleServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ArticleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArticleServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ArticleServiceBlockingStub>() {
        @java.lang.Override
        public ArticleServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ArticleServiceBlockingStub(channel, callOptions);
        }
      };
    return ArticleServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ArticleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ArticleServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ArticleServiceFutureStub>() {
        @java.lang.Override
        public ArticleServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ArticleServiceFutureStub(channel, callOptions);
        }
      };
    return ArticleServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ArticleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllArticles(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllArticlesMethod(), responseObserver);
    }

    /**
     */
    public void getArticleById(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetArticleByIdMethod(), responseObserver);
    }

    /**
     */
    public void saveArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSaveArticleMethod(), responseObserver);
    }

    /**
     */
    public void updateArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateArticleMethod(), responseObserver);
    }

    /**
     */
    public void deleteArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteArticleMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllArticlesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse>(
                  this, METHODID_GET_ALL_ARTICLES)))
          .addMethod(
            getGetArticleByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse>(
                  this, METHODID_GET_ARTICLE_BY_ID)))
          .addMethod(
            getSaveArticleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse>(
                  this, METHODID_SAVE_ARTICLE)))
          .addMethod(
            getUpdateArticleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse>(
                  this, METHODID_UPDATE_ARTICLE)))
          .addMethod(
            getDeleteArticleMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest,
                com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse>(
                  this, METHODID_DELETE_ARTICLE)))
          .build();
    }
  }

  /**
   */
  public static final class ArticleServiceStub extends io.grpc.stub.AbstractAsyncStub<ArticleServiceStub> {
    private ArticleServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArticleServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllArticles(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAllArticlesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getArticleById(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetArticleByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void saveArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSaveArticleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateArticleMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest request,
        io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteArticleMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ArticleServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ArticleServiceBlockingStub> {
    private ArticleServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArticleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse getAllArticles(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAllArticlesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse getArticleById(com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetArticleByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse saveArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSaveArticleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse updateArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateArticleMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse deleteArticle(com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteArticleMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ArticleServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ArticleServiceFutureStub> {
    private ArticleServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ArticleServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ArticleServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse> getAllArticles(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAllArticlesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse> getArticleById(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetArticleByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse> saveArticle(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSaveArticleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse> updateArticle(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateArticleMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse> deleteArticle(
        com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteArticleMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_ARTICLES = 0;
  private static final int METHODID_GET_ARTICLE_BY_ID = 1;
  private static final int METHODID_SAVE_ARTICLE = 2;
  private static final int METHODID_UPDATE_ARTICLE = 3;
  private static final int METHODID_DELETE_ARTICLE = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ArticleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ArticleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_ARTICLES:
          serviceImpl.getAllArticles((com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse>) responseObserver);
          break;
        case METHODID_GET_ARTICLE_BY_ID:
          serviceImpl.getArticleById((com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse>) responseObserver);
          break;
        case METHODID_SAVE_ARTICLE:
          serviceImpl.saveArticle((com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse>) responseObserver);
          break;
        case METHODID_UPDATE_ARTICLE:
          serviceImpl.updateArticle((com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse>) responseObserver);
          break;
        case METHODID_DELETE_ARTICLE:
          serviceImpl.deleteArticle((com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest) request,
              (io.grpc.stub.StreamObserver<com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse>) responseObserver);
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

  private static abstract class ArticleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ArticleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.jobportal.articleserviceproto.ArticleServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ArticleService");
    }
  }

  private static final class ArticleServiceFileDescriptorSupplier
      extends ArticleServiceBaseDescriptorSupplier {
    ArticleServiceFileDescriptorSupplier() {}
  }

  private static final class ArticleServiceMethodDescriptorSupplier
      extends ArticleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ArticleServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ArticleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ArticleServiceFileDescriptorSupplier())
              .addMethod(getGetAllArticlesMethod())
              .addMethod(getGetArticleByIdMethod())
              .addMethod(getSaveArticleMethod())
              .addMethod(getUpdateArticleMethod())
              .addMethod(getDeleteArticleMethod())
              .build();
        }
      }
    }
    return result;
  }
}
