package com.globant.training.google.maps.trackpoint.service.visitor;

import com.globant.training.google.maps.trackpoint.entity.GpsTrackPoint;
import com.globant.training.google.maps.trackpoint.entity.RfidTrackPoint;

/**
 * Trackpoint visitor contact.
 * 
 * @author gabriel.sideri
 */
public interface TrackPointVisitor {
  
  void visit(GpsTrackPoint trackPoint);
  
  void visit(RfidTrackPoint trackPoint);
  
}
