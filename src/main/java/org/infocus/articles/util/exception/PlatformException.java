package org.infocus.articles.util.exception;


import org.springframework.http.HttpStatus;

/**
 * Platform exception class.
 *
 * @author prasenjitkarmakar
 */
public class PlatformException extends RuntimeException {
  private final HttpStatus httpStatus;

  public PlatformException(HttpStatus httpStatus, String message) {
    super(message);
    this.httpStatus = httpStatus;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }
}
