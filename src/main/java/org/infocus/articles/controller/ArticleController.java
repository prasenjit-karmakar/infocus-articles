package org.infocus.articles.controller;

import org.infocus.articles.controller.assembler.ArticleAssembler;
import org.infocus.articles.controller.resource.ArticleRequest;
import org.infocus.articles.controller.resource.ArticleResponse;
import org.infocus.articles.controller.resource.ArticleView;
import org.infocus.articles.entity.Article;
import org.infocus.articles.service.ArticleService;
import org.infocus.articles.util.PlatformUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Article controller class.
 *
 * @author prasenjitkarmakar
 */
@RestController
@RequestMapping("/api/v0/infocus")
public class ArticleController {

  private final ArticleService articleService;

  public ArticleController(ArticleService articleService) {
    this.articleService = articleService;
  }

  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @PostMapping(value = "/articles", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces =
      MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<ArticleResponse> createArticle(@Valid @RequestBody ArticleRequest articleRequest) {
    final Article article = articleService.postArticle(ArticleAssembler.toArticleEntity(articleRequest));
    return new ResponseEntity(ArticleAssembler.toBaseArticleResponse(article), HttpStatus.OK);
  }

  @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
  @GetMapping("/articles/{articleId}")
  public ResponseEntity<ArticleResponse> getArticle(@PathVariable("articleId") @NotNull final String articleId) {
    final Article article = articleService.getArticle(articleId);
    return new ResponseEntity(ArticleAssembler.toArticleResponse(article), HttpStatus.OK);
  }

  @GetMapping(value = "/view/articles/{articleId}", produces = MediaType.TEXT_HTML_VALUE)
  public ModelAndView viewArticle(@PathVariable("articleId") @NotNull final String articleId) {
    final Article article = articleService.getArticle(articleId);
    final ArticleView articleViewResource = getArticleView(article);
    ModelAndView articleView = new ModelAndView();
    articleView.addObject("article", articleViewResource);
    articleView.setViewName("article");
    return articleView;
  }
  
  @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
  @GetMapping("/articles")
  public ResponseEntity<ArticleResponse> getAllArticles(@RequestParam(value = "page", required = false) Integer page,
      @RequestParam(value = "size", required = false) Integer size) {
    PlatformUtil.validateGetAllArticlesRequest(page, size);
    final List<Article> articles = articleService.getAllArticles(page, size);
    return new ResponseEntity(articles.stream().map(article -> ArticleAssembler.toBaseArticleResponse(article))
        .collect(Collectors.toList()), HttpStatus.OK);
  }

  private ArticleView getArticleView(Article article) {
    final ArticleView articleViewResource = new ArticleView();
    articleViewResource.setId(article.getId());
    articleViewResource.setName(article.getName());
    articleViewResource.setAuthor(article.getAuthor());
    articleViewResource.setSections(Arrays.asList(article.getContent().split("\\n")));
    return articleViewResource;
  }
}
