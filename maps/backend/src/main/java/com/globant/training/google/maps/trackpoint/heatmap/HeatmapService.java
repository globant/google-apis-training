package com.globant.training.google.maps.trackpoint.heatmap;

import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;

/**
 * Heat map service to process trackpoints.
 * 
 * @author gaston.aguilera
 */
public interface HeatmapService {


  /**
   * Add a trackpoint to heatmap.
   * 
   * @param point to be added.
   */
  void addEntryPoint(TrackPointAddedEvent point);
  
  String getGlobalTableId();

}
