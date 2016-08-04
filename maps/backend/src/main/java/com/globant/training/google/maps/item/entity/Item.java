package com.globant.training.google.maps.item.entity;

import com.googlecode.objectify.annotation.Entity;

import com.globant.training.google.maps.core.entity.BaseEntity;

import java.util.Date;

/**
 * Class to represent the Item to be Tracked by the Devices.
 * 
 * @author gabriel.sideri
 */
@Entity(name = "Item")
public class Item extends BaseEntity {

  private String name;

  private Long deviceId;

  private boolean active;

  private Date created;

  private Date lastUpdated;

  /**
   * Gets item´s name.
   * 
   * @return the item´s name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the item´s name.
   * 
   * @param name the item name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get device id associated with the item.
   * 
   * @return device id
   */
  public Long getDeviceId() {
    return deviceId;
  }

  /**
   * Associate device with the item.
   * 
   * @param deviceId the device id
   */
  public void setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
  }

  /**
   * Returns <b>true</b> if the item is active, otherwise <b>false</b>
   * 
   * @return if item is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets a flag to indicate if the item is active or not.
   * 
   * @param active true or false
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Gets the date where the Item was created
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the date where the Item was created.
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
