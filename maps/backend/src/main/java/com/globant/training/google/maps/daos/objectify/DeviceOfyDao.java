package com.globant.training.google.maps.daos.objectify;

import com.globant.training.google.maps.daos.DeviceDao;
import com.globant.training.google.maps.entities.device.Device;

/**
 * Device Objectify DAO.
 * 
 * @author gaston.aguilera
 *
 */
public class DeviceOfyDao extends BaseOfyDao<Device> implements DeviceDao {

  protected DeviceOfyDao() {
    super(Device.class);
  }
}
