package com.globant.training.google.maps.trackpoint.entity;

import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Subclass;

import com.globant.training.google.maps.trackpoint.service.visitor.TrackPointVisitor;
import com.globant.training.google.maps.trackpoint.service.visitor.VisitableTrackPoint;

/**
 * RFID TrackPoint Entity
 * 
 * @author gabriel.sideri
 */
@Subclass(name = "RfidTrackPoint", index = true)
public class RfidTrackPoint extends TrackPoint implements VisitableTrackPoint {

  @Index
  private String rfidId;

  @Index
  private Long antennaId;

  @Ignore
  public static final String RFID_ID_FIELD = "rfidId";
  
  @Ignore
  public static final String ANTENNA_ID_FIELD = "antennaId";

  /**
   * Gets the RFID id associated with the Tack Point.
   * 
   * @return the RFID Id
   */
  public String getRfidId() {
    return rfidId;
  }

  /**
   * Sets the RFID Id associated with the Track Point.
   * 
   * @param rfidId the RFID id
   */
  public void setRfidId(String rfidId) {
    this.rfidId = rfidId;
  }

  /**
   * Gets the Antenna Id associated with the track point.
   * 
   * @return the antenna id
   */
  public Long getAntennaId() {
    return antennaId;
  }

  /**
   * Sets the Antenna Id associated with the track point.
   * 
   * @param antennaId the antenna id
   */
  public void setAntennaId(Long antennaId) {
    this.antennaId = antennaId;
  }

  @Override
  public void visit(TrackPointVisitor visitor) {
    visitor.visit(this);
  }

}
