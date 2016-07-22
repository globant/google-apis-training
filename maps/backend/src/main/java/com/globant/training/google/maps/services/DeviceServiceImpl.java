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

  private final DeviceDao DeviceDao;

  @Inject
  public DeviceServiceImpl(DeviceDao DeviceDao) {
    super();
    this.DeviceDao = DeviceDao;
  }

  @Override
  public List<Device> getAll() {
    return DeviceDao.getAll();
  }

  @Override
  public Device save(Device Device) {
    return DeviceDao.put(Device);
  }

  @Override
  public Device findById(Long id) {
    return DeviceDao.get(id);
  }

}
