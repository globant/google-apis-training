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
import com.globant.training.google.maps.core.endpoint.dto.PaginatedResponseDto;
import com.globant.training.google.maps.user.entity.UserRole;
import com.globant.training.google.maps.user.service.UserService;

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
  
  private static final int MAX_LIMIT = 50;

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
   * @param page the page index
   * @param pageSize the page size
   * @return {@link PaginatedResponseDto}
   * @throws OAuthRequestException return the exception if the user is not authenticated
   */
  @ApiMethod(name = "findUsers", path = "users", httpMethod = HttpMethod.GET)
  public PaginatedResponseDto findUsers(@Named("pageIndex") Integer page,
      @Named("pageSize") Integer pageSize, User user)
      throws NotFoundException, OAuthRequestException {

    validateAdmin(user);
    
    if (page == null) {
      page = 0;
    }

    if (pageSize == null || pageSize > 50) {
      pageSize = MAX_LIMIT;
    }
    
    return userService.findUsersPaginated(page, pageSize);
  }

}
