package com.globant.training.google.maps.services;

import com.globant.training.google.maps.entities.UserEntity;

import java.util.List;

/**
 * Class to expose the {@link UserEntity} operations
 * 
 * @author gabriel.sideri
 */
public interface UserService {

  /**
   * Get all users.
   * 
   * @return a list with all users
   */
  public List<UserEntity> getAllUsers();

  /**
   * Adds a new user.
   * 
   * @param user the user to be added
   */
  public void addUser(UserEntity user);

}
