package com.globant.training.google.maps.trackpoint.endpoint.dtos;

import static com.globant.training.google.maps.core.endpoint.validation.DtoValidator.validateForErrors;

import com.globant.training.google.maps.trackpoint.entity.RfidTrackPoint;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import java.util.HashSet;
import java.util.Set;

/**
 * Rfid Track Point Factory.
 * 
 * @author gabriel.sideri
 */
public class RfidTrackPointFactory implements TrackPointFactory {

  private static final String IS_REQUIRED = " is required";
  
  private static final String PARAMETER = "parameter.";
  
  @Override
  public TrackPoint buildTrackPoint(TrackPointDto trackPointDto) {
    validate(trackPointDto);
    
    RfidTrackPoint trackPoint = new RfidTrackPoint(); 
    trackPoint.setAntennaId(trackPointDto.getAntennaId());
    trackPoint.setRfidId(trackPointDto.getRfidId());
    trackPoint.setLatitude(trackPointDto.getLatitude());
    trackPoint.setLongitude(trackPointDto.getLongitude());
    trackPoint.setMeasuredDate(trackPointDto.getMeasuredDate());
   
    return trackPoint;
  }
  
  /**
   * Validate is required parameters are provided.
   * 
   * @param trackPoint the object with parameters.
   */
  private void validate(TrackPointDto trackPointDto) {
    Set<String> errors = new HashSet<String>();
    
    if (trackPointDto.getRfidId() == null || trackPointDto.getRfidId().isEmpty() ) {
      errors.add(PARAMETER + RfidTrackPoint.RFID_ID_FIELD + IS_REQUIRED);
    }
   
    if (trackPointDto.getAntennaId() == null) {
      errors.add(PARAMETER + RfidTrackPoint.ANTENNA_ID_FIELD + IS_REQUIRED);
    }
    
    if (trackPointDto.getMeasuredDate() == null) {
      errors.add(PARAMETER + TrackPoint.MEASURED_DATE + IS_REQUIRED);
    }
    validateForErrors(errors);
  }

}
