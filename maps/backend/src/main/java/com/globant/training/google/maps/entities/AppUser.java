package com.globant.training.google.maps.entities;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;

/**
 * Class to represent a Maps User Objectify Entity
 * 
 * @author gabriel.sideri
 *
 */
@Entity(name = "Users")
public class AppUser  extends BaseEntity {


  private String name;

  private String email;

  private List<String> roles;

  private boolean active;

  private Date created;

  private Date lastUpdate;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }
}




