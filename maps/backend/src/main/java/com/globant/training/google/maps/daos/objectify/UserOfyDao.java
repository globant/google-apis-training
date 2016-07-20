package com.globant.training.google.maps.daos.objectify;

import com.globant.training.google.maps.daos.UserDao;
import com.globant.training.google.maps.entities.AppUser;

public class UserOfyDao extends BaseOfyDao<AppUser> implements UserDao {

  public UserOfyDao() {
    super(AppUser.class);
  }

}
