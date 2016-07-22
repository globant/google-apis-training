package com.globant.training.google.maps.entities;

import com.googlecode.objectify.annotation.Entity;

import java.util.Date;

/**
 * Class to represent an Antenna used by RFID Devices.
 * 
 * @author gabriel.sideri
 *
 */
@Entity(name = "Antenna")
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
  public Antenna setLatitude(Double latitude) {
    this.latitude = latitude;
    return this;
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
  public Antenna setLongitude(Double longitude) {
    this.longitude = longitude;
    return this;
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
  public Antenna setActive(boolean active) {
    this.active = active;
    return this;
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
  public Antenna setCreated(Date created) {
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
  public Antenna setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
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
  public Antenna setName(String name) {
    this.name = name;
    return this;
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
  public Antenna setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
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
  public Antenna setRangeLimit(Double rangeLimit) {
    this.rangeLimit = rangeLimit;
    return this;
  }

}
