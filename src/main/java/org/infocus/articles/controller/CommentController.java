package org.infocus.articles.controller;

import org.infocus.articles.controller.assembler.CommentAssembler;
import org.infocus.articles.controller.resource.CommentRequest;
import org.infocus.articles.controller.resource.CommentResponse;
import org.infocus.articles.entity.Comment;
import org.infocus.articles.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Comment controller class.
 *
 * @author prasenjitkarmakar
 */
@RestController
@RequestMapping("/api/v0/infocus/articles")
public class CommentController {

  private final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @PreAuthorize("hasRole('ROLE_USER')")
  @PostMapping(value = "/{ARTICLE_ID}/comments", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces =
      MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<CommentResponse> postComment(@PathVariable("ARTICLE_ID") String articleId,
      @Valid @RequestBody CommentRequest commentRequest) {
    final Comment comment = commentService.postComment(CommentAssembler.toCommentEntity(commentRequest), articleId);
    return new ResponseEntity(CommentAssembler.toCommentResponse(comment), HttpStatus.OK);
  }

}
