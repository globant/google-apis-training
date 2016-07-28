package com.globant.training.google.maps.user.dao;

import java.util.List;

import com.globant.training.google.maps.user.entity.AppUser;

/**
 * User DAO Interface.
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
   * Save or Update User.
   * 
   * @param user the user
   * @return the user persisted
   */
  AppUser put(AppUser user);
  
  /**
   * Find User by google id.
   * 
   * @param id the google id
   * @return the {@link AppUser}
   */
  AppUser findByGoogleId(String id);

}
