package com.globant.training.google.maps.daos.objectify;

import com.globant.training.google.maps.daos.AntennaDao;
import com.globant.training.google.maps.entities.Antenna;

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
