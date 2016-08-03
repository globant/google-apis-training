package com.globant.training.google.maps.item.dao;


import com.globant.training.google.maps.item.entity.Item;

import java.util.List;

/**
 * Item DAO Interface.
 * 
 * @author gabriel.sideri
 */
public interface ItemDao {

  /**
   * Get a list of Item.
   * 
   * @return a list with all Items
   */
  List<Item> getAll();
  
  /** 
   * Save or Update Item.
   * 
   * @param item the item
   * @return the item persisted
   */
  Item put(Item item);
  
  /**
   * Get item by id.
   * 
   * @param id the item id
   * @return the {@link Item}
   */
  Item get(Long id);
  
  /**
   * Delete item by id.
   * 
   * @param id the item id
   */
  void delete(Long id);
  
}
