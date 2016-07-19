package com.globant.training.google.maps.entities;

/**
 * Interface to describe a common behavior for each Device.
 * 
 * @author gabriel.sideri
 */
public interface Device {

  /**
   * Gets Device´s id.
   * 
   * @return device id
   */
  Long getId();

  /**
   * Sets device´s id.
   * 
   * @param id the device id
   */
  void setId(Long id);

  /**
   * Gets Device´s Name.
   * 
   * @return the device name
   */
  String getName();

  /**
   * Sets the device´s name.
   * 
   * @param name the device name
   */
  void setName(String name);

}
