package com.globant.training.google.maps.endpoints;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.endpoints.dtos.device.DeviceDto;
import com.globant.training.google.maps.entities.device.Device;
import com.globant.training.google.maps.services.DeviceService;

import javax.inject.Named;

/**
 * API endpoints for {@link device} operations.
 * 
 * @author gaston.aguilera
 */

@Api(name = "device", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class DeviceEndpoint {

  private DeviceService deviceService;

  /**
   * Constructor.
   * 
   * @param deviceService the device service.
   */
  @Inject
  public DeviceEndpoint(@Named("deviceService") DeviceService deviceService) {
    this.deviceService = deviceService;
  }

  /**
   * Get an device by id.
   *  
   * @param deviceId the id to be found
   * @return {@link device}
   * @throws NotFoundException if none device found for provided id
   */
  @ApiMethod(name = "device.get", path = "devices/{deviceId}", httpMethod = HttpMethod.GET)
  public Device getdevice(@Named("deviceId") final Long deviceId) throws NotFoundException {
    return deviceService.findById(deviceId);
  }

  /**
   * Add device.
   * 
   * @param deviceDto the device request
   * @return deviceDto the device persisted with id
   */
  @ApiMethod(name = "device.add", path = "devices", httpMethod = HttpMethod.POST)
  public DeviceDto addDevice(DeviceDto deviceDto) {

    Device savedDEvice = deviceService.save(deviceDto.toEntity());
    
    DeviceDto createdDto = new DeviceDto();
    
    return createdDto.fromEntity(savedDEvice);
  }

}
