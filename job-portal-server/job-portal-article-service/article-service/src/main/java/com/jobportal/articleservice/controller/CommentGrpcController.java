package com.jobportal.articleservice.controller;

import com.jobportal.articleservice.config.LogGrpcInterceptor;
import com.jobportal.articleservice.service.CommentService;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass;
import com.jobportal.articleserviceproto.CommentServiceGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@GrpcService(interceptors = { LogGrpcInterceptor.class })
@CrossOrigin
public class CommentGrpcController extends CommentServiceGrpc.CommentServiceImplBase {

    @Autowired
    private CommentService commentService;

    @Override
    public void getAllComments(ArticleServiceOuterClass.GetAllCommentsRequest request,
                               StreamObserver<ArticleServiceOuterClass.GetAllCommentsResponse> responseObserver) {
        responseObserver.onNext(commentService.getAllComments(request));
        responseObserver.onCompleted();
    }

    @Override
    public void getCommentById(ArticleServiceOuterClass.GetCommentByIdRequest request,
                               StreamObserver<ArticleServiceOuterClass.GetCommentByIdResponse> responseObserver) {
        Optional<ArticleServiceOuterClass.GetCommentByIdResponse> getCommentByIdResponse =
                commentService.getCommentById(request.getCommentId(), request);

        if(!getCommentByIdResponse.isPresent()) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("No comment exists with given Id!").asRuntimeException());
        } else {
            responseObserver.onNext(getCommentByIdResponse.get());
        }

        responseObserver.onCompleted();
    }

    @Override
    public void saveComment(ArticleServiceOuterClass.SaveCommentRequest request,
                            StreamObserver<ArticleServiceOuterClass.SaveCommentResponse> responseObserver) {
        Optional<ArticleServiceOuterClass.SaveCommentResponse> saveCommentResponse =
                commentService.saveComment(request.getComment().getArticleId(), request);

        if(!saveCommentResponse.isPresent()) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("Couldn't save a comment. " +
                    "No article exists with given Id!").asRuntimeException());
        } else {
            responseObserver.onNext(saveCommentResponse.get());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void updateComment(ArticleServiceOuterClass.UpdateCommentRequest request,
                              StreamObserver<ArticleServiceOuterClass.UpdateCommentResponse> responseObserver) {
        Optional<ArticleServiceOuterClass.UpdateCommentResponse> updateCommentResponse =
                commentService.updateComment(request.getComment().getArticleId(),
                        request.getComment().getId(),
                        request);

        if(!updateCommentResponse.isPresent()) {
            responseObserver.onError(Status.UNKNOWN.withDescription("Could not update a comment! Try again!").asRuntimeException());
        } else {
            responseObserver.onNext(updateCommentResponse.get());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void deleteComment(ArticleServiceOuterClass.DeleteCommentRequest request,
                        StreamObserver<ArticleServiceOuterClass.DeleteCommentResponse> responseObserver) {
        Optional<ArticleServiceOuterClass.DeleteCommentResponse> deleteCommentResponse =
                commentService.deleteComment(request.getCommentId(), request);

        if(!deleteCommentResponse.isPresent()) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("No comment exists with given Id!").asRuntimeException());
        } else {
            responseObserver.onNext(deleteCommentResponse.get());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void getAllCommentsByArticleId(ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest request,
                                          StreamObserver<ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse> responseObserver) {
        if(request.getPage() < 0 || request.getSize() < 1){
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Page number must be greater than 0 and " +
                    "page size must be greater than 1.").asRuntimeException());
        } else {
            Pageable pageable = PageRequest.of(request.getPage(), request.getSize());

            Optional<ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse> getAllCommentsByArticleIdResponse =
                    commentService.getAllCommentsByArticleId(request.getArticleId(), request, pageable);

            if (!getAllCommentsByArticleIdResponse.isPresent()) {
                responseObserver.onError(Status.NOT_FOUND.withDescription("Couldn't save a comment.").asRuntimeException());
            } else {
                responseObserver.onNext(getAllCommentsByArticleIdResponse.get());
            }
        }
        responseObserver.onCompleted();
    }
}
