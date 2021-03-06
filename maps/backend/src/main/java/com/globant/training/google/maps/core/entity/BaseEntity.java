package com.globant.training.google.maps.core.entity;

import com.googlecode.objectify.annotation.Id;

/**
 * Base Entity Class
 * 
 * @author gabriel.sideri
 */
public abstract class BaseEntity {

  @Id
  protected Long id;

  protected BaseEntity() {}

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    BaseEntity other = (BaseEntity) obj;
    if (id == null) {
      if (other.id != null) {
        return false;
      }
    } else if (!id.equals(other.id)) {
      return false;
    }
    return true;
  }

  /**
   * Get id.
   * 
   * @return id the device id
   */
  public Long getId() {
    return id;
  }

  /**
   * Set id.
   * 
   * @param id the device id
   */
  public BaseEntity setId(Long id) {
    this.id = id;
    return this;
  }

}
