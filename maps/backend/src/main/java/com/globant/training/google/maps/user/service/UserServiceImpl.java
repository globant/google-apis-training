package com.globant.training.google.maps.user.service;


import com.google.inject.Inject;

import com.globant.training.google.maps.user.dao.UserDao;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.entity.UserRole;

import java.util.List;

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
   * @see com.globant.training.google.maps.services.UserService#findUserByGoogleId(java.lang.String)
   */
  @Override
  public AppUser findUserByGoogleId(String id) {
    return userDao.findByGoogleId(id);
  }

  @Override
  public AppUser create(AppUser user) {

    return userDao.put(user);
  }

  @Override
  public AppUser update(Long id, AppUser user) {
    // TODO Auto-generated method stub
    return userDao.put(user);
  }

  @Override
  public AppUser addRole(String googleId, UserRole role) {

    AppUser user = findUserByGoogleId(googleId);

    if (user == null) {
      throw new RuntimeException("User not found");
    }

    if (user.isAdmin()) {
      throw new RuntimeException("User is already admin");

    }

    user.getRoles().add(UserRole.ADMIN);

    return userDao.put(user);
  }

}
