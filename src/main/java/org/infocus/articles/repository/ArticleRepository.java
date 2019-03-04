package org.infocus.articles.repository;

import org.infocus.articles.entity.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

/**
 * Article repository class.
 *
 * @author prasenjitkarmakar
 */

public interface ArticleRepository extends PagingAndSortingRepository<Article, String> {
  
  Optional<Article> findByNameInIgnoreCase(String name);
  
}
