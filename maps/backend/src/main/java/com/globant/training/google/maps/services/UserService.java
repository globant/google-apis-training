package com.globant.training.google.maps.services;

import com.globant.training.google.maps.entities.AppUser;

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
   * Adds a new user.
   * 
   * @param user the user to be added
   */
  void addUser(AppUser user);


}
