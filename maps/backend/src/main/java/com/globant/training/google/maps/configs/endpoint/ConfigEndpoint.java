package com.globant.training.google.maps.configs.endpoint;

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
import com.globant.training.google.maps.export.fusiontables.FusionTablesService;
import com.globant.training.google.maps.trackpoint.heatmap.HeatmapService;
import com.globant.training.google.maps.trackpoint.service.TrackPointService;
import com.globant.training.google.maps.user.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * API endpoints for {@link device} operations.
 * 
 * @author gaston.aguilera
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class ConfigEndpoint extends BaseEndpoint {
  
  private HeatmapService heatmapService;

  /**
   * Constructor
   * 
   * @param userService userService.
   */
  @Inject
  public ConfigEndpoint(HeatmapService heatmapService,UserService userService) {
    super(userService);
    this.heatmapService = heatmapService;
  }

  /**
   * Get an device by id.
   * 
   * @param user provided user.
   * @param configKey the configs key to be retrieved
   * @return {@link device}
   * 
   * @throws NotFoundException if none device found for provided id
   * @throws OAuthRequestException on authentication/authorization error.
   */
  @ApiMethod(name = "configs.get", path = "configs", httpMethod = HttpMethod.GET)
  public Map<String, String> getDevice(User user)
      throws NotFoundException, OAuthRequestException {

    validateAdmin(user);
    
    Map<String, String> configs = new HashMap<String, String>();
    
    String globalEntryPointFusionTableId = heatmapService.getGlobalTableId();

    configs.put("entryPointFusionTableId", globalEntryPointFusionTableId);
    
    return configs;
  }
}
