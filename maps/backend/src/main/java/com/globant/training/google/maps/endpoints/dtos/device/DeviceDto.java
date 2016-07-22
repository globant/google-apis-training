package com.globant.training.google.maps.endpoints.dtos.device;

import static com.globant.training.google.maps.endpoints.validation.DtoValidator.validate;

import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import com.globant.training.google.maps.endpoints.dtos.Dto;
import com.globant.training.google.maps.endpoints.dtos.device.factory.DeviceFactory;
import com.globant.training.google.maps.endpoints.dtos.device.factory.GpsFactory;
import com.globant.training.google.maps.endpoints.dtos.device.factory.RfidFactory;
import com.globant.training.google.maps.entities.DeviceType;
import com.globant.training.google.maps.entities.device.Device;


/**
 * Device DTO.
 * 
 * @author gaston.aguilera
 */
public class DeviceDto implements Dto<Device> {
  
  private static final Map<DeviceType, DeviceFactory> deviceFactoryMap;
  static {
    deviceFactoryMap = new HashMap<DeviceType, DeviceFactory>();
    deviceFactoryMap.put(DeviceType.GPS, new GpsFactory());
    deviceFactoryMap.put(DeviceType.RFID, new RfidFactory());
  }
 
  private Long id;
  
  @NotNull
  private String name;

  @NotNull
  private DeviceType type;
  
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

  @Override
  public Device toEntity() {
    
    validate(this);
    
    return deviceFactoryMap.get(type).makeDevice(name, attributtes);
  }
  
  @Override
  public void fromEntity(Device device) {
    this.id = device.getId();
    this.name = device.getName();
    this.type = device.getType();
  }
}
