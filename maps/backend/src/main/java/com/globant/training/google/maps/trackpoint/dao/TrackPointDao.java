package com.globant.training.google.maps.trackpoint.dao;

import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

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

}
