package com.globant.training.google.maps.endpoints.dtos.device.factory;

import static com.globant.training.google.maps.endpoints.validation.DtoValidator.throwError;
import static com.globant.training.google.maps.endpoints.validation.DtoValidator.validateForErrors;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.globant.training.google.maps.entities.device.Device;
import com.globant.training.google.maps.entities.device.RfidDevice;
import com.google.appengine.repackaged.org.codehaus.jackson.map.ObjectMapper;

/**
 * Factory for RfidDevice instantiation and validation.
 * 
 * @author gaston.aguilera
 *
 */
public class RfidFactory implements DeviceFactory {

  private static final String IS_REQUIRED = " is required";
  private static final String MANUFACTURER_KEY = "manufacturer";
  private static final String RFID_ID_KEY = "rfidId";
  private static final String DATA_KEY = "data";



  @Override
  public Device makeDevice(String name, Map<String, String> attributtes) {

    validate(attributtes);

    RfidDevice rfid = new RfidDevice();
    rfid.setName(name);
    rfid.setManufacturer(attributtes.get(MANUFACTURER_KEY));
    rfid.setRfidId(attributtes.get(MANUFACTURER_KEY));

    if (attributtes.containsKey(DATA_KEY)) {
      Map<String, String> data = extractData(attributtes);
      rfid.setData(data);
    }

    return rfid;
  }


  /**
   * Extract and parse data provided.
   * 
   * @param attributtes
   * @return the extracted Map<String, String>
   */
  @SuppressWarnings("unchecked")
  private Map<String, String> extractData(Map<String, String> attributtes) {

    String jsonStringData = attributtes.get(DATA_KEY);
    Map<String, String> data = null;
    try {
      // TODO improve this method.

      data = new ObjectMapper().readValue(jsonStringData, HashMap.class);


    } catch (Exception e) {
      throwError("provided data atributte cannot be parsed");
    }
    return data;
  }


  /**
   * Validate is required attributes are provided.
   * 
   * @param attributtes the map of attributes.
   */
  private void validate(Map<String, String> attributtes) {
    Set<String> errors = new HashSet<String>();
    if (!attributtes.containsKey(MANUFACTURER_KEY)) {
      errors.add(MANUFACTURER_KEY + IS_REQUIRED);
    }
    if (!attributtes.containsKey(RFID_ID_KEY)) {
      errors.add(RFID_ID_KEY + IS_REQUIRED);
    }
    validateForErrors(errors);
  }

}
