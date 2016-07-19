package com.globant.training.google.maps.daos;

import com.globant.training.google.maps.entities.MapsUser;

import java.util.List;

/**
 * User DAO Class.
 * 
 * @author gabriel.sideri
 */
public interface UserDao {

  /**
   * Get all users.
   * 
   * @return a list with all users
   */
  List<MapsUser> getAllUsers();

  /**
   * Adds a new user.
   * 
   * @param user the user to be added
   */
  void addUser(MapsUser user);
}
