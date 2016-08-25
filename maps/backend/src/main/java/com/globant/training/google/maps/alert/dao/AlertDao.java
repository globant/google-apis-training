package com.globant.training.google.maps.alert.dao;

import com.globant.training.google.maps.alert.entity.Alert;

import java.util.List;

/**
 * Alert DAO Interface.
 * 
 * @author gaston.aguilera
 */
public interface AlertDao {

  /**
   * Get a list of Alert.
   * 
   * @return a list with all Alert
   */
  List<Alert> getAll();
  
  /**
   * Get a list of Alert.
   * 
   * @return a list with all Alert
   */
  List<Alert> findActive();
  
  /** 
   * Save or Update Alert.
   * 
   * @param alert the alert
   * @return the alert persisted
   */
  Alert put(Alert alert);
  
  /**
   * Get alert by id.
   * 
   * @param id the alert id
   * @return the {@link Alert}
   */
  Alert get(Long id);
  
  /**
   * Delete alert by id.
   * 
   * @param id the alert id
   */
  void delete(Long id);
  
}
