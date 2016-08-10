package com.globant.training.google.maps.device.entity;

import com.google.api.server.spi.config.ApiTransformer;

import com.googlecode.objectify.annotation.Entity;

import com.globant.training.google.maps.core.entity.BaseEntity;
import com.globant.training.google.maps.device.endpoint.transformer.DeviceApiTransformer;

import java.util.Date;
import java.util.Map;

/**
 * Represents a base device with common attributes accross devices.
 *
 */
@Entity(name = "Device")
@ApiTransformer(DeviceApiTransformer.class)
public abstract class Device extends BaseEntity {

  /**
   * Device name.
   */
  protected String name;

  /**
   * Active flag, true if active.
   */
  protected boolean active;

  /**
   * Date of creation.
   */
  protected Date created;

  /**
   * Date of last update.
   */
  protected Date lastUpdated;

  /**
   * Return the device Type.
   * 
   * @return the {@link DeviceType}
   */
  public abstract DeviceType getType();

  /**
   * Provide a Map of particular values for device.
   * 
   * @return a {@link Map{String, String}}
   */
  public abstract Map<String, String> getAttributes();

  /**
   * Provide a Map of particular values for device.
   * 
   * @param device device.
   */
  public abstract void update(Device device);

  /**
   * Get device name.
   * 
   */
  public String getName() {
    return this.name;
  }

  /**
   * Set device name.
   * 
   * @param name the device name.
   */
  public void setName(final String name) {
    this.name = name;
  }

  /**
   * Returns <b>true</b> if RFID is active, otherwise <b>false</b>
   * 
   * @return if RFID is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets flag to indicate if RFID is active or not.
   * 
   * @param active true or false
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Gets the date where the RFID Device was created.
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the date where the RFID Device was created.
   * 
   * @param created the date
   */
  public void setCreated(Date created) {
    this.created = created;
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
  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

}
