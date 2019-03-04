package org.infocus.articles.controller.advice;

import org.infocus.articles.util.exception.ErrorResource;
import org.infocus.articles.util.exception.PlatformException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonControllerAdvice {

  @ExceptionHandler(PlatformException.class)
  public ResponseEntity handlePlatformException(final PlatformException e) {
    final ErrorResource errorResource = new ErrorResource();
    errorResource.setMessage(e.getMessage());
    errorResource.setCode(e.getHttpStatus().getReasonPhrase());
    return new ResponseEntity(errorResource, e.getHttpStatus());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity handleUnknownException(final Exception e) {
    final ErrorResource errorResource = new ErrorResource();
    errorResource.setMessage(e.getMessage());
    errorResource.setCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
    return new ResponseEntity(errorResource, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
