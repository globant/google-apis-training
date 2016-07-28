package com.globant.training.google.maps.services;

import java.util.List;

import com.globant.training.google.maps.daos.DeviceDao;
import com.globant.training.google.maps.entities.device.Device;
import com.google.inject.Inject;

/**
 * {@link DeviceService} Implementation
 * 
 * @author gaston.aguilera
 */
public class DeviceServiceImpl implements DeviceService {

  private final DeviceDao deviceDao;

  @Inject
  public DeviceServiceImpl(DeviceDao DeviceDao) {
    super();
    this.deviceDao = DeviceDao;
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
  public Device update(Long id, Device device) {

    // validate that exists
    findById(id);

    //overwrite fully
    device.setId(id);
    Device savedDevice = deviceDao.put(device);

    return savedDevice;
  }

  @Override
  public Device create(Device Device) {
    return deviceDao.put(Device);
  }

  @Override
  public void deleteById(Long id) {
    
    // validate that exists
    findById(id);
    
    deviceDao.delete(id);
  }

}
