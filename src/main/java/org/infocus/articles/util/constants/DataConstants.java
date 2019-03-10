package org.infocus.articles.util.constants;

import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Class to define application constants.
 *
 * @author prasenjitkarmakar
 */
public final class DataConstants {

  public static final String CREATED_BY = "SYSTEM";
  public static final String LAST_MODIFIED_BY = "SYSTEM";
  public static final String HOST_URL = "http://www.infocussocial.org.in/api/v0/infocus/view/articles/";
  public static final int DEFAULT_PAGE_INDEX = 0;
  public static final int MIN_PAGE_INDEX = 0;
  public static final int DEFAULT_PAGE_SIZE = 10;
  public static final int MIN_PAGE_SIZE = 1;
  public static final int MAX_PAGE_SIZE = 10;
  public static final String DEFAULT_SORT_BY = "createdDate";
  public static final int MAX_PAGE_INDEX = 10;

  private DataConstants() {
  }
}
