package com.globant.training.google.maps.daos.objectify;

import com.globant.training.google.maps.daos.UserDao;
import com.globant.training.google.maps.entities.MapsUser;
import com.globant.training.google.maps.entities.objectify.MapsUserOfyEntity;

import java.util.List;

public class UserOfyDao extends BaseOfyDao<MapsUserOfyEntity> implements UserDao {

  public UserOfyDao() {
    super(MapsUserOfyEntity.class);
  }

  @Override
  public List<MapsUser> getAllUsers() {
    return null;
  }

  @Override
  public void addUser(MapsUser user) {
    // TODO Auto-generated method stub
  }

}
