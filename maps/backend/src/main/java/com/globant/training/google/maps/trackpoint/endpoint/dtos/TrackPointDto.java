package com.globant.training.google.maps.trackpoint.endpoint.dtos;

import com.globant.training.google.maps.core.endpoint.dto.Dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Track Point DTO.
 * 
 * @author gabriel.sideri
 */
public class TrackPointDto implements Dto {

  private static final long serialVersionUID = 1L;

  private Long id;

  @NotNull
  private Long deviceId;
  
  private Long itemId;

  @NotNull
  private Double latitude;

  @NotNull
  private Double longitude;

  @NotNull
  private Date measuredDate;

  private Date savedDate;

  /**
   * Gets the date when the track point was measured.
   * 
   * @return the measuted date.
   */
  public Date getMeasuredDate() {
    return measuredDate;
  }

  /**
   * Sets the date when the track point was measured.
   * 
   * @param measuredDate the measured date
   */
  public TrackPointDto setMeasuredDate(Date measuredDate) {
    this.measuredDate = measuredDate;
    return this;
  }

  /**
   * Gets the device id.
   * 
   * @return the device id
   */
  public Long getDeviceId() {
    return deviceId;
  }

  /**
   * Sets the device id.
   * 
   * @param deviceId the device id
   */
  public TrackPointDto setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  /**
   * Gets the Latitude.
   * 
   * @return the track point latitude.
   */
  public Double getLatitude() {
    return latitude;
  }

  /**
   * Sets the latitude.
   * 
   * @param latitude the track point latitude
   */
  public TrackPointDto setLatitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Gets the longitude.
   * 
   * @return the tack point longitude
   */
  public Double getLongitude() {
    return longitude;
  }

  /**
   * Sets the longitude.
   * 
   * @param longitude the track point longitude
   */
  public TrackPointDto setLongitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Gets when the track point was persisted.
   * 
   * @return the saved date
   */
  public Date getSavedDate() {
    return savedDate;
  }

  /**
   * Sets the date when the track point was persisted.
   * 
   * @param savedDate the saved date
   */
  public TrackPointDto setSavedDate(Date savedDate) {
    this.savedDate = savedDate;
    return this;
  }

  /**
   * Gets track point id.
   * 
   * @return the track point id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets the track point id.
   * 
   * @param id the track point id
   */
  public TrackPointDto setId(Long id) {
    this.id = id;
    return this;
  }

}
