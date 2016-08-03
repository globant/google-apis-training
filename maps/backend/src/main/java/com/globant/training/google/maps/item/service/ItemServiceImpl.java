package com.globant.training.google.maps.item.service;

import com.google.inject.Inject;

import com.globant.training.google.maps.item.dao.ItemDao;
import com.globant.training.google.maps.item.entity.Item;

import java.util.List;

/**
 * {@link ItemService} Implementation
 * 
 * @author gabriel.sideri
 */
public class ItemServiceImpl implements ItemService {

  private final ItemDao itemDao;

  @Inject
  public ItemServiceImpl(ItemDao itemDao) {
    super();
    this.itemDao = itemDao;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.item.service.ItemService#getAll()
   */
  @Override
  public List<Item> getAll() {
    return itemDao.getAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.globant.training.google.maps.item.service.ItemService#save(com.globant.training.google.maps
   * .item.entity.Item)
   */
  @Override
  public Item save(Item item) {
    return itemDao.put(item);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.item.service.ItemService#findById(java.lang.Long)
   */
  @Override
  public Item findById(Long id) {
    return itemDao.get(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.item.service.ItemService#deleteById(java.lang.Long)
   */
  @Override
  public void deleteById(Long id) {
    itemDao.delete(id);
  }

}
