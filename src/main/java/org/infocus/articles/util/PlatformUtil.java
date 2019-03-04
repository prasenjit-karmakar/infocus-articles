package org.infocus.articles.util;


import org.infocus.articles.util.constants.DataConstants;
import org.infocus.articles.util.exception.PlatformException;
import org.springframework.http.HttpStatus;

/**
 * Class to containt utility methods.
 *
 * @author prasenjitkarmakar
 */
public final class PlatformUtil {

  private PlatformUtil() {
  }

  public static void validateGetAllArticlesRequest(Integer page, Integer size) {
    if (page != null && (page < DataConstants.MIN_PAGE_INDEX || page > DataConstants.MAX_PAGE_INDEX)) {
      String errorMessage = String.format("Page index should be between %s && %s", DataConstants.MIN_PAGE_INDEX,
          DataConstants.MAX_PAGE_INDEX);
      throw new PlatformException(HttpStatus.BAD_REQUEST, errorMessage);
    }

    if (size != null && (size < DataConstants.MIN_PAGE_SIZE || size > DataConstants.MAX_PAGE_SIZE)) {
      String errorMessage = String.format("Page size should be between %s && %s", DataConstants.MIN_PAGE_SIZE,
          DataConstants.MAX_PAGE_SIZE);
      throw new PlatformException(HttpStatus.BAD_REQUEST, errorMessage);
    }
  }
}
