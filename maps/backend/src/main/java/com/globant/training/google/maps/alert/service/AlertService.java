package com.globant.training.google.maps.alert.service;

import com.globant.training.google.maps.alert.entity.Alert;

import java.util.List;

/**
 * Interface to expose {@link AlertService} operations
 * 
 * @author gaston.aguilera
 */
public interface AlertService {
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
   * create an Alert.
   * 
   * @param alert the alert
   * @return the alert persisted
   */
  Alert create(Alert alert);

  /**
   * Updates Alert.
   * 
   * @param id the alert id
   * @param alert the alert
   * @return the alert persisted
   */
  Alert update(Long id, Alert alert);

  /**
   * Find Alert by id.
   * 
   * @param id the alert id
   * @return the {@link Alert}
   */
  Alert findById(Long id);

  /**
   * Delete alert by id.
   * 
   * @param id the alert id
   */
  void deleteById(Long id);
}
