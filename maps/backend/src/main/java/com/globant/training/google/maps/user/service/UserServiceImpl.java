package com.globant.training.google.maps.user.service;


import java.util.List;

import com.globant.training.google.maps.user.dao.UserDao;
import com.globant.training.google.maps.user.entity.AppUser;
import com.google.inject.Inject;

/**
 * {@link UserService} Implementation
 * 
 * @author gabriel.sideri
 */
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  @Inject
  public UserServiceImpl(UserDao userDao) {
    super();
    this.userDao = userDao;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.services.UserService#getAllUsers()
   */
  @Override
  public List<AppUser> getAllUsers() {
    return userDao.getAll();
  }


  /*
   * (non-Javadoc)
   * 
   * @see
   * com.globant.training.google.maps.services.UserService#save(com.globant.training.google.maps.
   * entities.AppUser)
   */
  @Override
  public AppUser save(AppUser user) {
    return userDao.put(user);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.services.UserService#findUserByGoogleId(java.lang.String)
   */
  @Override
  public AppUser findUserByGoogleId(String id) {
    return userDao.findByGoogleId(id);
  }

}
