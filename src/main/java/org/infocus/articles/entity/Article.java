package org.infocus.articles.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Article entity class.
 *
 * @author prasenjitkarmakar
 */
@Entity
@Table(name = "articles")
public class Article extends BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(unique = true, nullable = false)
  private String name;

  @Column(nullable = false)
  private String content;

  @Column(nullable = false)
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
