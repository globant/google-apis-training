package com.globant.training.google.maps.daos.objectify;

import com.globant.training.google.maps.daos.UserDao;
import com.globant.training.google.maps.entities.AppUser;
import com.globant.training.google.maps.entities.objectify.AppUserOfyEntity;

public class UserOfyDao extends BaseOfyDao<AppUser, AppUserOfyEntity> implements UserDao {

  public UserOfyDao() {
    super(AppUserOfyEntity.class);
  }

//  @Override
//  public AppUser put(AppUser user) {
//    // TODO Auto-generated method stub
//    return null;
//  }

}
