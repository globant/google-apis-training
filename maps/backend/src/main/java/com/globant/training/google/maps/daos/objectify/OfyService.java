package com.globant.training.google.maps.daos.objectify;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import com.globant.training.google.maps.entities.UserEntity;


/**
 * Class to provide access to {@link Objectify} Methods.
 * All the entities must be registered here.
 * 
 * @author gabriel.sideri
 */
public class OfyService {

  // Register all entities //
  static {
    ObjectifyService.register(UserEntity.class);
  }

  /**
   * Access to {@link ObjectifyService#ofy()} Service.
   * 
   * @return the {@link ObjectifyService#ofy()}
   */
  public static Objectify ofy() {
    return ObjectifyService.ofy();
  }

  /**
   * Access to {@link ObjectifyService#factory()}.
   * 
   * @return the  {@link ObjectifyService#factory()}
   */
  public static ObjectifyFactory factory() {
    return ObjectifyService.factory();
  }
}