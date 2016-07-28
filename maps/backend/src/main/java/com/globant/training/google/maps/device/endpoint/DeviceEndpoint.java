package com.globant.training.google.maps.device.endpoint;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.device.endpoint.dtos.device.DeviceDto;
import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.service.DeviceService;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

/**
 * API endpoints for {@link device} operations.
 * 
 * @author gaston.aguilera
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
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
   * Add device.
   * 
   * @param deviceDto the device request
   * @return deviceDto the device persisted with id
   */
  @ApiMethod(name = "devices.add", path = "devices", httpMethod = HttpMethod.POST)
  public DeviceDto add(DeviceDto deviceDto) {

    Device savedDevice = deviceService.create(deviceDto.toEntity());

    DeviceDto createdDto = new DeviceDto();

    return createdDto.fromEntity(savedDevice);
  }

  /**
   * Modify Device by id.
   * 
   * @param deviceId the id of device to be modified.
   * @param deviceDto the dto request to update.
   * 
   * @return deviceDto the device persisted with id
   */
  @ApiMethod(name = "devices.put", path = "devices/{deviceId}", httpMethod = HttpMethod.PUT)
  public DeviceDto update(@Named("deviceId") final Long deviceId, DeviceDto deviceDto) {

    Device savedDevice = deviceService.update(deviceId, deviceDto.toEntity());

    DeviceDto updatedDto = new DeviceDto();

    return updatedDto.fromEntity(savedDevice);
  }
  
  /**
   * Get an device by id.
   * 
   * @param deviceId the id to be found
   * @return {@link device}
   * @throws NotFoundException if none device found for provided id
   */
  @ApiMethod(name = "devices.get", path = "devices/{deviceId}", httpMethod = HttpMethod.GET)
  public DeviceDto getDevice(@Named("deviceId") final Long deviceId) throws NotFoundException {

    Device device = deviceService.findById(deviceId);

    DeviceDto dto = new DeviceDto();

    return dto.fromEntity(device);
  }
  
  /**
   * Find devices.
   * 
   * @return List of {@link DeviceDto}
   */
  @ApiMethod(name = "devices.find", path = "devices", httpMethod = HttpMethod.GET)
  public List<DeviceDto> findAntennas() throws OAuthRequestException {

    //TODO move to builder or helper.
    List<Device> devices = deviceService.getAll();
    List<DeviceDto> deviceDtos = new ArrayList<>();

    for (Device device : devices) {

      DeviceDto deviceDto = new DeviceDto();
      deviceDto.fromEntity(device);
      deviceDtos.add(deviceDto);

    }
    return deviceDtos;

  }
  
  /**
   * Delete Device by id.
   */
  @ApiMethod(name = "devices.delete", path = "devices/{deviceId}",
      httpMethod = HttpMethod.DELETE)
  public void deleteAntenna(@Named("deviceId") final Long deviceId) {

    deviceService.deleteById(deviceId);

  }

}
