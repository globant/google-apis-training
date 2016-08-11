package com.globant.training.google.maps.device.daos.objectify;

import com.globant.training.google.maps.core.dao.objectify.BaseOfyDao;
import com.globant.training.google.maps.device.daos.DeviceDao;
import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.entity.RfidDevice;

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

  @Override
  public Device findDeviceByRfidId(String rfidId) {
    return this.query().filter(RfidDevice.RFID_ID_KEY, rfidId).first().now();
  }

}
