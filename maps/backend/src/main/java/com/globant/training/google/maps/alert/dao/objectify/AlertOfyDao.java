package com.globant.training.google.maps.alert.dao.objectify;

import com.globant.training.google.maps.alert.dao.AlertDao;
import com.globant.training.google.maps.alert.entity.Alert;
import com.globant.training.google.maps.core.dao.objectify.BaseOfyDao;

import java.util.List;

/**
 * Alert Objectify DAO.
 * 
 * @author gaston.aguilera
 *
 */
public class AlertOfyDao extends BaseOfyDao<Alert> implements AlertDao {

  protected AlertOfyDao() {
    super(Alert.class);
  }

  @Override
  public List<Alert> findActive() {

    return ofy().load().type(entity).filter("active", true).list();
  }

}
