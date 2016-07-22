package com.globant.training.google.maps.entities;

import java.util.Date;
import java.util.List;

import com.globant.training.google.maps.entities.device.Device;

/**
 * Class to represent the Item to be Tracked by the Devices.
 * 
 * @author gabriel.sideri
 */
public class Item extends BaseEntity {

  private String name;

  private List<Device> devices;

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
   * Gets a list of devices which tracks the item.
   * 
   * @return a list of devices
   */
  public List<Device> getDevices() {
    return devices;
  }

  /**
   * Sets the list of devices to track the item.
   * 
   * @param devices a list of devices
   */
  public void setDevices(List<Device> devices) {
    this.devices = devices;
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
