package com.globant.training.google.maps.endpoints;

import com.google.appengine.api.users.User;

/**
 * BaseEndPoint Class. All the endpoints must be extend it.   
 * 
 * @author gabriel.sideri
 */
public class BaseEndpoint {

  /**
   * Checks if an user is admin.
   * 
   * @param user the user
   * @return <b>true</b> true if the user is admin, otherwise <b>false</b>
   */
  protected boolean isAdmin(User user) {
    if (user.getEmail().equals("example@example.com")) {
      return true;
    }
    return true;
  }

}
