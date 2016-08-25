package com.globant.training.google.maps.alert.entity;

/**
 * Geo Coordinate.
 * 
 * @author gaston.aguilera
 *
 */
public class LatLng {

  private double latitude;
  private double longitude;

  /**
   * Default constructor.
   */
  public LatLng() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param lat latitude.
   * @param lon longitude.
   */
  public LatLng(double lat, double lon) {
    latitude = lat;
    longitude = lon;
  }

  public double getLatitude() {
    return latitude;
  }
  
  public double latitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }
  
  public double longitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
