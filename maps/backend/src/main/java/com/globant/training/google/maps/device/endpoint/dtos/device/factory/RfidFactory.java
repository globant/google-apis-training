package com.globant.training.google.maps.device.endpoint.dtos.device.factory;

import static com.globant.training.google.maps.core.endpoint.validation.DtoValidator.validateForErrors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.entity.RfidDevice;

/**
 * Factory for RfidDevice instantiation and validation.
 * 
 * @author gaston.aguilera
 *
 */
public class RfidFactory implements DeviceFactory {

  private static final String IS_REQUIRED = " is required";
  private static final String ATTRIBUTES = "attributtes.";
  


  @Override
  public Device makeDevice(String name, boolean active, Map<String, String> attributtes) {

    validate(attributtes);

    RfidDevice rfid = new RfidDevice();
    rfid.setActive(active);
    rfid.setName(name);
    rfid.setManufacturer(attributtes.get(RfidDevice.MANUFACTURER_KEY));
    rfid.setRfidId(attributtes.get(RfidDevice.RFID_ID_KEY));

    rfid.setData(extractAdditionalData(attributtes));

    return rfid;
  }

  /**
   * Extract and parse data provided.
   * 
   * @param attributtes
   * @return the extracted Map<String, String>
   */
  private Map<String, String> extractAdditionalData(Map<String, String> attributtes) {

    
    attributtes.remove(RfidDevice.MANUFACTURER_KEY);
    attributtes.get(RfidDevice.RFID_ID_KEY);
    
    Map<String, String> data = new HashMap<String, String>();
    data.putAll(attributtes);

    return data;
  }

  /**
   * Validate is required attributes are provided.
   * 
   * @param attributtes the map of attributes.
   */
  private void validate(Map<String, String> attributtes) {
    Set<String> errors = new HashSet<String>();
    if (!attributtes.containsKey(RfidDevice.MANUFACTURER_KEY)) {
      errors.add(ATTRIBUTES + RfidDevice.MANUFACTURER_KEY + IS_REQUIRED);
    }
    if (!attributtes.containsKey(RfidDevice.RFID_ID_KEY)) {
      errors.add(ATTRIBUTES + RfidDevice.RFID_ID_KEY + IS_REQUIRED);
    }
    validateForErrors(errors);
  }

}
