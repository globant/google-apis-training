package com.globant.training.google.maps.daos;

import com.globant.training.google.maps.entities.device.Device;

import java.util.List;

/**
 * Antenna DAO Interface.
 * 
 * @author gaston.aguilera
 */
public interface DeviceDao {

  /**
   * Get a list of Devices.
   * 
   * @return a list with all Devices
   */
  List<Device> getAll();
  
  /** 
   * Save or Update Device.
   * 
   * @param device the device.
   * @return the persisted device.
   */
  Device put(Device device);
  
  /**
   * Get Device by id.
   * 
   * @param id the device id
   * @return the {@link Device}
   */
  Device get(Long id);
}
