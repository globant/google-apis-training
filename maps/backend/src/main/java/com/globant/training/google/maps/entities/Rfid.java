package com.globant.training.google.maps.entities;

import java.util.Date;
import java.util.Map;

/**
 * Class to represent a RFID entity
 * 
 * @author gabriel.sideri
 */
public class Rfid extends BaseEntity implements Device {

  private String name;

  private long rfidId;

  private DeviceType type;

  private String manufacturer;

  private Map<String, String> data;

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
   * Gets the RFID ID.
   * 
   * @return the RFID ID assigned
   */
  public long getRfidId() {
    return rfidId;
  }

  /**
   * Sets the RFID ID.
   * 
   * @param rfidId the RFID ID
   */
  public void setRfidId(long rfidId) {
    this.rfidId = rfidId;
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
   * Gets the Manufacturer Name.
   * 
   * @return the Manufacturer name
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Sets the Manufacturer Name.
   * 
   * @param manufacturer the manufacturer
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Gets a Map with Additional information if was provided.
   * 
   * @return A Map with additional information
   */
  public Map<String, String> getData() {
    return data;
  }

  /**
   * Sets a Map With Additional information.
   * 
   * @param data Map with additional information
   */
  public void setData(Map<String, String> data) {
    this.data = data;
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
