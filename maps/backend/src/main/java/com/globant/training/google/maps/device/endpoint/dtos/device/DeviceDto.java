package com.globant.training.google.maps.device.endpoint.dtos.device;

import com.globant.training.google.maps.core.endpoint.dto.Dto;
import com.globant.training.google.maps.device.entity.DeviceType;

import java.util.Map;

import javax.validation.constraints.NotNull;

/**
 * Device DTO.
 * 
 * @author gaston.aguilera
 */
public class DeviceDto implements Dto {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private DeviceType type;
  
  private boolean active;

  @NotNull
  private Map<String, String> attributtes;

  public Long getId() {
    return id;
  }

  public DeviceType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public Map<String, String> getAttributtes() {
    return attributtes;
  }

  public DeviceDto setAttributtes(Map<String, String> attributtes) {
    this.attributtes = attributtes;
    return this;
  }

  public DeviceDto setId(Long id) {
    this.id = id;
    return this;
  }

  public DeviceDto setName(String name) {
    this.name = name;
    return this;
  }

  public DeviceDto setType(DeviceType type) {
    this.type = type;
    return this;
  }

  public boolean isActive() {
    return active;
  }

  public DeviceDto setActive(boolean active) {
    this.active = active;
    return this;
  }
}
