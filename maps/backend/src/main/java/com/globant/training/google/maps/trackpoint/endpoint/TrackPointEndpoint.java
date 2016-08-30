package com.globant.training.google.maps.trackpoint.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.types.DateAndTime;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.core.endpoint.BaseEndpoint;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.TrackPointDto;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.trackpoint.service.TrackPointService;
import com.globant.training.google.maps.user.service.UserService;

import org.joda.time.DateTime;

import java.util.List;

import javax.inject.Named;

/**
 * API endpoints for {@link TrackPoint} operations.
 * 
 * @author gabriel.sideri
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class TrackPointEndpoint extends BaseEndpoint {

  private TrackPointService trackPointService;

  /**
   * Constructor.
   * 
   * @param trackPointService the trackpoint service.
   * @param userService the user service.
   */
  @Inject
  public TrackPointEndpoint(TrackPointService trackPointService, UserService userService) {
    super(userService);
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
   * @param trackPointId the track point id
   * @param user the user logged
   * @return {@link TrackPointDto}
   * @throws OAuthRequestException return an exception if the user is not logged
   */
  @ApiMethod(name = "trackpoint.get", path = "trackpoints/{trackPointId}",
      httpMethod = HttpMethod.GET)
  public TrackPoint getTrackPoint(@Named("trackPointId") final Long trackPointId, User user)
      throws OAuthRequestException {
    
    validateAdmin(user);
     
    TrackPoint trackPoint = trackPointService.findById(trackPointId);

    return trackPoint;
  }


  /**
   * Find track points by item id and date range.
   * 
   * @itemId the item id
   * @param start the start date
   * @param end the end date
   * @throws OAuthRequestException return an exception if the user is not logged.
   */
  @ApiMethod(name = "trackpoint.find", path = "trackpoints", httpMethod = HttpMethod.GET)
  public List<TrackPoint> findTrackPointsByItemId(@Named("itemId") final Long itemId,
      @Named("from") DateAndTime start, @Named("to") DateAndTime end, User user)
          throws OAuthRequestException {

    loginUser(user);

    validateDates(start, end);

    DateTime fromDate = null;
    DateTime toDate = null;

    if (start == null && end == null) {
      toDate = new DateTime();
      fromDate = toDate.minusWeeks(1);
    } else {
      fromDate = new DateTime(start.toRfc3339String());
      toDate = new DateTime(end.toRfc3339String());
    }

    return trackPointService.find(fromDate, toDate, itemId);

  }

  /**
   * Validates that provided dates (range) are: both completed or both null.
   * 
   * @param start the start date.
   * @param end the end date.
   */
  private void validateDates(DateAndTime start, DateAndTime end) {

    if ((start == null && end != null)) {
      throw new RuntimeException(
          "You can not send 'from' parameter as null if 'to' parameters is send it.");
    }

    if ((start != null && end == null)) {
      throw new RuntimeException(
          "You can not send 'to' parameter as null if 'from' parameters is send it.");
    }

  }

}
