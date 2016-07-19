package com.globant.training.google.maps.services;

import com.globant.training.google.maps.entities.MapsUser;

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
  public List<MapsUser> getAllUsers();

  /**
   * Adds a new user.
   * 
   * @param user the user to be added
   */
  public void addUser(MapsUser user);

}
