package com.globant.training.google.maps.user.service;

import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.entity.UserRole;

import java.util.List;

/**
 * Class to expose the {@link UserService} operations
 * 
 * @author gabriel.sideri
 */
public interface UserService {

  /**
   * Get all users.
   * 
   * @return a list with all users
   */
  List<AppUser> getAllUsers();

  /**
   * Create user.
   * 
   * @param user the user to be persisted
   * @return the user persisted
   */
  AppUser create(AppUser user);
  
  /**
   * Updates a user.
   * 
   * @param id the user id
   * @param user the user to be persisted
   * @return the user persisted
   */
  AppUser update(Long id, AppUser user);
  
  /**
   * Save or update user.
   * 
   * @param googleId the google user id
   * @param role the role to be granted
   * @return the user persisted
   */
  AppUser addRole(String googleId, UserRole role);

  /**
   * Find User by google id.
   * 
   * @param id the google id
   * @return the {@link Antenna}
   */
  AppUser findUserByGoogleId(String id);

}
