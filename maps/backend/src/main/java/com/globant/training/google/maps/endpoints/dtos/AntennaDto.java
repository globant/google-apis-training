package com.globant.training.google.maps.endpoints.dtos;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.globant.training.google.maps.endpoints.validation.DtoValidator;
import com.globant.training.google.maps.entities.Antenna;

/**
 * Antenna DTO.
 * 
 * @author gabriel.sideri
 */
public class AntennaDto implements Dto<Antenna> {
 
  @NotNull
  private String name;

  @NotNull
  private String serialNumber;

  private Double latitude;

  private Double longitude;

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
  public AntennaDto setLatitude(Double latitude) {
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
  public AntennaDto setLongitude(Double longitude) {
    this.longitude = longitude;
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
  public AntennaDto setCreated(Date created) {
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
  public AntennaDto setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  public String getName() {
    return name;
  }

  public AntennaDto setName(String name) {
    this.name = name;
    return this;
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public AntennaDto setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
    return this;
  }

  public Double getRangeLimit() {
    return rangeLimit;
  }

  public AntennaDto setRangeLimit(Double rangeLimit) {
    this.rangeLimit = rangeLimit;
    return this;
  }

  @Override
  public Antenna toEntity() {
    DtoValidator.validate(this);
    
    Antenna antenna = new Antenna()
           .setName(name)
           .setLatitude(latitude)
           .setLongitude(longitude)
           .setRangeLimit(rangeLimit)
           .setSerialNumber(serialNumber);
    
    return antenna;
  }
  
  @Override
  public void fromEntity(Antenna antenna) {
    this.name = antenna.getName();
    this.serialNumber = antenna.getSerialNumber();
    this.latitude = antenna.getLatitude();
    this.longitude = antenna.getLongitude();
    this.created = antenna.getCreated();
    this.lastUpdated = antenna.getLastUpdated();
    this.rangeLimit = antenna.getRangeLimit();
  }
}
