package com.globant.training.google.maps.daos;

import com.globant.training.google.maps.entities.UserEntity;

/**
 * User DAO Class.
 * 
 * @author gabriel.sideri
 */
public class UserDao extends BaseDao<UserEntity> {

  public UserDao() {
    super(UserEntity.class);
  }



}
