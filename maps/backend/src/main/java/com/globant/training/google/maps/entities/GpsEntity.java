package com.globant.training.google.maps.entities;

import java.util.Date;

/**
 * Class to represent a GPS entity
 * 
 * @author gabriel.sideri
 */
public class GpsEntity extends BaseEntity implements Device {

  private String name;

  private String serialNumber;

  private DeviceType type;

  private boolean active;

  private Date created;

  private Date lastUpdated;

  /*
   * (non-Javadoc)
   * 
   * @see com.example.helloendpoints.entities.Device#getName()
   */
  @Override
  public String getName() {
    return name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.example.helloendpoints.entities.Device#setName(java.lang.String)
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets GPS serial number.
   * 
   * @return the GPS serial number
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * Sets the GPS serial number
   * 
   * @param serialNumber the GPS serial number.
   */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Gets the {@link DeviceType}.
   * 
   * @return the Device Type
   */
  public DeviceType getType() {
    return type;
  }

  /**
   * Set the {@link DeviceType}.
   * 
   * @param type the Device Type
   */
  public void setType(DeviceType type) {
    this.type = type;
  }

  /**
   * Returns <b>true</b> if GPS is active, otherwise <b>false</b>
   * 
   * @return if GPS is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets flag to indicate if GPS is active or not.
   * 
   * @param active true or false
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Gets the date where the GPS was created
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the date where the GPS was created.
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
