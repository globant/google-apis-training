package com.globant.training.google.maps.device.entity;

import com.googlecode.objectify.annotation.Subclass;

import java.util.HashMap;
import java.util.Map;

import javax.jdo.annotations.Embedded;

/**
 * Class to represent a GPS entity
 * 
 * @author gabriel.sideri
 */
@Subclass(name = "Gps", index = true)
public class GpsDevice extends Device {

  public static final String SERIAL_NUMBER_KEY = "serialNumber";

  private String serialNumber;

  @Embedded
  private Map<String, String> data;

  @Override
  public Map<String, String> getAttributes() {

    Map<String, String> attributtes = new HashMap<String, String>();
    attributtes.put(SERIAL_NUMBER_KEY, this.serialNumber);

    if (data != null) {
      attributtes.putAll(data);
    }
    return attributtes;
  }

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

  /**
   * Gets additional data for device {@link Map<String, String>}.
   * 
   * @return the Map<String, String> 
   */
  public Map<String, String> getData() {
    return data;
  }

  /**
   * Sets additional data for device {@link Map<String, String>}.
   * 
   * @param a  {@link Map<String, String> }
   */
  public void setData(Map<String, String> data) {
    this.data = data;
  }

}
