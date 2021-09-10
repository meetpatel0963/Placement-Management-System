package com.jobportal.articleservice.service;

import com.jobportal.articleservice.model.Article;
import com.jobportal.articleservice.repository.ArticleRepository;
import com.jobportal.articleservice.repository.CommentRepository;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.Comment;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;

    public Comment getCommentDetailsFromModel(com.jobportal.articleservice.model.Comment comment) {
        Comment _comment = Comment.newBuilder()
                .setId(comment.getId())
                .setAuthor(comment.getAuthor())
                .setBody(comment.getBody())
                .setUpvotes(comment.getUpvotes())
                .setDownvotes(comment.getDownvotes())
                .addAllReplies(comment.getReplies())
                .setArticleId(comment.getArticle().getId())
                .setCreatedAt(comment.getCreatedAt().toString())
                .setUpdatedAt(comment.getUpdatedAt().toString())
                .build();
        return _comment;
    }

    Optional<com.jobportal.articleservice.model.Comment> getCommentDetailsFromProto(Long articleId, Comment comment) {
        Optional<Article> article = articleRepository.findById(articleId);
        if (!article.isPresent()) {
            return Optional.empty();
        } else {
            com.jobportal.articleservice.model.Comment _comment =
                    new com.jobportal.articleservice.model.Comment(
                            comment.getId(),
                            comment.getAuthor(),
                            comment.getBody(),
                            comment.getUpvotes(),
                            comment.getDownvotes(),
                            comment.getRepliesList(),
                            (Article)article.get());
            return Optional.of(_comment);
        }
    }

    public GetAllCommentsResponse getAllComments(GetAllCommentsRequest request) {
        List<com.jobportal.articleservice.model.Comment> comments = commentRepository.findAll();
        List<Comment> commentsList = new ArrayList();

        for(com.jobportal.articleservice.model.Comment comment : comments) {
            Comment commentProto = getCommentDetailsFromModel(comment);
            commentsList.add(commentProto);
        }

        return GetAllCommentsResponse.newBuilder().addAllComments(commentsList).build();
    }

    public Optional<GetCommentByIdResponse> getCommentById(Long commentId, GetCommentByIdRequest request) {
        Optional<com.jobportal.articleservice.model.Comment> comment = commentRepository.findById(commentId);
        if (!comment.isPresent()) {
            return Optional.empty();
        } else {
            Comment commentProto = getCommentDetailsFromModel(comment.get());
            return Optional.of(GetCommentByIdResponse.newBuilder().setComment(commentProto).build());
        }
    }

    public Optional<SaveCommentResponse> saveComment(Long articleId, SaveCommentRequest request) {
        Optional<com.jobportal.articleservice.model.Comment> comment =
                getCommentDetailsFromProto(articleId, request.getComment());
        if (!comment.isPresent()) {
            return Optional.empty();
        } else {
            commentRepository.save(comment.get());
            return Optional.of(SaveCommentResponse.newBuilder().setMessage("New Comment Added!").build());
        }
    }

    public Optional<UpdateCommentResponse> updateComment(Long articleId, Long commentId, UpdateCommentRequest request) {
        Optional<com.jobportal.articleservice.model.Comment> comment = commentRepository.findById(commentId);
        if (!comment.isPresent()) {
            return Optional.empty();
        } else {
            Optional<com.jobportal.articleservice.model.Comment> newComment =
                    getCommentDetailsFromProto(articleId, request.getComment());
            if (!newComment.isPresent()) {
                return Optional.empty();
            } else {
                commentRepository.save(newComment.get());
                return Optional.of(UpdateCommentResponse.newBuilder().setMessage("Comment Updated Successfully!").build());
            }
        }
    }

    public Optional<DeleteCommentResponse> deleteComment(Long commentId, DeleteCommentRequest request) {
        Optional<com.jobportal.articleservice.model.Comment> comment = commentRepository.findById(commentId);
        if (!comment.isPresent()) {
            return Optional.empty();
        } else {
            commentRepository.delete(comment.get());
            return Optional.of(DeleteCommentResponse.newBuilder().setMessage("Comment Deleted Successfully!").build());
        }
    }

    public GetAllCommentsByArticleIdResponse getAllCommentsByArticleId(
            Long articleId,
            GetAllCommentsByArticleIdRequest getAllCommentsByArticleIdRequest, Pageable pageable) {

        Page<com.jobportal.articleservice.model.Comment> comments = commentRepository.findByArticleId(articleId, pageable);
        ArrayList<Comment> _comments = new ArrayList();

        for(com.jobportal.articleservice.model.Comment comment : comments) {
            _comments.add(getCommentDetailsFromModel(comment));
        }

        return GetAllCommentsByArticleIdResponse.newBuilder().addAllComments(_comments).build();
    }
}
