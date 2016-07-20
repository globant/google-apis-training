package com.globant.training.google.maps.entities;

import java.util.Date;
import java.util.List;

/**
 * Interface to represents the behavior of a MapsUser.
 * 
 * @author gabriel.sideri
 *
 */
public interface AppUser extends Entity{

  /**
   * Gets the user´s name.
   * 
   * @return the user´s name
   */
  String getName();

  /**
   * Sets the user´s name.
   * 
   * @param name the user´s name
   */
  void setName(String name);

  /**
   * Gets the user´s email.
   * 
   * @return the user´s email
   */
  String getEmail();

  /**
   * Sets the user´s email.
   * 
   * @param email the user email
   */
  void setEmail(String email);

  /**
   * Gets a list of user´s roles.
   * 
   * @return the user´s roles
   */
  List<String> getRoles();

  /**
   * Sets the user´s roles.
   * 
   * @param roles the user's roles
   */
  void setRoles(List<String> roles);

  /**
   * Returns <b>true</b> if the User is active, otherwise <b>false</b>
   * 
   * @return if the User is active or not.
   */
  boolean isActive();

  /**
   * Sets flag to indicate if the User is active or not.
   * 
   * @param active true or false
   */
  void setActive(boolean active);

  /**
   * Gets the date where the User was created
   * 
   * @return the creation date.
   */
  Date getCreated();

  /**
   * Sets the date where the User was created.
   * 
   * @param created the date
   */
  void setCreated(Date created);

  /**
   * Returns when the entity was modified.
   * 
   * @return last updated
   */
  Date getLastUpdated();

  /**
   * Sets the last updated.
   * 
   * @param lastUpdated the last updated
   */
  void setLastUpdated(Date lastUpdated);
}
