package com.globant.training.google.maps.daos;

import com.globant.training.google.maps.entities.Antenna;

import java.util.List;

/**
 * Antenna DAO Interface.
 * 
 * @author gabriel.sideri
 */
public interface AntennaDao {

  /**
   * Get a list of Antenna.
   * 
   * @return a list with all Antenna
   */
  List<Antenna> getAll();
  
  /** 
   * Save or Update Antenna.
   * 
   * @param antenna the antenna
   * @return the antenna persisted
   */
  Antenna put(Antenna antenna);
  
  /**
   * Get antenna by id.
   * 
   * @param id the antenna id
   * @return the {@link Antenna}
   */
  Antenna get(Long id);
  
  /**
   * Delete antenna by id.
   * 
   * @param id the antenna id
   */
  void delete(Long id);
  
}
