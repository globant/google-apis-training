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
  
  //AppUser put(AppUser user);

}
