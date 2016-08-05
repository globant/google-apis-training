package com.globant.training.google.maps.trackpoint.dao.objectify;

import com.globant.training.google.maps.core.dao.objectify.BaseOfyDao;
import com.globant.training.google.maps.trackpoint.dao.TrackPointDao;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import java.util.List;

/**
 * TrackPoint Objectify DAO.
 * 
 * @author gabriel.sideri
 */
public class TrackPointOfyDao extends BaseOfyDao<TrackPoint> implements TrackPointDao {

  protected TrackPointOfyDao() {
    super(TrackPoint.class);
  }

  @Override
  public List<TrackPoint> getTrackPointsByDeviceId(Long deviceId) {
    return this.query().filter(TrackPoint.DEVICE_ID_FIELD, deviceId).list();
  }

}
