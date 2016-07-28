package com.globant.training.google.maps.services;

import java.util.List;

import com.globant.training.google.maps.entities.device.Device;

/**
 * Interface to expose {@link DeviceService} operations
 * 
 * @author gaston.aguilera
 */
public interface DeviceService {
  
  /**
   * Get a list of all Devices.
   * 
   * @return a list with all Device
   */
  List<Device> getAll();
  
  /**
   * Find Device by id.
   * 
   * @param id the Device id
   * @return the {@link Device}
   * 
   * @throws {@link RuntimeException} if no device found.
   */
  Device findById(Long id);
  
  /** 
   * Updates a Device.
   * 
   * @param Device the Device
   * @return the Device persisted
   */
  Device update(Long id, Device Device);
  
  /** 
   * Creates a device.
   * 
   * @param Device the Device
   * @return the Device persisted
   */
  Device create(Device Device);
  
  /**
   * Delete device by id.
   * 
   * @param id the device id
   */
  void deleteById(Long id);
}
