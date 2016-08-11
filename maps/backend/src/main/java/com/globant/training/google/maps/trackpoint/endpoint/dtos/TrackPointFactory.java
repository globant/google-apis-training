package com.globant.training.google.maps.trackpoint.endpoint.dtos;

import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

/**
 * Factory for Track Point creation.
 * 
 * @author gabriel.sideri
 *
 */
public interface TrackPointFactory {

  /**
   * Create a track point from provided Dto.
   * 
   * @param trackPointDto the track point dto
   * @return the track point
   */
  TrackPoint buildTrackPoint(TrackPointDto trackPointDto);
}
