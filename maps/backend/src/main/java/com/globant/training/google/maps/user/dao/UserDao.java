package com.globant.training.google.maps.user.dao;

import com.globant.training.google.maps.user.entity.AppUser;

import java.util.List;

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
  
  /**
   * Find users Paginated.
   * 
   * @param offset the offset
   * @param limit the limit
   * @return List of {@link AppUser}
   */
  List<AppUser> findUsersPaginated(Integer offset, Integer limit);
  
  /**
   * Count all Users.
   * 
   * @return the quantity
   */
  int countAll();

}
