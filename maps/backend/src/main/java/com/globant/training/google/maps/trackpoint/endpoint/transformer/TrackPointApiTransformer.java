package com.globant.training.google.maps.trackpoint.endpoint.transformer;

import com.google.api.server.spi.config.Transformer;

import com.globant.training.google.maps.core.endpoint.validation.DtoValidator;
import com.globant.training.google.maps.device.entity.DeviceType;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.GpsTrackPointFactory;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.RfidTrackPointFactory;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.TrackPointDto;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.TrackPointFactory;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import java.util.HashMap;
import java.util.Map;


/**
 * Transformer implementation for {@link TrackPointDto} api.
 * 
 * @author gaston.aguilera
 *
 */
public class TrackPointApiTransformer implements Transformer<TrackPoint, TrackPointDto> {

  private static final Map<DeviceType, TrackPointFactory> trackPointFactoryMap;

  static {
    trackPointFactoryMap = new HashMap<DeviceType, TrackPointFactory>();
    trackPointFactoryMap.put(DeviceType.GPS, new GpsTrackPointFactory());
    trackPointFactoryMap.put(DeviceType.RFID, new RfidTrackPointFactory());
  }

  @Override
  public TrackPoint transformFrom(TrackPointDto dto) {
    DtoValidator.validate(dto);

    TrackPoint trackPoint = trackPointFactoryMap.get(dto.getType()).buildTrackPoint(dto);

    return trackPoint;
  }

  @Override
  public TrackPointDto transformTo(TrackPoint trackPoint) {
    TrackPointDto dto = new TrackPointDto();
    // @formatter:off
    dto.setId(trackPoint.getId()).setLatitude(trackPoint.getLatitude())
        .setLongitude(trackPoint.getLongitude()).setMeasuredDate(trackPoint.getMeasuredDate())
        .setSavedDate(trackPoint.getSavedDate());
    // @formatter:on
    return dto;
  }

}
