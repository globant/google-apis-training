package com.globant.training.google.maps.alert.endpoint.dtos;

import com.globant.training.google.maps.core.endpoint.dto.Dto;

import javax.validation.constraints.NotNull;

/**
 * A coordinate dto representation.
 * 
 * @author gaston.aguilera
 *
 */
public class CoordinatePointDto implements Dto {

  private static final long serialVersionUID = 1L;
  
  @NotNull
  private Double latitude;

  @NotNull
  private Double longitude;

  @NotNull
  private int order;
  
  public CoordinatePointDto setLatitude(Double latitude) {
    this.latitude = latitude;
    return this;
  }

  public CoordinatePointDto setLongitude(Double longitude) {
    this.longitude = longitude;
    return this;
  }

  public CoordinatePointDto setOrder(int order) {
    this.order = order;
    return this;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public int getOrder() {
    return order;
  }

}
