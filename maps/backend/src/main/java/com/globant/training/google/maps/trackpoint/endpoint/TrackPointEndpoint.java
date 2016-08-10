package com.globant.training.google.maps.trackpoint.endpoint;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.TrackPointDto;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.trackpoint.service.TrackPointService;

import javax.inject.Named;

/**
 * API endpoints for {@link TrackPoint} operations.
 * 
 * @author gabriel.sideri
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class TrackPointEndpoint {

  private TrackPointService trackPointService;

  /**
   * Constructor.
   * 
   * @param trackPointService the track point service.
   */
  @Inject
  public TrackPointEndpoint(TrackPointService trackPointService) {
    this.trackPointService = trackPointService;
  }

  /**
   * Add TrackPoint.
   * 
   * @param trackPointToSave the track point request
   * @return trackPointDto the track point persisted with id
   * 
   */
  @ApiMethod(name = "trackpoint.add", path = "trackpoints", httpMethod = HttpMethod.POST)
  public TrackPoint addTrackPoint(TrackPoint trackPointToSave) {
    
    TrackPoint trackPoint = trackPointService.save(trackPointToSave);

    return trackPoint;
  }


  /**
   * Gets track point by id.
   * 
   * @return {@link TrackPointDto}
   */
  @ApiMethod(name = "trackpoint.get", path = "trackpoints/{trackPointId}",
      httpMethod = HttpMethod.GET)
  public TrackPoint getTrackPoint(@Named("trackPointId") final Long trackPointId) {
    TrackPoint trackPoint = trackPointService.findById(trackPointId);

    return trackPoint;
  }

}
