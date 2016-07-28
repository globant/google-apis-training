package com.globant.training.google.maps.antenna.dao.objectify;

import com.globant.training.google.maps.antenna.dao.AntennaDao;
import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.core.dao.objectify.BaseOfyDao;

/**
 * Antenna Objectify DAO.
 * 
 * @author gabriel.sideri
 *
 */
public class AntennaOfyDao extends BaseOfyDao<Antenna> implements AntennaDao {

  protected AntennaOfyDao() {
    super(Antenna.class);
  }

}
