package com.globant.training.google.maps.export.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.types.DateAndTime;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.core.endpoint.BaseEndpoint;
import com.globant.training.google.maps.export.service.ExportService;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.user.service.UserService;

import org.joda.time.DateTime;

import javax.inject.Named;

/**
 * API endpoints for {@link TrackPoint} operations.
 * 
 * @author gaston.aguilera
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class TrackPointEndpoint extends BaseEndpoint {

  private ExportService exportService;

  /**
   * Constructor.
   * 
   * @param exportService the export service.
   * @param userService the user service.
   */
  @Inject
  public TrackPointEndpoint(ExportService exportService, UserService userService) {
    super(userService);
    this.exportService = exportService;
  }

  /**
   * export points by item id and date range.
   * 
   * @throws OAuthRequestException return an exception if the user is not logged.
   */
  @ApiMethod(name = "trackpoint.find", path = "export/fusiontables", httpMethod = HttpMethod.POST)
  public void findTrackPointsByItemId(@Named("itemId") final Long itemId,
      @Named("from") DateAndTime start, @Named("to") DateAndTime end, User user)
          throws OAuthRequestException {

    validateAdmin(user);

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

    exportService.exportTrackPoints(fromDate, toDate, itemId);

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
