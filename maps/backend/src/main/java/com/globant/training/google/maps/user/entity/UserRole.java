package com.globant.training.google.maps.user.entity;

/**
 * User Role Enum.
 * 
 * @author gabriel.sideri
 *
 */
public enum UserRole {

  /**
   * ADMIN user.
   */
  ADMIN("ADMIN"),
  /**
   * Regular user.
   */
  STANDARD("STANDARD");

  private String name;

  private UserRole(String name) {
    this.name = name;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}
