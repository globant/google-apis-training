package com.globant.training.google.maps.alert.entity;

import com.google.api.server.spi.config.ApiTransformer;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;

import com.globant.training.google.maps.alert.endpoint.transformer.AlertApiTransformer;
import com.globant.training.google.maps.core.entity.BaseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.annotations.Embedded;

/**
 * Class to represent an Alerts used to monitor items in Geo polygons.
 * 
 * @author gaston.aguilera
 *
 */
@Entity(name = "Alert")
@ApiTransformer(AlertApiTransformer.class)
public class Alert extends BaseEntity {

  private String name;
  
  private Long itemId;

  @Embedded 
  private List<LatLng> poligonRegion = new ArrayList<LatLng>();

  @Index
  private boolean active;

  private Date created;

  private Date lastUpdated;

  /**
   * Returns <b>true</b> if the Antenna is active, otherwise <b>false</b>
   * 
   * @return if the Antenna is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets flag to indicate if the Antenna is active or not.
   * 
   * @param active true or false
   */
  public Alert setActive(boolean active) {
    this.active = active;
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
  public Alert setCreated(Date created) {
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
  public Alert setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * Gets antenna name.
   * 
   * @return the antenna name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the antenna name.
   * 
   * @param name the antenna name
   */
  public Alert setName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Gets the item id being monitored.
   * 
   * @return the the item id.
   */
  public Long getItemId() {
    return itemId;
  }

  
  /**
   * Set the item id to be monitored.
   * 
   * @param itemId an item id.
   */
  public Alert setItemId(Long itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get the List of {@link Coordinate} that conform the polygon to me monitored.
   * @return a {@link List} of {@link Coordinate}
   */
  public List<LatLng> getPoligonRegion() {
    return poligonRegion;
  }

  /**
   * Set the List of {@link Coordinate} that conform the polygon to me monitored.
   * 
   * @param poligonRegion a list of {@link Coordinate} 
   */
  public Alert setPoligonRegion(List<LatLng> poligonRegion) {
    this.poligonRegion = poligonRegion;
    return this;
  }
}
