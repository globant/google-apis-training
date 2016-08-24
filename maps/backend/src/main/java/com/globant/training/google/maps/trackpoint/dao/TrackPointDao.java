package com.globant.training.google.maps.trackpoint.dao;

import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Track Point DAO interface.
 * 
 * @author gabriel.sideri
 */
public interface TrackPointDao {
  /**
   * Save Track Point.
   * 
   * @param trackPoint the trackPoint
   * @return the track point persisted
   */
  TrackPoint put(TrackPoint trackPoint);

  /**
   * Get Track Point by id.
   * 
   * @param id the track point id
   * @return the {@link TrackPoint}
   */
  TrackPoint get(Long id);

  /**
   * Delete track point by id.
   * 
   * @param id the track point id
   */
  void delete(Long id);
  
  /**
   * Gets List of {@link TrackPoint} by Device Id.
   * 
   * @param deviceId the device id
   */
  List<TrackPoint> getTrackPointsByDeviceId(Long deviceId);
  
  /**
   * Find Track Points by Item Id and Date Range.
   * 
   * @param itemId the item id
   * @param fromDate from measured date
   * @param toDate to measured date
   */
  List<TrackPoint> findTrackPointsByItemIdAndDateRange(Long itemId, DateTime fromDate,
      DateTime toDate);

}
