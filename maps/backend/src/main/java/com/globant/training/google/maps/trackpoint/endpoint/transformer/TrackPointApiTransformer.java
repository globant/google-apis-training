package com.globant.training.google.maps.trackpoint.endpoint.transformer;

import com.google.api.server.spi.config.Transformer;

import com.globant.training.google.maps.core.endpoint.validation.DtoValidator;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.TrackPointDto;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;


/**
 * Transformer implementation for {@link TrackPointDto} api.
 * 
 * @author gaston.aguilera
 *
 */
public class TrackPointApiTransformer implements Transformer<TrackPoint, TrackPointDto> {

  @Override
  public TrackPoint transformFrom(TrackPointDto dto) {
    DtoValidator.validate(dto);

    TrackPoint trackPoint = new TrackPoint();
    // @formatter:off
    trackPoint.setDeviceId(dto.getDeviceId())
              .setLatitude(dto.getLatitude())
              .setLongitude(dto.getLongitude())
              .setMeasuredDate(dto.getMeasuredDate());
    // @formatter:on
    if (dto.getId() != null) {
      // TODO review if this shoud be moved to service.
      trackPoint.setId(dto.getId());
      trackPoint.setSavedDate(dto.getSavedDate());
    }

    return trackPoint;
  }

  @Override
  public TrackPointDto transformTo(TrackPoint trackPoint) {
    TrackPointDto dto = new TrackPointDto();
    // @formatter:off
    dto.setId(trackPoint.getId())
       .setLatitude(trackPoint.getLatitude())
       .setLongitude(trackPoint.getLongitude())
       .setMeasuredDate(trackPoint.getMeasuredDate())
       .setSavedDate(trackPoint.getSavedDate());
    // @formatter:on
    return dto;
  }

}
