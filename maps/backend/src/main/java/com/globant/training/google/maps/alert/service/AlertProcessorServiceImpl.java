package com.globant.training.google.maps.alert.service;

import com.google.maps.android.PolyUtil;

import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;

public class AlertProcessorServiceImpl implements AlertProcessorService {

  private final AlertService alertService;

  public AlertProcessorServiceImpl(AlertService alertService) {
    this.alertService = alertService;
  }

  @Override
  public void process(TrackPointAddedEvent addedTrackPoint) {
    // TODO Auto-generated method stub
    
    
    
    
  }

}
