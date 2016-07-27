package com.globant.training.google.maps.entities;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Class to represent a AppUser Objectify Entity
 * 
 * @author gabriel.sideri
 *
 */
@Entity(name = "Users")
public class AppUser extends BaseEntity {

  @Index
  private String googleId;

  private String name;

  private String email;

  private List<UserRole> roles = new ArrayList<>();

  private boolean active;

  private Date created;

  private Date lastUpdate;

  @Ignore
  public static final String GOOGLE_ID_FIELD = "googleId";

  /**
   * Empty Constructor. Mandatory to fill values using objectify.
   */
  public AppUser() {}

  /**
   * AppUser Constructor.
   * 
   * @param id the google id
   * @param email the email
   */
  public AppUser(String id, String email) {
    this.email = email;
    this.googleId = id;
    this.created = new Date();
    roles.add(UserRole.STANDARD);
  }

  /**
   * Gets the user´s name.
   * 
   * @return the user´s name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the user´s name.
   * 
   * @param name the user´s name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets the user´s email.
   * 
   * @return the user´s email
   */
  public String getEmail() {
    return email;
  }

  /**
   * Sets the user´s email.
   * 
   * @param email the user email
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Gets a list of user´s roles.
   * 
   * @return the user´s roles
   */
  public List<UserRole> getRoles() {
    return roles;
  }

  /**
   * Sets the user´s roles.
   * 
   * @param roles the user's roles
   */
  public void setRoles(List<UserRole> roles) {
    this.roles = roles;
  }

  /**
   * Returns <b>true</b> if the User is active, otherwise <b>false</b>
   * 
   * @return if the User is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets flag to indicate if the User is active or not.
   * 
   * @param active true or false
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Gets the date where the User was created
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Sets the date where the User was created.
   * 
   * @param created the date
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Returns when the entity was modified.
   * 
   * @return last updated
   */
  public Date getLastUpdate() {
    return lastUpdate;
  }

  /**
   * Sets the last updated.
   * 
   * @param lastUpdate the last updated
   */
  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  /**
   * Sets Google Id.
   * 
   * @param googleId the google id
   */
  public void setGoogleId(String googleId) {
    this.googleId = googleId;
  }

  /**
   * Checks if the user is {@link UserRole#ADMIN}.
   * 
   * @return true if the user is admin. Otherwise false.
   */
  public boolean isAdmin() {
    return roles.contains(UserRole.ADMIN);
  }
}


