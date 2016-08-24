package com.globant.training.google.maps.alert.dao.objectify;

import com.globant.training.google.maps.alert.dao.AlertDao;
import com.globant.training.google.maps.alert.entity.Alert;
import com.globant.training.google.maps.core.dao.objectify.BaseOfyDao;

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

}
