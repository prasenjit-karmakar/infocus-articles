package org.infocus.articles.repository;

import org.infocus.articles.entity.Comment;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Comment repository class.
 *
 * @author prasenjitkarmakar
 */

public interface CommentRepository extends PagingAndSortingRepository<Comment, String> {
  
  List<Comment> findByUsername(String username);
  
}
