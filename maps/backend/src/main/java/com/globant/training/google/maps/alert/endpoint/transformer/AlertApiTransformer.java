package com.globant.training.google.maps.alert.endpoint.transformer;

import com.google.api.server.spi.config.Transformer;

import com.globant.training.google.maps.alert.endpoint.dtos.AlertDto;
import com.globant.training.google.maps.alert.endpoint.dtos.CoordinatePointDto;
import com.globant.training.google.maps.alert.entity.Alert;
import com.globant.training.google.maps.alert.entity.LatLng;
import com.globant.training.google.maps.core.endpoint.validation.DtoValidator;

import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Transformer implementation for {@link AlertDto} api.
 * 
 * @author gaston.aguilera
 *
 */
public class AlertApiTransformer implements Transformer<Alert, AlertDto> {


  private static final Comparator<CoordinatePointDto> COORDINATE_COMPARATOR =
      new Comparator<CoordinatePointDto>() {
        @Override
        public int compare(CoordinatePointDto coordinateOne, CoordinatePointDto coordinateTwo) {
          return coordinateOne.getOrder() < coordinateTwo.getOrder() ? -1 : 1;
        }
      };


  @Override
  public Alert transformFrom(AlertDto dto) {
    DtoValidator.validate(dto);

    // @formatter:off
    Alert alert = new Alert()
        .setName(dto.getName())
        .setActive(dto.isActive())
        .setItemId(dto.getItemId())
        .setMode(dto.getMode())
        .setPoligonRegion(processDtoCoordinates(dto.getCoordinates()));
    // @formatter:on
    if (dto.getId() != null) {
      alert.setId(dto.getId());
      alert.setCreated(dto.getCreated());
    }

    return alert;
  }

  @Override
  public AlertDto transformTo(Alert alert) {
    Validate.notNull(alert, "Alert can not be null");

    AlertDto dto = new AlertDto();
    // @formatter:off
    dto.setId(alert.getId())
       .setName(alert.getName())
       .setCreated(alert.getCreated())
       .setLastUpdated(alert.getLastUpdated())
       .setMode(alert.getMode())
       .setActive(alert.isActive())
       .setItemId(alert.getItemId())
       .setCoordinatesFromEntity(alert.getPoligonRegion());
    // @formatter:on
    return dto;
  }

  private List<LatLng> processDtoCoordinates(List<CoordinatePointDto> dtoCoordinates) {

    Collections.sort(dtoCoordinates, COORDINATE_COMPARATOR);

    List<LatLng> coordinates = new ArrayList<>();

    for (CoordinatePointDto coordinateDto : dtoCoordinates) {
      DtoValidator.validate(coordinateDto);

      coordinates.add(new LatLng(coordinateDto.getLatitude(), coordinateDto.getLongitude()));
    }

    return coordinates;
  }

}
