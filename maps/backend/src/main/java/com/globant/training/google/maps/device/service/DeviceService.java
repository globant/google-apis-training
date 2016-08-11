package com.globant.training.google.maps.device.service;

import com.globant.training.google.maps.device.entity.Device;

import java.util.List;

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
   * @param device the Device
   * @return the Device persisted
   */
  Device update(Long id, Device device);

  /**
   * Creates a device.
   * 
   * @param device the Device
   * @return the Device persisted
   */
  Device create(Device device);

  /**
   * Delete device by id.
   * 
   * @param id the device id
   */
  void deleteById(Long id);

  /**
   * Find Rfid Device by Rfid Id.
   * 
   * @param rfidId the rfid id
   * @return the {@link Device}
   * 
   * @throws {@link RuntimeException} if no device found.
   */
  Device findDeviceByRfidId(String rfidId);
}
