package com.globant.training.google.maps.device.endpoint.dtos.device.factory;

import com.globant.training.google.maps.device.entity.Device;

import java.util.Map;


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
   * @param active indicates if the Device is active or not.
   * @param attributtes a Map of attributes to be used in device creation.
   * @return the created Device.
   */
  Device makeDevice(String name, boolean active, Map<String, String> attributtes);
}
