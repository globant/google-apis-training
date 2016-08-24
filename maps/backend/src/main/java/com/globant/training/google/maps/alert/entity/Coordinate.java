package com.globant.training.google.maps.alert.entity;

import java.io.Serializable;

/**
 * Geo Coordinate.
 * 
 * @author gaston.aguilera
 *
 */
public class Coordinate implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  public Coordinate() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param latitude latitude.
   * @param longitude longitude.
   */
  public Coordinate(Double latitude, Double longitude) {
    super();
    this.latitude = latitude;
    this.longitude = longitude;
  }

  private Double latitude;

  private Double longitude;

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }
}
