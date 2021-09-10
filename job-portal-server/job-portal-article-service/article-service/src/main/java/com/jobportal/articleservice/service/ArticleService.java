package com.jobportal.articleservice.service;

import com.jobportal.articleservice.repository.ArticleRepository;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.Article;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.Comment;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.DeleteArticleResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetAllArticlesResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.GetArticleByIdResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.SaveArticleResponse;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleRequest;
import com.jobportal.articleserviceproto.ArticleServiceOuterClass.UpdateArticleResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentService commentService;

    public Article getArticleDetailsFromModel(com.jobportal.articleservice.model.Article article) {
        Article _article =
                Article.newBuilder()
                        .setId(article.getId())
                        .setTitle(article.getTitle())
                        .setBody(article.getBody())
                        .setAuthor(article.getAuthor())
                        .setCompany(article.getCompany())
                        .setUpvotes(article.getUpvotes())
                        .setCreatedAt(article.getCreatedAt().toString())
                        .setUpdatedAt(article.getUpdatedAt().toString())
                        .build();
        return _article;
    }

    com.jobportal.articleservice.model.Article getArticleDetailsFromProto(Article article) {
        ArrayList<Comment> comments = new ArrayList(article.getCommentsList());
        ArrayList<com.jobportal.articleservice.model.Comment> _comments = new ArrayList();

        for(Comment comment : comments) {
            _comments.add(commentService.getCommentDetailsFromProto(article.getId(), comment).get());
        }

        com.jobportal.articleservice.model.Article _article =
                new com.jobportal.articleservice.model.Article(
                        article.getId(),
                        article.getTitle(),
                        article.getBody(),
                        article.getAuthor(),
                        article.getCompany(),
                        article.getUpvotes());
        return _article;
    }

    public GetAllArticlesResponse getAllArticles(GetAllArticlesRequest request) {
        List<com.jobportal.articleservice.model.Article> articles = articleRepository.findAll();
        List<Article> articlesList = new ArrayList();

        for(com.jobportal.articleservice.model.Article article : articles) {
            Article articleProto = getArticleDetailsFromModel(article);
            articlesList.add(articleProto);
        }

        return GetAllArticlesResponse.newBuilder().addAllArticles(articlesList).build();
    }

    public Optional<GetArticleByIdResponse> getArticleById(Long articleId, GetArticleByIdRequest request) {
        Optional<com.jobportal.articleservice.model.Article> article = articleRepository.findById(articleId);
        if (!article.isPresent()) {
            return Optional.empty();
        } else {
            Article articleProto =
                    getArticleDetailsFromModel(article.get());
            return Optional.of(GetArticleByIdResponse.newBuilder().setArticle(articleProto).build());
        }
    }

    public SaveArticleResponse saveArticle(SaveArticleRequest request) {
        com.jobportal.articleservice.model.Article article = getArticleDetailsFromProto(request.getArticle());
        articleRepository.save(article);
        return SaveArticleResponse.newBuilder().setMessage("New Article Added!").build();
    }

    public Optional<UpdateArticleResponse> updateArticle(Long articleId, UpdateArticleRequest request) {
        Optional<com.jobportal.articleservice.model.Article> article = articleRepository.findById(articleId);
        if (!article.isPresent()) {
            return Optional.empty();
        } else {
            com.jobportal.articleservice.model.Article newArticle =
                    getArticleDetailsFromProto(request.getArticle());
            articleRepository.save(newArticle);
            return Optional.of(UpdateArticleResponse.newBuilder().setMessage("Article Updated Successfully!").build());
        }
    }

    public Optional<DeleteArticleResponse> deleteArticle(Long articleId, DeleteArticleRequest request) {
        Optional<com.jobportal.articleservice.model.Article> article = articleRepository.findById(articleId);
        if (!article.isPresent()) {
            return Optional.empty();
        } else {
            articleRepository.delete(article.get());
            return Optional.of(DeleteArticleResponse.newBuilder().setMessage("Article Deleted Successfully!").build());
        }
    }
}
