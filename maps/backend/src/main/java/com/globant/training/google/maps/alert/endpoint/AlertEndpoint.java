package com.globant.training.google.maps.alert.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

import com.globant.training.google.maps.alert.entity.Alert;
import com.globant.training.google.maps.alert.service.AlertService;
import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.core.endpoint.BaseEndpoint;
import com.globant.training.google.maps.user.service.UserService;

import java.util.List;

import javax.inject.Named;

/**
 * API endpoints for {@link AlertDto} operations.
 * 
 * @author gastonaguilera
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class AlertEndpoint extends BaseEndpoint {

  private AlertService alertService;

  /**
   * Constructor.
   * 
   * @param alertService the alert service.
   * @param userService the user service.
   */
  @Inject
  public AlertEndpoint(AlertService alertService, UserService userService) {
    super(userService);
    this.alertService = alertService;
  }

  /**
   * Get an Alert by id.
   * 
   * @param alertId the id to be found
   * @return {@link AlertDto}
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   * @throws NotFoundException if none alert found for provided id
   */
  @ApiMethod(name = "alerts.get", path = "alerts/{alertId}", httpMethod = HttpMethod.GET)
  public Alert getAlert(@Named("alertId") final Long alertId, User user)
      throws OAuthRequestException {

    validateAdmin(user);

    Alert alert = alertService.findById(alertId);

    return alert;
  }

  /**
   * Add Alert.
   * 
   * @param alert the alert request
   * @return user the logged user
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "alerts.add", path = "alerts", httpMethod = HttpMethod.POST)
  public Alert addAlert(Alert alert, User user) throws OAuthRequestException {

    validateAdmin(user);

    return alertService.create(alert);
  }

  /**
   * Modify Alert.
   * 
   * @param alert the alert request
   * @return alert the alert
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "alerts.put", path = "alerts/{putId}", httpMethod = HttpMethod.PUT)
  public Alert modify(@Named("putId") final Long putId, Alert alert, User user)
      throws OAuthRequestException {

    validateAdmin(user);

    return alertService.update(putId, alert);
  }

  /**
   * Find alerts.
   * 
   * @return List of {@link AlertDto}
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "alerts.find", path = "alerts", httpMethod = HttpMethod.GET)
  public List<Alert> findAlerts(User user) throws OAuthRequestException {

    validateAdmin(user);

    return alertService.getAll();

  }

  /**
   * Delete Alert by id.
   * 
   * @throws OAuthRequestException
   * 
   */
  @ApiMethod(name = "alerts.delete", path = "alerts/{deleteId}", httpMethod = HttpMethod.DELETE)
  public void deleteAlert(@Named("deleteId") final Long deleteId, User user)
      throws OAuthRequestException {

    validateAdmin(user);

    alertService.deleteById(deleteId);

  }

}
