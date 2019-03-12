package org.infocus.articles.controller.assembler;

import org.infocus.articles.controller.resource.CommentRequest;
import org.infocus.articles.controller.resource.CommentResponse;
import org.infocus.articles.entity.Comment;


/**
 * Assembler class for post comment request and response.
 *
 * @author prasenjitkarmakar
 */
public final class CommentAssembler {

  private CommentAssembler() {
  }

  public static Comment toCommentEntity(CommentRequest commentRequest) {
    final Comment comment = new Comment();
    comment.setUsername(commentRequest.getUsername());
    comment.setComment(commentRequest.getComment());
    comment.setEmail(commentRequest.getEmail());
    return comment;
  }

  public static CommentResponse toCommentResponse(Comment comment) {
    final CommentResponse commentResponse = new CommentResponse();
    commentResponse.setUsername(comment.getUsername());
    commentResponse.setId(comment.getId());
    commentResponse.setComment(comment.getComment());
    return commentResponse;
  }

}
