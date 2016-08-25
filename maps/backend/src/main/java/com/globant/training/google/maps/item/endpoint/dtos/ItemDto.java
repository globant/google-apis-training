package com.globant.training.google.maps.item.endpoint.dtos;

import com.globant.training.google.maps.core.endpoint.dto.Dto;
import com.globant.training.google.maps.device.entity.DeviceType;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Item DTO.
 * 
 * @author gabriel.sideri
 */
public class ItemDto implements Dto {

  private static final long serialVersionUID = 1L;

  private Long id;

  @NotNull
  private String name;

  private Long deviceId;
  
  private String deviceName;
  
  private DeviceType deviceType;
  
  private boolean active;

  private Date created;

  private Date lastUpdated;

  /**
   * Gets item id.
   * 
   * @return the item id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets item id.
   * 
   * @param id the item id
   */
  public ItemDto setId(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get item name.
   * 
   * @return the item name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the item name.
   * 
   * @param name the item name
   */
  public ItemDto setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Return <b>true</b> if the item is active, otherwise <b>false</b>.
   * 
   * @return a flag to indicate if the item is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets the flag if the item is active or not.
   * 
   * @param active the boolean value
   */
  public ItemDto setActive(boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Sets the date when the item was created.
   * 
   * @param created the date
   */
  public ItemDto setCreated(Date created) {
    this.created = created;
    return this;
  }

  /**
   * Gets the date when the item was created
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
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
  public ItemDto setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
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
  public ItemDto setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
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
