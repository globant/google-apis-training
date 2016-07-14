package com.globant.training.google.maps.endpoints;

import javax.inject.Named;

import com.globant.training.google.maps.entities.AntennaEntity;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.NotFoundException;



/**
 * API endpoints for {@link AntennaEntity} operations.
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
   * @return {@link AntennaEntity}
   * 
   * @throws NotFoundException if none antenna found for provided id.
   */
  @ApiMethod(name = "getConference", path = "antenna/{antennaId}", httpMethod = HttpMethod.GET)
  public AntennaEntity getAntenna(@Named("antennaId") final Long antennaId) throws NotFoundException {
    
    AntennaEntity antenna = new AntennaEntity();
    antenna.setId(antennaId);

    return antenna;
  }
}
