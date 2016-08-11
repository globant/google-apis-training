package com.globant.training.google.maps.trackpoint.entity;

import com.googlecode.objectify.annotation.Subclass;

import com.globant.training.google.maps.trackpoint.service.visitor.TrackPointVisitor;
import com.globant.training.google.maps.trackpoint.service.visitor.VisitableTrackPoint;

/**
 * GPS TrackPoint Entity
 * 
 * @author gabriel.sideri
 */
@Subclass(name = "GpsTrackPoint", index = true)
public class GpsTrackPoint extends TrackPoint implements VisitableTrackPoint {

  @Override
  public void visit(TrackPointVisitor visitor) {
    visitor.visit(this);
  }

}
