package com.globant.training.google.maps.entities;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;

/**
 * Class to represent a User Entity
 * 
 * @author gabriel.sideri
 *
 */
@Entity(name="Users")
public class UserEntity extends BaseEntity {

	private String name;
	
	private String email;

	private List<String> roles;
	
	private boolean active;
	
	private Date created;

	private Date lastUpdated;

	/**
	 * Gets the user´s name
	 * 
	 * @return the user´s name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the user´s name
	 * 
	 * @param name the user´s name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the user´s email
	 * 
	 * @return the user´s email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the user´s email
	 * 
	 * @param email the user email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets a list of user´s roles
	 * 
	 * @return the user´s roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * Sets the user´s roles
	 * 
	 * @param roles the user's roles
	 */
	public void setRoles(List<String> roles) {
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
	 * Sets flag to indicate if the User is active or not
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
	 * Sets the date where the User was created
	 * 
	 * @param created the date
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * Returns when the entity was modified
	 * 
	 * @return last updated
	 */
	public Date getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * Sets the last updated.
	 *  
	 * @param lastUpdated the last updated
	 */
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
