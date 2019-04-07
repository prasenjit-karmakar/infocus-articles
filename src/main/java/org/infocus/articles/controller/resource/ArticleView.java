package org.infocus.articles.controller.resource;

import java.util.List;

/**
 * Article pebble resource.
 *
 * @author prasenjitkarmakar
 */
public class ArticleView {

  private String name;
  private String author;
  private List<String> sections;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public List<String> getSections() {
    return sections;
  }

  public void setSections(List<String> sections) {
    this.sections = sections;
  }
}
