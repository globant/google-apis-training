package com.globant.training.google.maps.trackpoint.service;

import com.google.inject.Inject;
import com.google.maps.android.SphericalUtil;

import com.globant.training.google.maps.alert.entity.LatLng;
import com.globant.training.google.maps.device.service.DeviceService;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.item.service.ItemService;
import com.globant.training.google.maps.trackpoint.dao.TrackPointDao;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.trackpoint.service.publisher.TrackPointPublisher;
import com.globant.training.google.maps.trackpoint.service.visitor.TrackPointVisitor;

import org.apache.commons.lang3.Validate;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.List;

/**
 * {@link TrackPointService} Implementation
 * 
 * @author gabriel.sideri
 */
public class TrackPointServiceImpl implements TrackPointService {

  private TrackPointDao trackPointDao;
 
  private TrackPointVisitor trackPointVisitor;
  
  private TrackPointPublisher publisher;

  private ItemService itemService;
  
  /**
   * Injects the needed services.
   * 
   * @param trackPointDao the track point DAO.
   * @param deviceService the device service
   */
  @Inject
  public TrackPointServiceImpl(TrackPointDao trackPointDao, DeviceService deviceService,
      ItemService itemService, TrackPointVisitor trackPointVisitor, TrackPointPublisher publisher) {
    super();
    this.trackPointDao = trackPointDao;
    this.trackPointVisitor = trackPointVisitor;
    this.publisher = publisher;
    this.itemService = itemService;
  }

  @Override
  public TrackPoint save(TrackPoint trackPoint) {
    Validate.notNull(trackPoint, "trackPoint can not be null");
 
    trackPoint.visit(trackPointVisitor);
    
    trackPoint.setSavedDate(new DateTime(DateTimeZone.UTC));
    
    TrackPoint savedTrackpoint = trackPointDao.put(trackPoint);
    
    publisher.publish(savedTrackpoint);
    
    return savedTrackpoint;
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

  @Override
  public List<TrackPoint> find(DateTime fromDate,
      DateTime toDate, Long itemId) {
    Validate.notNull(fromDate, "From date can not be null");
    Validate.notNull(toDate, "To Date can not be null");
    
    return trackPointDao.find(fromDate, toDate,itemId);
  }

  @Override
  public double calculatesDistanceByItemId(DateTime fromDate, DateTime toDate, Long itemId) {
    Validate.notNull(itemId, "Item Id can not be null");
    Validate.notNull(fromDate, "From date can not be null");
    Validate.notNull(toDate, "To Date can not be null");
    
    Item item = itemService.findById(itemId);
    
    double distance = 0;
    
    List<TrackPoint> trackPoints = trackPointDao.find(fromDate, toDate, item.getId());

    for (int k = 0; k < trackPoints.size() - 1; k++) {

      LatLng fromPoint =
          new LatLng(trackPoints.get(k).getLatitude(), trackPoints.get(k).getLongitude());

      LatLng toPoint =
          new LatLng(trackPoints.get(k + 1).getLatitude(), trackPoints.get(k + 1).getLongitude());

      distance = distance + SphericalUtil.computeDistanceBetween(fromPoint, toPoint);
    }
    
     
    return distance;
  }

}
