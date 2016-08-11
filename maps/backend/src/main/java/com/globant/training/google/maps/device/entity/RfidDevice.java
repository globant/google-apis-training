package com.globant.training.google.maps.device.entity;

import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Subclass;

import java.util.HashMap;
import java.util.Map;

import javax.jdo.annotations.Embedded;

/**
 * Class to represent a RFID entity
 * 
 * @author gabriel.sideri
 */
@Subclass(name = "Rfid", index = true)
public class RfidDevice extends Device {

  public static final String MANUFACTURER_KEY = "manufacturer";
  public static final String RFID_ID_KEY = "rfidId";

  @Index
  private String rfidId;

  private String manufacturer;

  @Embedded
  private Map<String, String> data;

  @Override
  public Map<String, String> getAttributes() {

    Map<String, String> attributtes = new HashMap<String, String>();

    attributtes.put(MANUFACTURER_KEY, this.manufacturer);
    attributtes.put(RFID_ID_KEY, this.rfidId);

    if (data != null) {
      attributtes.putAll(data);
    }

    return attributtes;
  }

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

  @Override
  public void update(Device device) {
    // TODO Auto-generated method stub

  }
}
