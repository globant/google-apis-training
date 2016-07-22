package com.globant.training.google.maps.endpoints.dtos.device.factory;

import static com.globant.training.google.maps.endpoints.validation.DtoValidator.throwError;

import java.util.Map;

import com.globant.training.google.maps.entities.device.Device;
import com.globant.training.google.maps.entities.device.GpsDevice;


/**
 * Factory for GpsDevice instantiation and validation.
 * 
 * @author gaston.aguilera
 *
 */
public class GpsFactory implements DeviceFactory {

  private static final String SERIAL_NUMBER_KEY = "serialNumber";

  @Override
  public Device makeDevice(String name, Map<String, String> attributtes) {

    validate(attributtes);

    GpsDevice gps = new GpsDevice();
    gps.setActive(true);
    gps.setName(name);
    gps.setSerialNumber(String.valueOf(attributtes.get(SERIAL_NUMBER_KEY)));

    return gps;
  }

  /**
   * Validate is required attributes are provided.
   * 
   * @param attributtes the map of attributes.
   */
  private void validate(Map<String, String> attributtes) {
    
    if (!attributtes.containsKey(SERIAL_NUMBER_KEY)) {
      throwError("serialNumber is required");
    }
  }

}
