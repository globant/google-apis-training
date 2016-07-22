package com.globant.training.google.maps.entities.device;

import com.globant.training.google.maps.entities.DeviceType;
import com.googlecode.objectify.annotation.Subclass;

/**
 * Class to represent a GPS entity
 * 
 * @author gabriel.sideri
 */
@Subclass(name = "Gps", index = true)
public class GpsDevice extends Device {

  private String serialNumber;

  /**
   * Gets GPS serial number.
   * 
   * @return the GPS serial number
   */
  public String getSerialNumber() {
    return serialNumber;
  }

  /**
   * Sets the GPS serial number
   * 
   * @param serialNumber the GPS serial number.
   */
  public void setSerialNumber(String serialNumber) {
    this.serialNumber = serialNumber;
  }

  /**
   * Gets the {@link DeviceType}.
   * 
   * @return the Device Type
   */
  public DeviceType getType() {
    return DeviceType.GPS;
  }
}
