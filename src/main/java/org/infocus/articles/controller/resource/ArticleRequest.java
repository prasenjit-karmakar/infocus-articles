package org.infocus.articles.controller.resource;

import org.hibernate.validator.constraints.NotBlank;

/**
 * Article request resource.
 *
 * @author prasenjitkarmakar
 */
public class ArticleRequest {
  
  @NotBlank(message = "Article name cannot be empty")
  private String name;
  @NotBlank(message = "Article content cannot be empty")
  private String content;
  @NotBlank(message = "Author cannot be empty")
  private String author;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }
}
