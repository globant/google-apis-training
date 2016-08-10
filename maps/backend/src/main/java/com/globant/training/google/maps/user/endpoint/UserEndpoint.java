package com.globant.training.google.maps.user.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.core.endpoint.BaseEndpoint;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.entity.UserRole;
import com.globant.training.google.maps.user.service.UserService;

import java.util.List;

import javax.inject.Named;

/**
 * API endpoints for {@link User} operations.
 * 
 * @author gaston.aguilera
 */
@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class UserEndpoint extends BaseEndpoint {

  /**
   * Constructor.
   * 
   * @param userService the user service.
   */
  @Inject
  public UserEndpoint(UserService userService) {
    super(userService);
  }

  /**
   * Find {@link EntityUser} in the application.
   * 
   * @param user currently authenticated {@link User}
   * @return {@link EntityUser}
   * @throws NotFoundException if none antenna found for provided id.
   * @throws OAuthRequestException return the exception if the user is not authenticated
   */
  @ApiMethod(name = "findUsers", path = "users", httpMethod = HttpMethod.GET)
  public List<AppUser> findUsers(User user) throws NotFoundException, OAuthRequestException {

    List<AppUser> users = userService.getAllUsers();

    return users;
  }


  /**
   * Sets admin role for a specific user. The user must be registered into the application.
   * 
   * @param googleId the google id.
   */
  @ApiMethod(name = "user.admin", path = "users/admin/role/{googleId}", httpMethod = HttpMethod.PUT)
  public void setAdminRole(@Named("googleId") final String googleId) {

    userService.addRole(googleId, UserRole.ADMIN);

  }
}
