package com.globant.training.google.maps.trackpoint.service;

import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

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
}
