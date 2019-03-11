package org.infocus.articles.service;

import org.infocus.articles.entity.Article;
import org.infocus.articles.entity.Comment;
import org.infocus.articles.repository.ArticleRepository;
import org.infocus.articles.repository.CommentRepository;
import org.infocus.articles.util.exception.PlatformException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


/**
 * Comment service class.
 *
 * @author prasenjitkarmakar
 */
@Service
public class CommentService {
  private static final Logger logger = LoggerFactory.getLogger(CommentService.class);

  private final CommentRepository commentRepository;
  private final ArticleRepository articleRepository;

  public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
    this.commentRepository = commentRepository;
    this.articleRepository = articleRepository;
  }

  public Comment postComment(Comment comment, String articleId) {
    Optional<Article> existingArticle = articleRepository.findById(articleId);
    if (!existingArticle.isPresent()) {
      String errorMessage = String.format("Article not found with id %s", articleId);
      throw new PlatformException(HttpStatus.NOT_FOUND, errorMessage);
    }
    comment.setId(UUID.randomUUID().toString());
    comment.setArticle(existingArticle.get());
    return commentRepository.save(comment);
  }

}
