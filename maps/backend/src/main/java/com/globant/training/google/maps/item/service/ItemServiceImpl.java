package com.globant.training.google.maps.item.service;

import com.google.inject.Inject;

import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.service.DeviceService;
import com.globant.training.google.maps.item.dao.ItemDao;
import com.globant.training.google.maps.item.entity.Item;

import java.util.List;

import javax.inject.Named;

/**
 * {@link ItemService} Implementation
 * 
 * @author gabriel.sideri
 */
public class ItemServiceImpl implements ItemService {

  private final ItemDao itemDao;

  private final DeviceService deviceService;

  /**
   * Injects the needed services.
   * 
   * @param itemDao the item DAO.
   * @param deviceService the Device Service
   */
  @Inject
  public ItemServiceImpl(ItemDao itemDao, @Named("deviceService") DeviceService deviceService) {
    super();
    this.itemDao = itemDao;
    this.deviceService = deviceService;
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

    if (item.getDeviceId() != null) {

      Device device = deviceService.findById(item.getDeviceId());

      if (!device.isActive()) {
        throw new RuntimeException(
            "Device is not active, you only can associate an active device.");
      }

    }

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
