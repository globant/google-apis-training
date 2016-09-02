package com.globant.training.google.maps.trackpoint.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

import com.google.api.server.spi.config.ApiTransformer;

import com.globant.training.google.maps.core.entity.BaseEntity;
import com.globant.training.google.maps.trackpoint.endpoint.transformer.TrackPointApiTransformer;
import com.globant.training.google.maps.trackpoint.service.visitor.TrackPointVisitor;

import org.joda.time.DateTime;

import java.util.Map;

/**
 * Class to represents the track points sent it by the devices
 * 
 * @author gabriel.sideri
 *
 */
@Entity
@ApiTransformer(TrackPointApiTransformer.class)
public abstract class TrackPoint extends BaseEntity {
  
  @Ignore
  public static final String LATITUDE_FIELD = "latitude";
  
  @Ignore
  public static final String LONGITUDE_FIELD = "longitude";
  
  @Ignore
  public static final String MEASURED_DATE = "measuredDate";
  
  @Ignore
  public static final String DEVICE_ID_FIELD = "deviceId";
  
  @Ignore
  public static final String ITEM_ID_FIELD = "itemId";
  
  @Index
  protected Long itemId;

  @Index
  private Long deviceId;
  
  protected Double latitude;

  protected Double longitude;

  @Index
  protected DateTime measuredDate;

  protected DateTime savedDate;
  
  protected Map<String, String> context;
  

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
  public void setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
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
  public DateTime getMeasuredDate() {
    return measuredDate;
  }

  /**
   * Sets the date when the track point was measured by the device.
   * 
   * @param measuredDate the measured Date
   */
  public void setMeasuredDate(DateTime measuredDate) {
    this.measuredDate = measuredDate;
  }

  /**
   * Gets the date when the track point was saved.
   * 
   * @return the saved date
   */
  public DateTime getSavedDate() {
    return savedDate;
  }

  /**
   * Sets the date when the track point was saved.
   * 
   * @param savedDate the saved Date
   */
  public void setSavedDate(DateTime savedDate) {
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
  public void setItemId(Long itemId) {
    this.itemId = itemId;
  }
  
  /**
   * Sets a {@link TrackPointVisitor}.
   * 
   * @param visitor the visitor 
   */
  public abstract void visit(TrackPointVisitor visitor);

}
