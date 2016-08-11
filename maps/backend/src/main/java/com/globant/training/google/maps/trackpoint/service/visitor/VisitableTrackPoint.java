package com.globant.training.google.maps.trackpoint.service.visitor;

/**
 * Visitable interface for TrackPoint.
 * 
 * @author gaston.aguilera
 *
 */
public interface VisitableTrackPoint {
  /**
   * Visit using a {@link TrackPointVisitor} visitor.
   * 
   * @param visitor a {@link TrackPointVisitor} to be used in visit.
   */
  void visit(TrackPointVisitor visitor);
}
