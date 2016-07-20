package com.globant.training.google.maps.entities.objectify;

import com.googlecode.objectify.annotation.Entity;

import com.globant.training.google.maps.entities.BaseEntity;
import com.globant.training.google.maps.entities.AppUser;

import java.util.Date;
import java.util.List;

/**
 * Class to represent a Maps User Objectify Entity
 * 
 * @author gabriel.sideri
 *
 */
@Entity(name = "Users")
public class AppUserOfyEntity extends BaseEntity implements AppUser {

  private String name;

  private String email;

  private List<String> roles;

  private boolean active;

  private Date created;

  private Date lastUpdated;

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#getName()
   */
  @Override
  public String getName() {
    return name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#setName(java.lang.String)
   */
  @Override
  public void setName(String name) {
    this.name = name;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#getEmail()
   */
  @Override
  public String getEmail() {
    return email;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#setEmail(java.lang.String)
   */
  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#getRoles()
   */
  @Override
  public List<String> getRoles() {
    return roles;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#setRoles(java.util.List)
   */
  @Override
  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#isActive()
   */
  @Override
  public boolean isActive() {
    return active;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#setActive(boolean)
   */
  @Override
  public void setActive(boolean active) {
    this.active = active;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#getCreated()
   */
  @Override
  public Date getCreated() {
    return created;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#setCreated(java.util.Date)
   */
  @Override
  public void setCreated(Date created) {
    this.created = created;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#getLastUpdated()
   */
  @Override
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.entities.MapsUser#setLastUpdated(java.util.Date)
   */
  @Override
  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }
}
