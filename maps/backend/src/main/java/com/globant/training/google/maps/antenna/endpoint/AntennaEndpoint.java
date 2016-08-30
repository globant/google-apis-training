package com.globant.training.google.maps.antenna.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

import com.globant.training.google.maps.antenna.endpoint.dtos.AntennaDto;
import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.antenna.service.AntennaService;
import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.core.endpoint.BaseEndpoint;
import com.globant.training.google.maps.user.service.UserService;

import java.util.List;

import javax.inject.Named;

/**
 * API endpoints for {@link AntennaDto} operations.
 * 
 * @author gastonaguilera
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class AntennaEndpoint extends BaseEndpoint {

  private AntennaService antennaService;

  /**
   * Constructor.
   * 
   * @param antennaService the antenna service.
   * @param userService the user service.
   */
  @Inject
  public AntennaEndpoint(AntennaService antennaService, UserService userService) {
    super(userService);
    this.antennaService = antennaService;
  }

  /**
   * Get an Antenna by id.
   * 
   * @param antennaId the id to be found
   * @param user the user logged
   * @return {@link AntennaDto}
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "antennas.get", path = "antennas/{antennaId}", httpMethod = HttpMethod.GET)
  public Antenna getAntenna(@Named("antennaId") final Long antennaId, User user)
      throws OAuthRequestException {

    validateAdmin(user);

    Antenna antenna = antennaService.findById(antennaId);

    return antenna;
  }

  /**
   * Add Antenna.
   * 
   * @param antenna the antenna request
   * @param user the user logged
   * @return the antenna added
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "antennas.add", path = "antennas", httpMethod = HttpMethod.POST)
  public Antenna addAntenna(Antenna antenna, User user) throws OAuthRequestException {

    validateAdmin(user);

    return antennaService.create(antenna);
  }

  /**
   * Modify Antenna.
   * 
   * @param putId the antenna id to be modified.
   * @param antenna the antenna request
   * @param user the user logged
   * @return antenna the antenna
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "antennas.put", path = "antennas/{putId}", httpMethod = HttpMethod.PUT)
  public Antenna modify(@Named("putId") final Long putId, Antenna antenna, User user)
      throws OAuthRequestException {

    validateAdmin(user);

    return antennaService.update(putId, antenna);
  }

  /**
   * Find antennas.
   * 
   * @return List of {@link AntennaDto}
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "antennas.find", path = "antennas", httpMethod = HttpMethod.GET)
  public List<Antenna> findAntennas(User user) throws OAuthRequestException {

    validateAdmin(user);
    
    return antennaService.getAll();

  }

  /**
   * Delete Antenna by id.
   *  
   * @param deleteId the antenna id
   * @param user the user logged
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   * 
   */
  @ApiMethod(name = "antennas.delete", path = "antennas/{deleteId}", httpMethod = HttpMethod.DELETE)
  public void deleteAntenna(@Named("deleteId") final Long deleteId, User user)
      throws OAuthRequestException {

    validateAdmin(user);

    antennaService.deleteById(deleteId);

  }

}
