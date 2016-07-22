package com.globant.training.google.maps.endpoints;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.users.User;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.entities.AppUser;
import com.globant.training.google.maps.services.UserService;

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

  private final UserService userService;

  /**
   * Constructor.
   * 
   * @param userService the user service.
   */
  @Inject
  public UserEndpoint(@Named("userService") UserService userService) {
    this.userService = userService;
  }

  /**
   * Find {@link EntityUser} in the application.
   * 
   * @param user currently authenticated {@link User}
   * @return {@link EntityUser}
   * @throws NotFoundException if none antenna found for provided id.
   */
  @ApiMethod(name = "findUsers", path = "users", httpMethod = HttpMethod.GET)
  public List<AppUser> findUsers(User user) throws NotFoundException {

    checkNotNull(user);

    isAdmin(user);

    List<AppUser> users = userService.getAllUsers();

    if (users.isEmpty()) {
      createEntityUser(user);
      users = userService.getAllUsers();
    }

    return users;
  }

  /**
   * Creates an {@link EntityUser} form a {@link User}.
   * 
   * @param user a {@link User}
   */
  private void createEntityUser(User user) {

    // TODO move to service
    AppUser userToCreate = new AppUser();
    userToCreate.setEmail(user.getEmail());
    userService.addUser(userToCreate);
  }
}
