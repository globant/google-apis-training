package com.globant.training.google.maps.device.endpoint.transformer;

import com.google.api.server.spi.config.Transformer;

import com.globant.training.google.maps.antenna.endpoint.dtos.AntennaDto;
import com.globant.training.google.maps.core.endpoint.validation.DtoValidator;
import com.globant.training.google.maps.device.endpoint.dtos.device.DeviceDto;
import com.globant.training.google.maps.device.endpoint.dtos.device.factory.DeviceFactory;
import com.globant.training.google.maps.device.endpoint.dtos.device.factory.GpsFactory;
import com.globant.training.google.maps.device.endpoint.dtos.device.factory.RfidFactory;
import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.entity.DeviceType;

import org.apache.commons.lang3.Validate;

import java.util.HashMap;
import java.util.Map;

/**
 * Transformer implementation for {@link AntennaDto} api.
 * 
 * @author gaston.aguilera
 *
 */
public class DeviceApiTransformer implements Transformer<Device, DeviceDto> {
  
  private static final Map<DeviceType, DeviceFactory> deviceFactoryMap;
  
  static {
    deviceFactoryMap = new HashMap<DeviceType, DeviceFactory>();
    deviceFactoryMap.put(DeviceType.GPS, new GpsFactory());
    deviceFactoryMap.put(DeviceType.RFID, new RfidFactory());
  }

  @Override
  public Device transformFrom(DeviceDto dto) {
    DtoValidator.validate(dto);

    Device device = deviceFactoryMap.get(dto.getType()).makeDevice(dto.getName(), dto.isActive(),
        dto.getAttributtes());
    
    return device;
  }
  
  @Override
  public DeviceDto transformTo(Device device) {
    Validate.notNull(device, "Device can not be null");
    
    DeviceDto dto = new DeviceDto();
    // @formatter:off
    dto.setId(device.getId())
       .setType(device.getType())
       .setName(device.getName())
       .setActive(device.isActive())
       .setAttributtes(device.getAttributes());
    // @formatter:on
    return dto;
  }
}
