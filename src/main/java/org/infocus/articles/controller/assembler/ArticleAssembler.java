package org.infocus.articles.controller.assembler;

import org.infocus.articles.controller.resource.ArticleRequest;
import org.infocus.articles.controller.resource.ArticleResponse;
import org.infocus.articles.controller.resource.BaseArticleResponse;
import org.infocus.articles.entity.Article;
import org.infocus.articles.util.constants.DataConstants;


/**
 * Assembler class for article request and response.
 *
 * @author prasenjitkarmakar
 */
public final class ArticleAssembler {

  private ArticleAssembler() {
  }

  public static Article toArticleEntity(ArticleRequest articleRequest) {
    final Article article = new Article();
    article.setName(articleRequest.getName());
    article.setContent(articleRequest.getContent());
    article.setAuthor(articleRequest.getAuthor());
    return article;
  }

  public static ArticleResponse toArticleResponse(Article article) {
    final ArticleResponse articleResponse = new ArticleResponse();
    articleResponse.setName(article.getName());
    articleResponse.setCreatedBy(article.getCreatedBy());
    articleResponse.setCreationDate(article.getCreatedDate());
    articleResponse.setLink(DataConstants.HOST_URL.concat(article.getId()));
    articleResponse.setContent(article.getContent());
    articleResponse.setAuthor(article.getAuthor());
    return articleResponse;
  }

  public static BaseArticleResponse toBaseArticleResponse(Article article) {
    final BaseArticleResponse articleResponse = new BaseArticleResponse();
    articleResponse.setName(article.getName());
    articleResponse.setCreationDate(article.getCreatedDate());
    articleResponse.setLink(DataConstants.HOST_URL.concat(article.getId()));
    articleResponse.setAuthor(article.getAuthor());
    return articleResponse;
  }
}
