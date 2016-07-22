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
   * Get a list of Device.
   * 
   * @return a list with all Device
   */
  List<Device> getAll();
  
  /** 
   * Save or update Device.
   * 
   * @param Device the Device
   * @return the Device persisted
   */
  Device save(Device Device);
  
  /**
   * Find Device by id.
   * 
   * @param id the Device id
   * @return the {@link Device}
   */
  Device findById(Long id);
}
