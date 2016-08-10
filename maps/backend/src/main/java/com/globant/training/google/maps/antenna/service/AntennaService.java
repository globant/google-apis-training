package com.globant.training.google.maps.antenna.service;

import com.globant.training.google.maps.antenna.entity.Antenna;

import java.util.List;

/**
 * Interface to expose {@link AntennaService} operations
 * 
 * @author gabriel.sideri
 */
public interface AntennaService {
  /**
   * Get a list of Antenna.
   * 
   * @return a list with all Antenna
   */
  List<Antenna> getAll();
  
  /** 
   * create an Antenna.
   * 
   * @param antenna the antenna
   * @return the antenna persisted
   */
  Antenna create(Antenna antenna);
  
  /** 
   * Updates Antenna.
   * 
   * @param id the antenna id
   * @param antenna the antenna
   * @return the antenna persisted
   */
  Antenna update(Long id, Antenna antenna);
  
  /**
   * Find Antenna by id.
   * 
   * @param id the antenna id
   * @return the {@link Antenna}
   */
  Antenna findById(Long id);
  
  /**
   * Delete antenna by id.
   * 
   * @param id the antenna id
   */
  void deleteById(Long id);
}
