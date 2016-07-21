package com.globant.training.google.maps.entities;

import java.util.Date;

/**
 * Class to represent an Antenna used by RFID Devices.
 * 
 * @author gabriel.sideri
 *
 */
public class Antenna extends BaseEntity {

  private String name;

  private String serialNumber;

  private Double latitude;

  private Double longitude;

  private boolean active;

  private Date created;

  private Date lastUpdated;

  private Double rangeLimit;

  /**
   * Gets the Latitude where the Antenna is Located.
   * 
   * @return the Latitude
   */
  public Double getLatitude() {
    return latitude;
  }

  /**
   * Sets the Latitude where the Antenna is Located.
   * 
   * @param latitude the Latitude
   */
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  /**
   * Gets the Longitude where the Antenna is Located.
   * 
   * @return the longitude
   */
  public Double getLongitude() {
    return longitude;
  }

  /**
   * Sets the Longitude where the Antenna is Located.
   * 
   * @param longitude the longitude
   */
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  /**
   * Returns <b>true</b> if the Antenna is active, otherwise <b>false</b>
   * 
   * @return if the Antenna is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets flag to indicate if the Antenna is active or not.
   * 
   * @param active true or false
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Gets the date where the Antenna´s information was created
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the date where the Antenna´s information was created.
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

  /**
   * Gets antenna name.
   * 
   * @return the antenna name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the antenna name.
   * 
   * @param name the antenna name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets antenna serial number.
   * 
   * @return the antenna serial number
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * Sets the antenna serial number.
   * 
   * @param serialNumber the serial number
   */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Gets the antenna range limit.
   * 
   * @return the antenna range limit
   */
  public Double getRangeLimit() {
    return rangeLimit;
  }

  /**
   * Sets the antenna range limit.
   * 
   * @param rangeLimit the range limit
   */
  public void setRangeLimit(Double rangeLimit) {
    this.rangeLimit = rangeLimit;
  }

}
