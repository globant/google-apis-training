package com.globant.training.google.maps.core.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.appengine.api.utils.SystemProperty;

import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.entity.UserRole;
import com.globant.training.google.maps.user.service.UserService;

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
      
      //In development environment every user will be admin.
      if (!SystemProperty.environment.value().equals(SystemProperty.Environment.Value.Production)) {
        applicationUser.getRoles().add(UserRole.ADMIN);
      }
      
      userService.create(applicationUser);

    }

    return applicationUser;

  }
  
  /**
   * Validates if provided user is an admin user.
   * 
   * @param user user to be validated
   * 
   * @throws OAuthRequestException if has not rights.
   */
  protected void validateAdmin(User user) throws OAuthRequestException {
    AppUser loggedUser = loginUser(user);

    if (!loggedUser.isAdmin()) {
      throw new RuntimeException("User not authorized");
    }
  }
  
  
}
