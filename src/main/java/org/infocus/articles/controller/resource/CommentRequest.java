package org.infocus.articles.controller.resource;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Article request resource.
 *
 * @author prasenjitkarmakar
 */
public class CommentRequest {
  
  @NotBlank(message = "Username cannot be empty")
  private String username;
  
  @NotBlank(message = "Comment cannot be empty")
  private String comment;

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
}
