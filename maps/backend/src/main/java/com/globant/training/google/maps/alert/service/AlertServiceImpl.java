package com.globant.training.google.maps.alert.service;

import com.google.inject.Inject;

import com.globant.training.google.maps.alert.dao.AlertDao;
import com.globant.training.google.maps.alert.entity.Alert;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.item.service.ItemService;

import org.apache.commons.lang3.Validate;

import java.util.Date;
import java.util.List;

/**
 * {@link AlertService} Implementation
 * 
 * @author gaston.aguilera
 */
public class AlertServiceImpl implements AlertService {

  private final AlertDao alertDao;
  
  private ItemService itemService;

  /**
   * Constructor.
   * 
   * @param alertDao dao.
   * @param itemService item service for item id validation.
   */
  @Inject
  public AlertServiceImpl(AlertDao alertDao, ItemService itemService) {
    super();
    this.alertDao = alertDao;
    this.itemService = itemService;
  }

  @Override
  public List<Alert> getAll() {
    return alertDao.getAll();
  }

  @Override
  public Alert create(Alert alert) {
    Validate.notNull(alert, "Alert cannot be null");

    Date now = new Date();
    alert.setCreated(now);
    alert.setLastUpdated(now);
    
    validateItem(alert);

    return alertDao.put(alert);
  }

  @Override
  public Alert update(Long id, Alert alert) {
    Validate.notNull(alert, "id cannot be null");
    Validate.notNull(alert, "Alert cannot be null");

    validateItem(alert);
    
    Alert existingAlert = findById(id);
    alert.setId(existingAlert.getId());
    alert.setCreated(existingAlert.getCreated());
    alert.setLastUpdated(new Date());
    
    

    return alertDao.put(alert);
  }

  @Override
  public Alert findById(Long id) {
    Validate.notNull(id, "id cannot be null");

    Alert alert = alertDao.get(id);

    if (alert == null) {
      throw new RuntimeException("Alert Not Found");
    }

    return alert;
  }

  @Override
  public void deleteById(Long id) {
    Validate.notNull(id, "id cannot be null");

    findById(id);

    alertDao.delete(id);
  }
  
  /**
   * Validate that provided item is active and valid.
   * @param alert the alert to be validated.
   */
  private void validateItem(Alert alert) {
    Item item = itemService.findById(alert.getItemId());

    if (!item.isActive()) {
      throw new RuntimeException("The provided item is not active");
    }
  }

  @Override
  public List<Alert> findActive() {
    return alertDao.findActive();
  }
}
