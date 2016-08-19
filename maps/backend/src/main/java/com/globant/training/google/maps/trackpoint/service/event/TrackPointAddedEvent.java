package com.globant.training.google.maps.trackpoint.service.event;

import com.google.api.client.util.DateTime;

import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import java.io.Serializable;
import java.util.Date;

/**
 * Trackpoint event dto.
 * 
 * @author gaston.aguilera
 */
public class TrackPointAddedEvent implements Serializable {

  private static final String COMMA = ",";

  private Long itemId;

  private Long deviceId;

  private Double latitude;

  private Double longitude;

  private Date measuredDate;

  private static final long serialVersionUID = 1L;

  /**
   * Private constructor, use fromTrackPoint method.
   */
  private TrackPointAddedEvent() {}

  /**
   * Builder. Builds a {@link TrackPointAddedEvent} from a {@link TrackPoint}
   * 
   * @param trackpoint trackpoint.
   * @return a {@link TrackPointAddedEvent}
   */
  public static TrackPointAddedEvent fromTrackPoint(final TrackPoint trackpoint) {
    TrackPointAddedEvent event = new TrackPointAddedEvent();

    event.itemId = trackpoint.getItemId();
    event.deviceId = trackpoint.getDeviceId();
    event.latitude = trackpoint.getLatitude();
    event.longitude = trackpoint.getLongitude();
    event.measuredDate = trackpoint.getMeasuredDate().toDate();

    return event;
  }

  public Long getItemId() {
    return itemId;
  }

  public Long getDeviceId() {
    return deviceId;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public Date getMeasuredDate() {
    return measuredDate;
  }

  public String getLocation() {
    return latitude + COMMA + longitude;
  }

  public DateTime getDateTime() {
    return new DateTime(measuredDate);
  }
}
