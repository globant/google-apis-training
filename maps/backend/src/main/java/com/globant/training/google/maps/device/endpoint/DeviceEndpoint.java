package com.globant.training.google.maps.device.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.core.endpoint.BaseEndpoint;
import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.service.DeviceService;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.TrackPointDto;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.trackpoint.service.TrackPointService;
import com.globant.training.google.maps.user.service.UserService;

import java.util.List;

import javax.inject.Named;

/**
 * API endpoints for {@link device} operations.
 * 
 * @author gaston.aguilera
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class DeviceEndpoint extends BaseEndpoint {

  private DeviceService deviceService;

  private TrackPointService trackPointService;

  /**
   * Constructor.
   * 
   * @param deviceService deviceService.
   * @param trackPointService trackPointService.
   * @param userService userService.
   */
  @Inject
  public DeviceEndpoint(DeviceService deviceService,
      TrackPointService trackPointService, UserService userService) {
    super(userService);
    this.deviceService = deviceService;
    this.trackPointService = trackPointService;
  }

  /**
   * Add device.
   * 
   * @param device the device request
   * @param user the user logged
   * @return Device the device persisted with id
   * @throws OAuthRequestException on authentication/authorization error.
   */
  @ApiMethod(name = "devices.add", path = "devices", httpMethod = HttpMethod.POST)
  public Device add(Device device, User user)  throws OAuthRequestException {

    validateAdmin(user);
    
    Device savedDevice = deviceService.create(device);

    return savedDevice;
  }

  /**
   * Modify Device by id.
   * 
   * @param user the user logged
   * @param deviceId the id of device to be modified.
   * @param device the dto request to update.
   * @return Device the device persisted with id
   * @throws OAuthRequestException on authentication/authorization error.
   */
  @ApiMethod(name = "devices.put", path = "devices/{deviceId}", httpMethod = HttpMethod.PUT)
  public Device update(User user, @Named("deviceId") final Long deviceId, Device device)
      throws OAuthRequestException {

    validateAdmin(user);
    
    Device savedDevice = deviceService.update(deviceId, device);

    return savedDevice;
  }

  /**
   * Get an device by id.
   * 
   * @param user the user logged
   * @param deviceId the id to be found
   * @return {@link device}
   * @throws OAuthRequestException on authentication/authorization error.
   */
  @ApiMethod(name = "devices.get", path = "devices/{deviceId}", httpMethod = HttpMethod.GET)
  public Device getDevice(User user, @Named("deviceId") final Long deviceId)
      throws NotFoundException, OAuthRequestException {

    validateAdmin(user);
    
    Device device = deviceService.findById(deviceId);

    return device;
  }

  /**
   * Return all devices.
   * 
   * @param user the user logged
   * @return List of {@link Device}
   * @throws OAuthRequestException on authentication/authorization error.
   */
  @ApiMethod(name = "devices.find", path = "devices", httpMethod = HttpMethod.GET)
  public List<Device> findAntennas(User user) throws OAuthRequestException {
    
    validateAdmin(user);
    
    List<Device> devices = deviceService.getAll();

    return devices;

  }

  /**
   * Delete Device by id.
   * 
   * @param user the user logged
   * @param deviceId id to be deleted.
   * @throws OAuthRequestException on authentication/authorization error.
   */
  @ApiMethod(name = "devices.delete", path = "devices/{deviceId}", httpMethod = HttpMethod.DELETE)
  public void deleteAntenna(User user, @Named("deviceId") final Long deviceId)
      throws OAuthRequestException {

    validateAdmin(user);

    deviceService.deleteById(deviceId);

  }

  /**
   * Get track points by device id.
   * 
   * @param user the user logged
   * @param deviceId the id to be found
   * @return List of {@link TrackPointDto}
   * @throws OAuthRequestException on authentication/authorization error.
   */
  @ApiMethod(name = "trackpoint.get.by.device.id", path = "devices/{deviceId}/trackpoints",
      httpMethod = HttpMethod.GET)
  public List<TrackPoint> getTrackPointsByDeviceIds(User user,
      @Named("deviceId") final Long deviceId) throws NotFoundException, OAuthRequestException {

    validateAdmin(user);
    
    Device device = deviceService.findById(deviceId);

    List<TrackPoint> trackPoints = trackPointService.findTrackPointsByDeviceId(device.getId());

    return trackPoints;

  }

}
