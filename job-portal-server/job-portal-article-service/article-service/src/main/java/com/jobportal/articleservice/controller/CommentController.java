package com.jobportal.articleservice.controller;

import com.jobportal.articleservice.exception.InternalServerErrorException;
import com.jobportal.articleservice.exception.ResourceNotFoundException;
import com.jobportal.articleservice.repository.CommentRepository;
import com.jobportal.articleservice.service.CommentService;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteCommentResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsByArticleIdRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllCommentsRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetCommentByIdResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveCommentResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateCommentResponse;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentService commentService;

    @GetMapping(path = "/comment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllComments(@RequestBody GetAllCommentsRequest getAllCommentsRequest) {
        return ResponseEntity.ok(commentService.getAllComments(getAllCommentsRequest));
    }

    @GetMapping(path = "/comment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getCommentById(@PathVariable Long commentId, @RequestBody GetCommentByIdRequest getCommentByIdRequest) {
        Optional<GetCommentByIdResponse> getCommentByIdResponse = commentService.getCommentById(commentId, getCommentByIdRequest);
        return !getCommentByIdResponse.isPresent() ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Comment", "id"))
                : ResponseEntity.ok(getCommentByIdResponse.get());
    }

    @PostMapping(path = "/article/{articleId}/comment", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveComment(@PathVariable Long articleId, @RequestBody SaveCommentRequest saveCommentRequest) {
        Optional<SaveCommentResponse> saveCommentResponse = commentService.saveComment(articleId, saveCommentRequest);
        return !saveCommentResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Article", "id"))
                : ResponseEntity.status(HttpStatus.CREATED).body(saveCommentResponse.get());
    }

    @PutMapping(path = "/article/{articleId}/comment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateComment(@PathVariable Long articleId, @PathVariable Long commentId, @RequestBody UpdateCommentRequest updateCommentRequest) {
        Optional<UpdateCommentResponse> updateCommentResponse = commentService.updateComment(articleId, commentId, updateCommentRequest);
        return !updateCommentResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new InternalServerErrorException("Couldn't update a comment! Try again!"))
                : ResponseEntity.ok(updateCommentResponse.get());
    }

    @DeleteMapping(path = "/comment/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteComment(@PathVariable Long commentId, @RequestBody DeleteCommentRequest deleteCommentRequest) {
        Optional<DeleteCommentResponse> deleteCommentResponse = commentService.deleteComment(commentId, deleteCommentRequest);
        return !deleteCommentResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Comment", "id"))
                : ResponseEntity.ok(deleteCommentResponse.get());
    }

    @GetMapping(path = "/article/{articleId}/comments", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllCommentsByArticleId(@PathVariable Long articleId, @RequestBody GetAllCommentsByArticleIdRequest getAllCommentsByArticleIdRequest, Pageable pageable) {
        return ResponseEntity.ok(commentService.getAllCommentsByArticleId(articleId, getAllCommentsByArticleIdRequest, pageable));
    }
}
