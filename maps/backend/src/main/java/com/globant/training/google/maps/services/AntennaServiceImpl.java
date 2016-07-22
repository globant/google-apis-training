package com.globant.training.google.maps.services;

import com.google.inject.Inject;

import com.globant.training.google.maps.daos.AntennaDao;
import com.globant.training.google.maps.entities.Antenna;

import java.util.Date;
import java.util.List;

/**
 * {@link AntennaService} Implementation
 * 
 * @author gabriel.sideri
 */
public class AntennaServiceImpl implements AntennaService {

  private final AntennaDao antennaDao;

  @Inject
  public AntennaServiceImpl(AntennaDao antennaDao) {
    super();
    this.antennaDao = antennaDao;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.services.AntennaService#getAll()
   */
  @Override
  public List<Antenna> getAll() {
    return antennaDao.getAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.globant.training.google.maps.services.AntennaService#save(com.globant.training.google.maps.
   * entities.Antenna)
   */
  @Override
  public Antenna save(Antenna antenna) {

    if (antenna.getId() == null) {
      antenna.setCreated(new Date());
    }

    antenna.setLastUpdated(new Date());

    return antennaDao.put(antenna);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.services.AntennaService#findById(java.lang.Long)
   */
  @Override
  public Antenna findById(Long id) {
    return antennaDao.get(id);
  }

}
