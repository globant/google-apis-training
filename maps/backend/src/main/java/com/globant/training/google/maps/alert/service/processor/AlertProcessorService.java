package com.globant.training.google.maps.alert.service.processor;

import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;

/**
 * Process alert contract.
 * 
 * @author gastonaguilera
 *
 */
public interface AlertProcessorService {
  
  /**
   * Process a {@link TrackPointAddedEvent} with alerts..
   * 
   * @param addedTrackPoint track point.
   */
  void process(TrackPointAddedEvent addedTrackPoint);

}
