package com.globant.training.google.maps.services;

import java.util.List;

import com.globant.training.google.maps.daos.UserDao;
import com.globant.training.google.maps.entities.UserEntity;
import com.google.inject.Inject;

/**
 * @author gabriel.sideri
 */
public class UserServiceImpl implements UserService {

  private final UserDao userDao;

  @Inject
  public UserServiceImpl(UserDao userDao) {
    super();
    this.userDao = userDao;
  }

  @Override
  public List<UserEntity> getAllUsers() {
    return userDao.getAll();
  }

  @Override
  public void addUser(UserEntity user) {
    userDao.put(user);
  }

}
