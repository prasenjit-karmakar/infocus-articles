/*
 * Copyright 2015, Optimal Payments PLC, 2 Place Alexis Nihon, suite 700, Westmount, Quebec, Canada
 * All rights reserved.
 * 
 * This software is the confidential and proprietary information of Optimal Payments PLC
 * ("Confidential Information"). You shall not disclose such Confidential Information and shall use
 * it only in accordance with the terms of the license agreement you entered into with Optimal
 * Payments.
 */

package org.infocus.articles.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Base class for all entity types.
 *
 * @author prasenjitkarmakar 
 */
@MappedSuperclass
public abstract class BaseEntity extends AuditEntity {

  @Id
  @Column(name = "id", nullable = false, unique = true)
  private String id;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  
  public BaseEntity(Date createdDate, String createdBy, Date lastModifiedDate, String lastModifiedBy, String id) {
    super(createdDate, createdBy, lastModifiedDate, lastModifiedBy);
    this.id = id;
  }

  /**
   * Empty constructor.
   */
  public BaseEntity() {
    super();
  }
}
