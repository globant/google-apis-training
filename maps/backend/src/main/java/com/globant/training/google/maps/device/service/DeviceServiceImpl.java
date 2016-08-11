package com.globant.training.google.maps.device.service;

import com.google.inject.Inject;

import com.globant.training.google.maps.device.daos.DeviceDao;
import com.globant.training.google.maps.device.entity.Device;

import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * {@link DeviceService} Implementation
 * 
 * @author gaston.aguilera
 */
public class DeviceServiceImpl implements DeviceService {

  private final DeviceDao deviceDao;

  /**
   * Constructor.
   * 
   * @param deviceDao dao.
   * @param deviceValidator validator.
   */
  @Inject
  public DeviceServiceImpl(DeviceDao deviceDao) {
    super();
    this.deviceDao = deviceDao;
  }

  @Override
  public List<Device> getAll() {
    return deviceDao.getAll();
  }

  @Override
  public Device findById(Long id) {
    Device foundDevice = deviceDao.get(id);

    if (foundDevice == null) {
      // Todo move to a custom exception.
      throw new RuntimeException("Device Not Found");
    }

    return foundDevice;
  }

  @Override
  public Device update(Long id, Device updateDevice) {

    // validate that exists
    Device existingDevice = findById(id);

    if (existingDevice.getType() != updateDevice.getType()) {
      // Todo move to a custom exception.
      throw new RuntimeException("Device type cannot be changed.");
    }

    // overwrite fully
    updateDevice.setId(id);
    Device savedDevice = deviceDao.put(updateDevice);

    return savedDevice;
  }

  @Override
  public Device create(Device device) {

    return deviceDao.put(device);
  }

  @Override
  public void deleteById(Long id) {

    // validate that exists
    findById(id);

    deviceDao.delete(id);
  }

  @Override
  public Device findDeviceByRfidId(String rfidId) {
    Validate.notEmpty(rfidId, "Rfid Id cannot be null or empty");

    Device rfid = deviceDao.findDeviceByRfidId(rfidId);

    if (rfid == null) {
      throw new RuntimeException("Rfid not found.");
    }

    return rfid;
  }

}
