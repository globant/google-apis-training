package com.globant.training.google.maps.alert.service;

import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;

public interface AlertProcessorService {
  
  void process(TrackPointAddedEvent addedTrackPoint);

}
