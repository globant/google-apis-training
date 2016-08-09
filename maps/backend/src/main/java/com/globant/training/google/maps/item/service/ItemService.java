package com.globant.training.google.maps.item.service;

import com.globant.training.google.maps.item.entity.Item;

import java.util.List;

/**
 * Interface to expose {@link ItemService} operations
 * 
 * @author gabriel.sideri
 */
public interface ItemService {
  /**
   * Get a list of item.
   * 
   * @return a list with all item
   */
  List<Item> getAll();

  /**
   * Save or update Item.
   * 
   * @param item the item
   * @return the item persisted
   */
  Item save(Item item);

  /**
   * Find Item by id.
   * 
   * @param id the item id
   * @return the {@link Item}
   */
  Item findById(Long id);

  /**
   * Delete Item by id.
   * 
   * @param id the Item id
   */
  void deleteById(Long id);
  
  /**
   * Find item by device id.
   * 
   * @param id the device id associated.
   * @return the item
   */
  Item findItemByDeviceId(Long id);
}
