package com.jobportal.articleservice.controller;

import com.jobportal.articleservice.exception.InternalServerErrorException;
import com.jobportal.articleservice.exception.ResourceNotFoundException;
import com.jobportal.articleservice.repository.ArticleRepository;
import com.jobportal.articleservice.service.ArticleService;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllArticles(@RequestBody GetAllArticlesRequest getAllArticlesRequest) {
        return ResponseEntity.ok(articleService.getAllArticles(getAllArticlesRequest));
    }

    @GetMapping(path = "/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getArticleById(@PathVariable Long articleId, @RequestBody GetArticleByIdRequest getArticleByIdRequest) {
        Optional<GetArticleByIdResponse> getArticleByIdResponse = articleService.getArticleById(articleId, getArticleByIdRequest);
        return !getArticleByIdResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Article", "id"))
                : ResponseEntity.ok(getArticleByIdResponse.get());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> saveArticle(@RequestBody SaveArticleRequest saveArticleRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(articleService.saveArticle(saveArticleRequest));
    }

    @PutMapping(path = "/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateArticle(@PathVariable Long articleId, @RequestBody UpdateArticleRequest updateArticleRequest) {
        Optional<UpdateArticleResponse> updateArticleResponse = articleService.updateArticle(articleId, updateArticleRequest);
        return !updateArticleResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new InternalServerErrorException("Couldn't update a article! Try again!"))
                : ResponseEntity.ok(updateArticleResponse.get());
    }

    @DeleteMapping(path = "/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteArticle(@PathVariable Long articleId, @RequestBody DeleteArticleRequest deleteArticleRequest) {
        Optional<DeleteArticleResponse> deleteArticleResponse = articleService.deleteArticle(articleId, deleteArticleRequest);
        return !deleteArticleResponse.isPresent()
                ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResourceNotFoundException("Article", "id"))
                : ResponseEntity.ok(deleteArticleResponse.get());
    }

}
