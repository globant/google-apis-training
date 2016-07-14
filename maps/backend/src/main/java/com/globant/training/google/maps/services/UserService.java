package com.globant.training.google.maps.services;

import java.util.List;

import com.globant.training.google.maps.entities.UserEntity;

public interface UserService {

  public List<UserEntity> getAllUsers();

  public void addUser(UserEntity user);

}
