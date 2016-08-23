package com.globant.training.google.maps.trackpoint.service;

import com.google.inject.Inject;

import com.globant.training.google.maps.device.service.DeviceService;
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

}
