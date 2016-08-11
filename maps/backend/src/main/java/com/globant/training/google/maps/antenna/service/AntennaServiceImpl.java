package com.globant.training.google.maps.antenna.service;

import com.google.inject.Inject;

import com.globant.training.google.maps.antenna.dao.AntennaDao;
import com.globant.training.google.maps.antenna.entity.Antenna;

import org.apache.commons.lang3.Validate;

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
  
  @Override
  public List<Antenna> getAll() {
    return antennaDao.getAll();
  }

  @Override
  public Antenna create(Antenna antenna) {
    Validate.notNull(antenna, "Antenna cannot be null");

    Date now = new Date();
    antenna.setCreated(now);
    antenna.setLastUpdated(now);

    return antennaDao.put(antenna);
  }

  @Override
  public Antenna update(Long id, Antenna antenna) {
    Validate.notNull(antenna, "id cannot be null");
    Validate.notNull(antenna, "Antenna cannot be null");

    Antenna existingAntenna = findById(id);
    antenna.setId(existingAntenna.getId());
    antenna.setCreated(existingAntenna.getCreated());
    antenna.setLastUpdated(new Date());

    return antennaDao.put(antenna);
  }

  @Override
  public Antenna findById(Long id) {
    Validate.notNull(id, "id cannot be null");

    Antenna antenna = antennaDao.get(id);
    
    if (antenna == null) {
      throw new RuntimeException("Antenna Not Found");
    }
    
    return antenna;
  }

  @Override
  public void deleteById(Long id) {
    Validate.notNull(id, "id cannot be null");

    findById(id);

    antennaDao.delete(id);
  }

}
