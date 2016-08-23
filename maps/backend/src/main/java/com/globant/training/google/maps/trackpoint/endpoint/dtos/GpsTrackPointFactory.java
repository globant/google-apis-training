package com.globant.training.google.maps.trackpoint.endpoint.dtos;

import static com.globant.training.google.maps.core.endpoint.validation.DtoValidator.validateForErrors;

import com.globant.training.google.maps.trackpoint.entity.GpsTrackPoint;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.HashSet;
import java.util.Set;

/**
 * Gps Track Point Factory.
 * 
 * @author gabriel.sideri
 */
public class GpsTrackPointFactory implements TrackPointFactory {
   
  private static final String IS_REQUIRED = " is required";
  
  private static final String PARAMETER = "parameter.";
  
  @Override
  public TrackPoint buildTrackPoint(TrackPointDto trackPointDto) {
    validate(trackPointDto);
   
    GpsTrackPoint trackPoint = new GpsTrackPoint(); 
    trackPoint.setDeviceId(trackPointDto.getDeviceId());
    trackPoint.setLatitude(trackPointDto.getLatitude());
    trackPoint.setLongitude(trackPointDto.getLongitude());
    trackPoint.setMeasuredDate(
        new DateTime(trackPointDto.getMeasuredDate().toRfc3339String(), DateTimeZone.UTC));
    
    return trackPoint;
  }

  /**
   * Validate is required parameters are provided.
   * 
   * @param trackPoint the object with parameters.
   */
  private void validate(TrackPointDto trackPointDto) {
    Set<String> errors = new HashSet<String>();
    
    if (trackPointDto.getDeviceId() == null) {
      errors.add(PARAMETER + GpsTrackPoint.DEVICE_ID_FIELD + IS_REQUIRED);
    }
   
    if (trackPointDto.getLatitude() == null) {
      errors.add(PARAMETER + TrackPoint.LATITUDE_FIELD + IS_REQUIRED);
    }
    
    if (trackPointDto.getLatitude() == null) {
      errors.add(PARAMETER + TrackPoint.LONGITUDE_FIELD + IS_REQUIRED);
    }
    
    if (trackPointDto.getMeasuredDate() == null) {
      errors.add(PARAMETER + TrackPoint.MEASURED_DATE + IS_REQUIRED);
    }
    validateForErrors(errors);
  }
}
