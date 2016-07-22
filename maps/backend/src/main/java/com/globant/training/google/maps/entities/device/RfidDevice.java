package com.globant.training.google.maps.entities.device;

import java.util.Map;

import com.globant.training.google.maps.entities.DeviceType;
import com.googlecode.objectify.annotation.Subclass;

/**
 * Class to represent a RFID entity
 * 
 * @author gabriel.sideri
 */
@Subclass(name = "Rfid", index = true)
public class RfidDevice extends Device {

  private String rfidId;

  private String manufacturer;

  private Map<String, String> data;

  /**
   * Gets the RFID ID.
   * 
   * @return the RFID ID assigned
   */
  public String getRfidId() {
    return rfidId;
  }

  /**
   * Sets the RFID ID.
   * 
   * @param rfidId the RFID ID
   */
  public void setRfidId(String rfidId) {
    this.rfidId = rfidId;
  }

  /**
   * Gets the {@link DeviceType}.
   * 
   * @return the Device Type
   */
  public DeviceType getType() {
    return DeviceType.RFID;
  }

  /**
   * Gets the Manufacturer Name.
   * 
   * @return the Manufacturer name
   */
  public String getManufacturer() {
    return manufacturer;
  }

  /**
   * Sets the Manufacturer Name.
   * 
   * @param manufacturer the manufacturer
   */
  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  /**
   * Gets a Map with Additional information if was provided.
   * 
   * @return A Map with additional information
   */
  public Map<String, String> getData() {
    return data;
  }

  /**
   * Sets a Map With Additional information.
   * 
   * @param data Map with additional information
   */
  public void setData(Map<String, String> data) {
    this.data = data;
  }
}
