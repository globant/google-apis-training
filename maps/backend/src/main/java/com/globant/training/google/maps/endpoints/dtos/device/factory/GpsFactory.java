package com.globant.training.google.maps.endpoints.dtos.device.factory;

import static com.globant.training.google.maps.endpoints.validation.DtoValidator.throwError;

import java.util.HashMap;
import java.util.Map;

import com.globant.training.google.maps.entities.device.Device;
import com.globant.training.google.maps.entities.device.GpsDevice;
import com.globant.training.google.maps.entities.device.RfidDevice;


/**
 * Factory for GpsDevice instantiation and validation.
 * 
 * @author gaston.aguilera
 *
 */
public class GpsFactory implements DeviceFactory {



  @Override
  public Device makeDevice(String name, Map<String, String> attributtes) {

    validate(attributtes);

    GpsDevice gps = new GpsDevice();
    gps.setActive(true);
    gps.setName(name);
    gps.setSerialNumber(String.valueOf(attributtes.get(GpsDevice.SERIAL_NUMBER_KEY)));
    
    gps.setData(extractAdditionalData(attributtes));

    return gps;
  }

  /**
   * Validate is required attributes are provided.
   * 
   * @param attributtes the map of attributes.
   */
  private void validate(Map<String, String> attributtes) {
    
    if (!attributtes.containsKey(GpsDevice.SERIAL_NUMBER_KEY)) {
      throwError("attributtes.serialNumber is required");
    }
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

}
