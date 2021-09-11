package com.jobportal.articleservice.controller;

import com.jobportal.articleservice.config.LogGrpcInterceptor;
import com.jobportal.articleservice.service.ArticleService;
import com.jobportal.articleserviceproto.ArticleServiceGrpc;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@GrpcService(interceptors = { LogGrpcInterceptor.class })
@CrossOrigin
public class ArticleGrpcController extends ArticleServiceGrpc.ArticleServiceImplBase {

    @Autowired
    private ArticleService articleService;

    @Override
    public void getAllArticles(ArticleServiceOuterClass.GetAllArticlesRequest request,
                               StreamObserver<ArticleServiceOuterClass.GetAllArticlesResponse> responseObserver) {
        responseObserver.onNext(articleService.getAllArticles(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getArticleById(ArticleServiceOuterClass.GetArticleByIdRequest request,
                               StreamObserver<ArticleServiceOuterClass.GetArticleByIdResponse> responseObserver) {
        Optional<ArticleServiceOuterClass.GetArticleByIdResponse> getArticleByIdResponse =
                articleService.getArticleById(request.getArticleId(), request);

        if(!getArticleByIdResponse.isPresent()) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("No article exists with given Id!").asRuntimeException());
        } else {
            responseObserver.onNext(getArticleByIdResponse.get());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void saveArticle(ArticleServiceOuterClass.SaveArticleRequest request,
                            StreamObserver<ArticleServiceOuterClass.SaveArticleResponse> responseObserver) {
        responseObserver.onNext(articleService.saveArticle(request));
        responseObserver.onCompleted();
    }

    @Override
    public void updateArticle(ArticleServiceOuterClass.UpdateArticleRequest request,
                              StreamObserver<ArticleServiceOuterClass.UpdateArticleResponse> responseObserver) {
        Optional<ArticleServiceOuterClass.UpdateArticleResponse> updateArticleResponse =
                articleService.updateArticle(request.getArticle().getId(), request);

        if(!updateArticleResponse.isPresent()) {
            responseObserver.onError(Status.UNKNOWN.withDescription("Could not update a article! Try again!").asRuntimeException());
        } else {
            responseObserver.onNext(updateArticleResponse.get());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void deleteArticle(ArticleServiceOuterClass.DeleteArticleRequest request, StreamObserver<ArticleServiceOuterClass.DeleteArticleResponse> responseObserver) {
        Optional<ArticleServiceOuterClass.DeleteArticleResponse> deleteArticleResponse =
                articleService.deleteArticle(request.getArticleId(), request);

        if(!deleteArticleResponse.isPresent()) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("No article exists with given Id!").asRuntimeException());
        } else {
            responseObserver.onNext(deleteArticleResponse.get());
        }
        responseObserver.onCompleted();
    }
}
