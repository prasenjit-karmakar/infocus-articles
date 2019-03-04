package org.infocus.articles.service;

import org.infocus.articles.entity.Article;
import org.infocus.articles.repository.ArticleRepository;
import org.infocus.articles.util.constants.DataConstants;
import org.infocus.articles.util.exception.PlatformException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * Article service class.
 *
 * @author prasenjitkarmakar
 */
@Service
public class ArticleService {
  private static final Logger logger = LoggerFactory.getLogger(ArticleService.class);

  private final ArticleRepository articleRepository;

  public ArticleService(ArticleRepository articleRepository) {
    this.articleRepository = articleRepository;
  }

  public Article postArticle(Article article) {
    if (article != null) {
      Optional<Article> existingArticle = articleRepository.findByNameInIgnoreCase(article.getName());
      if (existingArticle.isPresent()) {
        String errorMessage = String.format("Article already exists with name %s", article.getName());
        throw new PlatformException(HttpStatus.BAD_REQUEST, errorMessage);
      }
    }
    article.setId(UUID.randomUUID().toString());
    return articleRepository.save(article);
  }

  public Article getArticle(String articleId) {
    Optional<Article> article = articleRepository.findById(articleId);
    if (article.isPresent()) {
      return article.get();
    }
    String errorMessage = String.format("Article not found for id %s", articleId.toString());
    throw new PlatformException(HttpStatus.NOT_FOUND, errorMessage);
  }

  public List<Article> getAllArticles(Integer page, Integer size) {
    if (page == null) {
      page = DataConstants.DEFAULT_PAGE_INDEX;
    }
    if (size == null) {
      size = DataConstants.DEFAULT_PAGE_SIZE;
    }
    Pageable sortedByCreationDate = PageRequest.of(page, size, Sort.by(DataConstants.DEFAULT_SORT_BY).descending());
    Page<Article> articles = articleRepository.findAll(sortedByCreationDate);
    if (articles.isEmpty()) {
      throw new PlatformException(HttpStatus.NOT_FOUND, "No articles found");
    }
    return articles.getContent();
  }
}
