package com.globant.training.google.maps.trackpoint.dao.objectify;

import com.googlecode.objectify.cmd.Query;

import com.globant.training.google.maps.core.dao.objectify.BaseOfyDao;
import com.globant.training.google.maps.trackpoint.dao.TrackPointDao;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import org.joda.time.DateTime;

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

  @Override
  public List<TrackPoint> findTrackPointsByItemIdAndDateRange(Long itemId, DateTime fromDate,
      DateTime toDate) {

    Query<TrackPoint> query = this.query().filter(TrackPoint.ITEM_ID_FIELD, itemId);
    query = query.filter("measuredDate >=", fromDate);
    query = query.filter("measuredDate <=", toDate);

    return query.list();
  }

}
