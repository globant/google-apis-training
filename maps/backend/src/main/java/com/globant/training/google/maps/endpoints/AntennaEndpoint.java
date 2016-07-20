package com.globant.training.google.maps.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.NotFoundException;

import com.globant.training.google.maps.entities.Antenna;

import javax.inject.Named;

/**
 * API endpoints for {@link Antenna} operations.
 * 
 * @author gastonaguilera
 *
 */
@Api(name = "antennaApi", version = "v1",
    namespace = @ApiNamespace(ownerDomain = "training.google.maps.globant.com",
        ownerName = "training.google.maps.globant.com",
        packagePath = "com.globant.training.google.maps.endpoints"))
public class AntennaEndpoint {

  /**
   * Get an Antenna by id.
   * 
   * 
   * @param antennaId the id to be found.
   * 
   * @return {@link Antenna}
   * 
   * @throws NotFoundException if none antenna found for provided id.
   */
  @ApiMethod(name = "getConference", path = "antenna/{antennaId}", httpMethod = HttpMethod.GET)
  public Antenna getAntenna(@Named("antennaId") final Long antennaId)
      throws NotFoundException {

    Antenna antenna = new Antenna();
    antenna.setId(antennaId);

    return antenna;
  }
}
