package com.globant.training.google.maps.antenna.endpoint.transformer;

import com.google.api.server.spi.config.Transformer;

import com.globant.training.google.maps.antenna.endpoint.dtos.AntennaDto;
import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.core.endpoint.validation.DtoValidator;

import org.apache.commons.lang3.Validate;

import java.util.Date;

/**
 * Transformer implementation for {@link AntennaDto} api.
 * 
 * @author gaston.aguilera
 *
 */
public class AntennaApiTransformer implements Transformer<Antenna, AntennaDto> {

  @Override
  public Antenna transformFrom(AntennaDto dto) {
    DtoValidator.validate(dto);
    // @formatter:off
    Antenna antenna = new Antenna()
        .setName(dto.getName())
        .setLatitude(dto.getLatitude())
        .setLongitude(dto.getLongitude())
        .setRangeLimit(dto.getRangeLimit())
        .setSerialNumber(dto.getSerialNumber())
        .setLastUpdated(new Date());
    // @formatter:on
    if (dto.getId() == null) {
      antenna.setCreated(new Date());
    } else {
      antenna.setId(dto.getId());
      antenna.setCreated(dto.getCreated());
    }

    return antenna;
  }

  @Override
  public AntennaDto transformTo(Antenna antenna) {
    Validate.notNull(antenna, "Antenna can not be null");
    
    AntennaDto dto = new AntennaDto();
    // @formatter:off
    dto.setId(antenna.getId())
       .setName(antenna.getName())
       .setSerialNumber(antenna.getSerialNumber())
       .setLatitude(antenna.getLatitude())
       .setLongitude(antenna.getLongitude())
       .setCreated(antenna.getCreated())
       .setLastUpdated(antenna.getLastUpdated())
       .setRangeLimit(antenna.getRangeLimit());
    // @formatter:on
    return dto;
  }

}
