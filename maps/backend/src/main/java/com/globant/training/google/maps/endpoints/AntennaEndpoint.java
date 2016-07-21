package com.globant.training.google.maps.endpoints;

import static com.globant.training.google.maps.endpoints.validation.DtoValidator.validate;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.endpoints.dtos.AntennaDto;
import com.globant.training.google.maps.entities.Antenna;
import com.globant.training.google.maps.services.AntennaService;

import javax.inject.Named;

/**
 * API endpoints for {@link Antenna} operations.
 * 
 * @author gastonaguilera
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc - users.")
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
  @ApiMethod(name = "antenna.get", path = "antenna/{antennaId}", httpMethod = HttpMethod.GET)
  public Antenna getAntenna(@Named("antennaId") final Long antennaId) throws NotFoundException {
    return antennaService.findById(antennaId);
  }

  /**
   * Add Antenna.
   * 
   * @param antennaDto the antenna request
   * @return antennaDto the antenna persisted with id
   */
  @ApiMethod(name = "antenna.add", path = "antenna", httpMethod = HttpMethod.POST)
  public AntennaDto addAntenna(AntennaDto antennaDto) {

    validate(antennaDto);

    return antennaDto;
  }

}
