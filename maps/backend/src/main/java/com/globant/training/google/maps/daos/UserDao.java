package com.globant.training.google.maps.daos;

import com.globant.training.google.maps.entities.AppUser;

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
  List<AppUser>  getAll();
  
  /**
   * @param user
   * @return
   */
  AppUser put(AppUser user);

}
