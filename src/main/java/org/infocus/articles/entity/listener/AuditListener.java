package org.infocus.articles.entity.listener;

import org.infocus.articles.entity.AuditEntity;
import org.infocus.articles.util.constants.DataConstants;

import java.time.Instant;
import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * Class to populate audit fields for each database operation.
 *
 * @param <T> AuditEntity
 */
public class AuditListener<T extends AuditEntity> {

  @PrePersist
  private void beforeInsert(T auditEntity) {
    auditEntity.setCreatedBy(DataConstants.CREATED_BY);
    Date createdDate = Date.from(Instant.now());
    auditEntity.setCreatedDate(createdDate);
    auditEntity.setLastModifiedBy(DataConstants.LAST_MODIFIED_BY);
    auditEntity.setLastModifiedDate(createdDate);
  }

  @PreUpdate
  private void beforeUpdate(T auditEntity) {
    auditEntity.setLastModifiedBy(DataConstants.LAST_MODIFIED_BY);
    auditEntity.setLastModifiedDate(Date.from(Instant.now()));
  }

}