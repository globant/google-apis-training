package com.globant.training.google.maps.endpoints.dtos.device.factory;

import java.util.Map;

import com.globant.training.google.maps.entities.device.Device;


/**
 * Factory for device creation.
 * 
 * @author gaston.aguilera
 *
 */
public interface DeviceFactory {

  /**
   * Create a device form provided attributes.
   * 
   * @param name device name.
   * @param attributtes a Map of attributes to be used in device creation.
   * 
   * @return the created Device.
   */
  Device makeDevice(String name, Map<String, String> attributtes);

}
