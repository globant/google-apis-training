package com.globant.training.google.maps.device.daos;

import java.util.List;

import com.globant.training.google.maps.device.entity.Device;

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
   * Get device by id.
   * 
   * @param id the device id
   * @return the {@link Device}
   */
  Device get(Long id);
  
  /**
   * Delete device by id.
   * 
   * @param id the device id
   */
  void delete(Long id);
}
