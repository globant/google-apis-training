package com.globant.training.google.maps.item.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

import com.globant.training.google.maps.core.entity.BaseEntity;
import com.globant.training.google.maps.device.entity.DeviceType;

import java.util.Date;

/**
 * Class to represent the Item to be Tracked by the Devices.
 * 
 * @author gabriel.sideri
 */
@Entity(name = "Item")
public class Item extends BaseEntity {

  private String name;

  @Index
  private Long deviceId;

  private boolean active;

  private Date created;

  private Date lastUpdated;
  
  @Ignore
  private String deviceName;
  
  @Ignore
  private DeviceType deviceType;

  @Ignore
  public static final String DEVICE_ID_FIELD = "deviceId";
  
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
  public Item setName(String name) {
    this.name = name;
    return this;
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
  public Item setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
    return this;
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
  public Item setActive(boolean active) {
    this.active = active;
    return this;
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
  public Item setCreated(Date created) {
    this.created = created;
    return this;
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
  public Item setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * Gets device name.
   * 
   * @return the associated device name
   */
  public String getDeviceName() {
    return deviceName;
  }

  /**
   * Sets the device name.
   * 
   * @param deviceName the device name
   */
  public void setDeviceName(String deviceName) {
    this.deviceName = deviceName;
  }

  /**
   * Gets device Type.
   * 
   * @return the device Type
   */
  public DeviceType getDeviceType() {
    return deviceType;
  }

  /**
   * Sets the device type.
   * 
   * @param deviceType the device type
   */
  public void setDeviceType(DeviceType deviceType) {
    this.deviceType = deviceType;
  }

}
