package com.globant.training.google.maps.user.service;

import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.user.entity.AppUser;

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
   * Save or update user.
   * 
   * @param user the user to be persisted
   * @return the user persisted
   */
  AppUser save(AppUser user);

  /**
   * Find User by google id.
   * 
   * @param id the google id
   * @return the {@link Antenna}
   */
  AppUser findUserByGoogleId(String id);

}
