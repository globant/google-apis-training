package com.globant.training.google.maps.antenna.endpoint.dtos;

import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.core.endpoint.dto.Dto;
import com.globant.training.google.maps.core.endpoint.validation.DtoValidator;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Antenna DTO.
 * 
 * @author gabriel.sideri
 */
public class AntennaDto implements Dto<Antenna, AntennaDto> {

  private Long id;

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
   * Gets antenna id.
   * 
   * @return the antenna id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets antenna id.
   * 
   * @param id the antenna id
   */
  public void setAntennaId(Long id) {
    this.id = id;
  }

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

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.endpoints.dtos.Dto#toEntity()
   */
  @Override
  public Antenna toEntity() {
    
    DtoValidator.validate(this);

    Antenna antenna = new Antenna().setName(name).setLatitude(latitude).setLongitude(longitude)
        .setRangeLimit(rangeLimit).setSerialNumber(serialNumber).setLastUpdated(new Date());

    if (this.getId() == null) {
      antenna.setCreated(new Date());
    } else {
      antenna.setId(id);
      antenna.setCreated(getCreated());
    }

    return antenna;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.endpoints.dtos.Dto#fromEntity(java.lang.Object)
   */
  @Override
  public AntennaDto fromEntity(Antenna antenna) {
    if (antenna != null) {
      this.id = antenna.getId();
      this.name = antenna.getName();
      this.serialNumber = antenna.getSerialNumber();
      this.latitude = antenna.getLatitude();
      this.longitude = antenna.getLongitude();
      this.created = antenna.getCreated();
      this.lastUpdated = antenna.getLastUpdated();
      this.rangeLimit = antenna.getRangeLimit();
    }
    return this;
  }

}
