package org.infocus.articles.entity;

import org.infocus.articles.entity.listener.AuditListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Represents a base entity for audit.
 *
 * @author prasenjitkarmakar 
 */

@EntityListeners(AuditListener.class)
@MappedSuperclass
public class AuditEntity {

  @Column(name = "created_date", updatable = false, nullable = false)
  @CreatedDate
  @Temporal(TemporalType.TIMESTAMP)
  private Date createdDate;

  @CreatedBy
  @Column(name = "created_by", updatable = false, nullable = false)
  private String createdBy;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "last_modified_date", nullable = false)
  @LastModifiedDate
  private Date lastModifiedDate;

  @LastModifiedBy
  @Column(name = "last_modified_by", nullable = false)
  private String lastModifiedBy;

  /**
   * Empty constructor.
   */
  public AuditEntity() {
    // This constructor is intentionally empty.
  }

  /**
   * All args constructor for AuditEntity.
   *
   * @param createdDate      createdDate
   * @param createdBy        createdBy
   * @param lastModifiedDate lastModifiedDate
   * @param lastModifiedBy   lastModifiedBy
   */
  public AuditEntity(Date createdDate, String createdBy, Date lastModifiedDate, String lastModifiedBy) {
    this.createdDate = createdDate;
    this.createdBy = createdBy;
    this.lastModifiedDate = lastModifiedDate;
    this.lastModifiedBy = lastModifiedBy;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public Date getLastModifiedDate() {
    return lastModifiedDate;
  }

  public String getLastModifiedBy() {
    return lastModifiedBy;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public void setLastModifiedDate(Date lastModifiedDate) {
    this.lastModifiedDate = lastModifiedDate;
  }

  public void setLastModifiedBy(String lastModifiedBy) {
    this.lastModifiedBy = lastModifiedBy;
  }
  
}
