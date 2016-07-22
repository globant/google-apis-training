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
   * Gets Device´s Name.
   * 
   * @return the device name
   */
  String getName();
  
  /**
   * @return the {DeviceType} of instance.
   */
  DeviceType getType();
}
