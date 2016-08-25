package com.globant.training.google.maps.alert.endpoint.dtos;

import com.globant.training.google.maps.alert.entity.LatLng;
import com.globant.training.google.maps.core.endpoint.dto.Dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

/**
 * Antenna DTO.
 * 
 * @author gaston.aguilera.
 */
public class AlertDto implements Dto {

  private static final long serialVersionUID = 1L;

  private Long id;

  @NotNull
  private String name;

  private Long itemId;

  @NotNull
  private List<CoordinatePointDto> coordinates;

  private Date created;

  private Date lastUpdated;

  private boolean active;

  /**
   * Gets antenna id.
   * 
   * @return the antenna id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets antenna id.
   * 
   * @param id the antenna id
   */
  public AlertDto setId(Long id) {
    this.id = id;
    return this;
  }


  /**
   * Gets the date where the Antenna´s information was created
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the date where the Antenna´s information was created.
   * 
   * @param created the date
   */
  public AlertDto setCreated(Date created) {
    this.created = created;
    return this;
  }

  /**
   * Returns when the entity was modified.
   * 
   * @return last updated
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * Sets the last updated.
   * 
   * @param lastUpdated the last updated
   */
  public AlertDto setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  public String getName() {
    return name;
  }

  public AlertDto setName(String name) {
    this.name = name;
    return this;
  }

  public boolean isActive() {
    return active;
  }

  public AlertDto setActive(boolean active) {
    this.active = active;
    return this;
  }

  public Long getItemId() {
    return itemId;
  }

  public AlertDto setItemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  public List<CoordinatePointDto> getCoordinates() {
    return coordinates;
  }

  public AlertDto setCoordinates(List<CoordinatePointDto> coordinates) {
    this.coordinates = coordinates;
    return this;
  }

  /**
   * Set the dto coordinates
   * 
   * @param coordinates list of coordinates.
   */
  public void setCoordinatesFromEntity(List<LatLng> coordinates) {

    this.coordinates = new ArrayList<>();

    for (int i = 0; i < coordinates.size(); i++) {

      LatLng coordinate = coordinates.get(i);
      
      // @formatter:off
      CoordinatePointDto coordinatePointDto = new CoordinatePointDto()
          .setLatitude(coordinate.getLatitude())
          .setLongitude(coordinate.getLongitude())
          .setOrder(i);
      // @formatter:on
      this.coordinates.add(coordinatePointDto);
    }

  }
}
