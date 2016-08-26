package com.globant.training.google.maps.trackpoint.service;

import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import org.joda.time.DateTime;

import java.util.List;

/**
 * Track Point Service.
 * 
 * @author gabriel.sideri
 */
public interface TrackPointService {

  /**
   * Save Track Point.
   * 
   * @param trackPoint the track point
   * @return the track point persisted
   */
  TrackPoint save(TrackPoint trackPoint);

  /**
   * Find Track Point by id.
   * 
   * @param trackPointId the track point id
   * @return the {@link TrackPoint}
   */
  TrackPoint findById(Long trackPointId);

  /**
   * Delete track point by id.
   * 
   * @param trackPointId the track point id
   */
  void deleteById(Long trackPointId);
  
  /**
   * Gets a list of {@link TrackPoint} by device Id.
   * 
   * @return the track points by device id
   */
  List<TrackPoint> findTrackPointsByDeviceId(Long deviceId);
  
  /**
   * Find Track Points by Item Id and Date Range.
   * 
   * @param fromDate from measured date
   * @param toDate to measured date
   * @param itemId the item id
   */
  List<TrackPoint> find(DateTime fromDate,
      DateTime toDate, Long itemId);
  
  /**
   * Calculates Distance by Item Id.
   * 
   * @param fromDate from measured date
   * @param toDate to measured date
   * @param itemId the item id
   */
  double calculatesDistanceByItemId(DateTime fromDate,
      DateTime toDate, Long itemId);
  
}
