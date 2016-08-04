package com.globant.training.google.maps.item.dtos;

import static com.globant.training.google.maps.core.endpoint.validation.DtoValidator.validate;

import com.globant.training.google.maps.core.endpoint.dto.Dto;
import com.globant.training.google.maps.item.entity.Item;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Item DTO.
 * 
 * @author gabriel.sideri
 */
public class ItemDto implements Dto<Item, ItemDto> {

  private Long id;

  @NotNull
  private String name;

  private Long deviceId;
  
  private boolean active;

  private Date created;

  private Date lastUpdated;

  /**
   * Gets item id.
   * 
   * @return the item id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets item id.
   * 
   * @param id the item id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Get item name.
   * 
   * @return the item name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the item name.
   * 
   * @param name the item name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Return <b>true</b> if the item is active, otherwise <b>false</b>.
   * 
   * @return a flag to indicate if the item is active or not.
   */
  public boolean isActive() {
    return active;
  }

  /**
   * Sets the flag if the item is active or not.
   * 
   * @param active the boolean value
   */
  public void setActive(boolean active) {
    this.active = active;
  }

  /**
   * Sets the date when the item was created.
   * 
   * @param created the date
   */
  public void setCreated(Date created) {
    this.created = created;
  }

  /**
   * Gets the date when the item was created
   * 
   * @return the creation date.
   */
  public Date getCreated() {
    return created;
  }

  /**
   * Returns when the entity was modified.
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

  /**
   * Get device id associated with the item.
   * 
   * @return device id
   */
  public Long getDeviceId() {
    return deviceId;
  }

  /**
   * Associate device with the item.
   * 
   * @param deviceId the device id
   */
  public void setDeviceId(Long deviceId) {
    this.deviceId = deviceId;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.core.endpoint.dto.Dto#toEntity()
   */
  @Override
  public Item toEntity() {
    validate(this);

    Item item = new Item();
    item.setName(name);
    item.setActive(active);
    item.setLastUpdated(new Date());
    item.setDeviceId(deviceId);

    if (this.getId() == null) {
      item.setCreated(new Date());
    } else {
      item.setId(id);
      item.setCreated(getCreated());
    }

    return item;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.core.endpoint.dto.Dto#fromEntity(java.lang.Object)
   */
  @Override
  public ItemDto fromEntity(Item item) {

    if (item != null) {
      this.id = item.getId();
      this.name = item.getName();
      this.active = item.isActive();
      this.created = item.getCreated();
      this.lastUpdated = item.getLastUpdated();
      this.deviceId = item.getDeviceId();
    }

    return this;
  }

}
