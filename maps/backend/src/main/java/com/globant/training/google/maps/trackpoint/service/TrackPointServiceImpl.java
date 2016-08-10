package com.globant.training.google.maps.trackpoint.service;

import com.google.inject.Inject;

import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.service.DeviceService;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.item.service.ItemService;
import com.globant.training.google.maps.trackpoint.dao.TrackPointDao;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * {@link TrackPointService} Implementation
 * 
 * @author gabriel.sideri
 */
public class TrackPointServiceImpl implements TrackPointService {

  private TrackPointDao trackPointDao;

  private DeviceService deviceService;

  private ItemService itemService;

  /**
   * Injects the needed services.
   * 
   * @param trackPointDao the track point DAO.
   * @param deviceService the device service
   */
  @Inject
  public TrackPointServiceImpl(TrackPointDao trackPointDao, DeviceService deviceService,
      ItemService itemService) {
    super();
    this.trackPointDao = trackPointDao;
    this.deviceService = deviceService;
    this.itemService = itemService;
  }

  @Override
  public TrackPoint save(TrackPoint trackPoint) {
    Validate.notNull(trackPoint, "trackPoint can not be null");
    Validate.notNull(trackPoint.getDeviceId(), "Device Id can not be null");

    Item item = itemService.findItemByDeviceId(trackPoint.getDeviceId());

    if (!item.isActive()) {
      throw new RuntimeException(
          "The Item assigned to the device is not active, "
          + "you only can add a track point for an active item.");
    }

    trackPoint.setItemId(item.getId());

    Device device = deviceService.findById(trackPoint.getDeviceId());

    if (!device.isActive()) {
      throw new RuntimeException(
          "Device is not active, you only can add a track point for an active device.");
    }

    return trackPointDao.put(trackPoint);
  }

  @Override
  public TrackPoint findById(Long trackPointId) {
    Validate.notNull(trackPointId, "Track Point Id can not be null");
    return trackPointDao.get(trackPointId);
  }

  @Override
  public void deleteById(Long trackPointId) {
    Validate.notNull(trackPointId, "Track Point Id can not be null");
    trackPointDao.delete(trackPointId);

  }

  @Override
  public List<TrackPoint> findTrackPointsByDeviceId(Long deviceId) {
    Validate.notNull(deviceId, "Device Id can not be null");
    return trackPointDao.getTrackPointsByDeviceId(deviceId);
  }


}
