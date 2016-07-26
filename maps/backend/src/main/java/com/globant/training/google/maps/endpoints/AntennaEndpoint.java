package com.globant.training.google.maps.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.endpoints.dtos.AntennaDto;
import com.globant.training.google.maps.entities.Antenna;
import com.globant.training.google.maps.services.AntennaService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

/**
 * API endpoints for {@link Antenna} operations.
 * 
 * @author gastonaguilera
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class AntennaEndpoint {

  private AntennaService antennaService;

  /**
   * Constructor.
   * 
   * @param antennaService the antenna service.
   */
  @Inject
  public AntennaEndpoint(AntennaService antennaService) {
    this.antennaService = antennaService;
  }

  /**
   * Get an Antenna by id.
   * 
   * @param antennaId the id to be found
   * @return {@link Antenna}
   * @throws NotFoundException if none antenna found for provided id
   */
  @ApiMethod(name = "antennas.get", path = "antennas/{antennaId}", httpMethod = HttpMethod.GET)
  public AntennaDto getAntenna(@Named("antennaId") final Long antennaId) {

    Antenna antenna = antennaService.findById(antennaId);

    if (antenna == null) {
      throw new RuntimeException("Antenna Not Found");
    }

    AntennaDto response = new AntennaDto();
    response.fromEntity(antenna);

    return response;
  }

  /**
   * Add Antenna.
   * 
   * @param antennaDto the antenna request
   * @return antennaDto the antenna persisted with id
   */
  @ApiMethod(name = "antennas.add", path = "antennas", httpMethod = HttpMethod.POST)
  public AntennaDto addAntenna(AntennaDto antennaDto) {

    Antenna antenna = antennaService.save(antennaDto.toEntity());
    antennaDto.fromEntity(antenna);

    return antennaDto;
  }


  /**
   * Modify Antenna.
   * 
   * @param antennaDto the antenna request
   * @return antennaDto the antenna dto
   */
  @ApiMethod(name = "antennas.put", path = "antennas/{antennaId}", httpMethod = HttpMethod.PUT)
  public AntennaDto modify(@Named("antennaId") final Long antennaId, AntennaDto antennaDto) {

    Antenna antenna = antennaService.findById(antennaId);

    if (antenna == null) {
      throw new RuntimeException("Antenna Not Found");
    }

    antennaDto.setAntennaId(antennaId);
    antennaDto.setCreated(antenna.getCreated());
    antennaService.save(antennaDto.toEntity());

    return antennaDto;
  }


  /**
   * Find antennas.
   * 
   * @return List of {@link AntennaDto}
   */
  @ApiMethod(name = "antennas.find", path = "antennas", httpMethod = HttpMethod.GET)
  public List<AntennaDto> findAntennas() {

    List<Antenna> antennas = antennaService.getAll();
    List<AntennaDto> antennasDto = new ArrayList<>();

    for (Antenna antenna : antennas) {

      AntennaDto antennaDto = new AntennaDto();
      antennaDto.fromEntity(antenna);
      antennasDto.add(antennaDto);

    }

    return antennasDto;

  }


  /**
   * Delete Antenna by id.
   * 
   */
  @ApiMethod(name = "antennas.delete", path = "antennas/{antennaId}",
      httpMethod = HttpMethod.DELETE)
  public void deleteAntenna(@Named("antennaId") final Long antennaId) {

    Antenna antenna = antennaService.findById(antennaId);

    if (antenna == null) {
      throw new RuntimeException("Antenna Not Found");
    }

    antennaService.deleteById(antennaId);

  }

}
