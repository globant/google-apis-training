package com.globant.training.google.maps.entities;

import java.util.Date;
import java.util.Map;

import com.globant.training.google.maps.entities.device.Device;

/**
 * Class to represents the track points sent it by the devices
 * 
 * @author gabriel.sideri
 *
 */
public class TrackPoint extends BaseEntity {

  private Device device;

  private Double latitude;

  private Double longitude;

  private Date measuredDate;

  private Date savedDate;
  
  private Map<String, String> context;

  /**
   * Get the Device associated with the Tack Point.
   * 
   * @return the Device
   */
  public Device getDevice() {
    return device;
  }

  /**
   * Sets the Device associated with the Track Point.
   * 
   * @param device the device
   */
  public void setDevice(Device device) {
    this.device = device;
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
  public void setLatitude(Double latitude) {
    this.latitude = latitude;
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
  public void setLongitude(Double longitude) {
    this.longitude = longitude;
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
  public void setMeasuredDate(Date measuredDate) {
    this.measuredDate = measuredDate;
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
  public void setSavedDate(Date savedDate) {
    this.savedDate = savedDate;
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
  public void setContext(Map<String, String> context) {
    this.context = context;
  }

}
