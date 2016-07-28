package com.globant.training.google.maps.endpoints;

import com.globant.training.google.maps.entities.AppUser;
import com.globant.training.google.maps.services.UserService;
import com.google.api.server.spi.auth.common.User;
import com.google.appengine.api.oauth.OAuthRequestException;

/**
 * BaseEndPoint Class. All the endpoints must be extend it.
 * 
 * @author gabriel.sideri
 */
public abstract class BaseEndpoint {

  protected final UserService userService;

  /**
   * Constructor.
   * 
   * @param userService the user service.
   */
  public BaseEndpoint(UserService userService) {
    this.userService = userService;
  }

  /**
   * Login user into the APP. If the user does not exists, it will be created it.
   * 
   * @param the {@link User} authenticated by google.
   * @return the {@link AppUser}
   * @throws OAuthRequestException if the {@link User} is not authenticated.
   * 
   */
  protected AppUser loginUser(User user) throws OAuthRequestException {

    AppUser applicationUser = null;

    if (user == null) {
      throw new OAuthRequestException("User not Authenticated");
    }

    applicationUser = userService.findUserByGoogleId(user.getId());

    if (applicationUser == null) {

      applicationUser = new AppUser(user.getId(), user.getEmail());
      applicationUser.setActive(true);
      userService.save(applicationUser);

    }

    return applicationUser;

  }
  
  
}
