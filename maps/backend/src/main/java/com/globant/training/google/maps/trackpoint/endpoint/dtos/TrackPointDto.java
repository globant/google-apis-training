package com.globant.training.google.maps.trackpoint.endpoint.dtos;

import static com.globant.training.google.maps.core.endpoint.validation.DtoValidator.validate;

import com.globant.training.google.maps.core.endpoint.dto.Dto;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Track Point DTO.
 * 
 * @author gabriel.sideri
 */
public class TrackPointDto implements Dto<TrackPoint, TrackPointDto> {

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

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.core.endpoint.dto.Dto#toEntity()
   */
  @Override
  public TrackPoint toEntity() {
    validate(this);

    TrackPoint trackPoint = new TrackPoint();
    trackPoint.setDeviceId(deviceId);
    trackPoint.setLatitude(latitude);
    trackPoint.setLongitude(longitude);
    trackPoint.setMeasuredDate(measuredDate);

    if (this.getId() == null) {
      trackPoint.setSavedDate(new Date());
    } else {
      trackPoint.setId(id);
      trackPoint.setSavedDate(getSavedDate());
    }

    return trackPoint;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.core.endpoint.dto.Dto#fromEntity(java.lang.Object)
   */
  @Override
  public TrackPointDto fromEntity(TrackPoint trackPoint) {

    if (trackPoint != null) {
      this.id = trackPoint.getId();
      this.latitude = trackPoint.getLatitude();
      this.longitude = trackPoint.getLongitude();
      this.measuredDate = trackPoint.getMeasuredDate();
      this.savedDate = trackPoint.getSavedDate();
    }

    return this;
  }

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
  public void setMeasuredDate(Date measuredDate) {
    this.measuredDate = measuredDate;
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
  public void setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
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
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
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
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
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
  public void setSavedDate(Date savedDate) {
    this.savedDate = savedDate;
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
  public void setId(Long id) {
    this.id = id;
  }

}
