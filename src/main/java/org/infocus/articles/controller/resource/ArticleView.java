package org.infocus.articles.controller.resource;

import org.infocus.articles.entity.Comment;

import java.util.List;

/**
 * Article pebble resource for display.
 *
 * @author prasenjitkarmakar
 */
public class ArticleView {

  private String id;
  private String name;
  private String author;
  private List<String> sections;
  private List<Comment> comments;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

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

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }
}
