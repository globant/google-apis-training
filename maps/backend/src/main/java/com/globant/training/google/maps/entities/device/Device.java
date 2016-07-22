package com.globant.training.google.maps.entities.device;

import java.util.Date;

import com.globant.training.google.maps.entities.BaseEntity;
import com.globant.training.google.maps.entities.DeviceType;
import com.googlecode.objectify.annotation.Entity;

/**
 * Represents a base device with common attributes accross devices.
 *
 */
@Entity(name = "Device")
public abstract class Device extends BaseEntity {

  protected String name;
  
  protected boolean active;

  protected Date created;

  protected Date lastUpdated;
  
  public abstract DeviceType getType();

  //public abstract void fill(Map<String, Object>);
  
  /**
   * Get device name.
   * 
   * @param name the device name.
   */
  public String getName() {
    return this.name;
  }

  /**
   * Set device name.
   * 
   * @param name the device name.
   */
  public void setName(final String name) {
    this.name = name;
  }
  
  /**
   * Returns <b>true</b> if RFID is active, otherwise <b>false</b>
   * 
   * @return if RFID is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets flag to indicate if RFID is active or not.
   * 
   * @param active true or false
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Gets the date where the RFID Device was created.
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the date where the RFID Device was created.
   * 
   * @param created the date
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Returns when the entity was modified.
   * 
   * @return last updated
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * Sets the last updated.
   * 
   * @param lastUpdated the last updated
   */
  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

}
