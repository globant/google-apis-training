package com.globant.training.google.maps.antenna.service;

import java.util.List;

import com.globant.training.google.maps.antenna.entity.Antenna;

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
   * Save or update Antenna.
   * 
   * @param antenna the antenna
   * @return the antenna persisted
   */
  Antenna save(Antenna antenna);
  
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
