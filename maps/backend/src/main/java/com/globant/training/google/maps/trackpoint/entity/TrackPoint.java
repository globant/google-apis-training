package com.globant.training.google.maps.trackpoint.entity;

import com.google.api.server.spi.config.ApiTransformer;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;


import com.globant.training.google.maps.core.entity.BaseEntity;
import com.globant.training.google.maps.trackpoint.endpoint.transformer.TrackPointApiTransformer;

import java.util.Date;
import java.util.Map;

/**
 * Class to represents the track points sent it by the devices
 * 
 * @author gabriel.sideri
 *
 */
@Entity
@ApiTransformer(TrackPointApiTransformer.class)
public class TrackPoint extends BaseEntity {

  @Index
  private Long deviceId;
 
  @Index
  private Long itemId;

  private Double latitude;

  private Double longitude;

  private Date measuredDate;

  private Date savedDate;
  
  private Map<String, String> context;
  
  @Ignore
  public static final String DEVICE_ID_FIELD = "deviceId";

  /**
   * Gets the device id associated with the Tack Point.
   * 
   * @return the Device Id
   */
  public Long getDeviceId() {
    return deviceId;
  }

  /**
   * Sets the Device Id associated with the Track Point.
   * 
   * @param deviceId the device id
   */
  public TrackPoint setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
    return this;
  }

  /**
   * Gets the Latitude where the device registered the Track Point.
   * 
   * @return the Latitude
   */
  public Double getLatitude() {
    return latitude;
  }

  /**
   * Sets the Latitude to register the Track Point.
   * 
   * @param latitude the Latitude
   */
  public TrackPoint setLatitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  /**
   * Gets the Longitude where the device registered the Track Point.
   * 
   * @return the Longitude
   */
  public Double getLongitude() {
    return longitude;
  }

  /**
   * Sets the Longitude to register the Track Point.
   * 
   * @param longitude the Longitude
   */
  public TrackPoint setLongitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  /**
   * Gets the date when the track point was measured by the device.
   * 
   * @return the measured date
   */
  public Date getMeasuredDate() {
    return measuredDate;
  }

  /**
   * Sets the date when the track point was measured by the device.
   * 
   * @param measuredDate the measured Date
   */
  public TrackPoint setMeasuredDate(Date measuredDate) {
    this.measuredDate = measuredDate;
    return this;
  }

  /**
   * Gets the date when the track point was saved.
   * 
   * @return the saved date
   */
  public Date getSavedDate() {
    return savedDate;
  }

  /**
   * Sets the date when the track point was saved.
   * 
   * @param savedDate the saved Date
   */
  public TrackPoint setSavedDate(Date savedDate) {
    this.savedDate = savedDate;
    return this;
  }

  /**
   * Gets the context information.
   * 
   * @return Map with context information
   */
  public Map<String, String> getContext() {
    return context;
  }

  /**
   * Sets the context information.
   * 
   * @param context Map with context information
   */
  public TrackPoint setContext(Map<String, String> context) {
    this.context = context;
    return this;
  }

  /**
   * Gets item id.
   * 
   * @return the item id
   */
  public Long getItemId() {
    return itemId;
  }

  /**
   * Sets the item id.
   * 
   * @param itemId the item id
   */
  public TrackPoint setItemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

}
