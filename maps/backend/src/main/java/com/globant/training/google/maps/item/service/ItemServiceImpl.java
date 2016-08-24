package com.globant.training.google.maps.item.service;

import com.google.inject.Inject;

import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.service.DeviceService;
import com.globant.training.google.maps.item.dao.ItemDao;
import com.globant.training.google.maps.item.entity.Item;

import java.util.Date;
import java.util.List;

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
  public ItemServiceImpl(ItemDao itemDao, DeviceService deviceService) {
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
  public Item create(Item item) {

    validateDevice(item.getDeviceId());
    
    Date now = new Date();
    
    item.setCreated(now);
    item.setLastUpdated(now);

    return itemDao.put(item);
  }
  
  @Override
  public Item update(Long id, Item item) {
    
    Item existingItem = findById(id);
    
    validateDevice(item.getDeviceId());
    
    item.setId(existingItem.getId());
    item.setCreated(existingItem.getCreated());
    item.setLastUpdated(new Date());

    return itemDao.put(item);
  }
  
  /**
   * Validate if provided device id exists.
   * If null provided not exception is thrown.
   * 
   * @param deviceId deviceId to validate.
   * @throws RuntimeException is no device found.
   */
  private void validateDevice(Long deviceId) {
    if (deviceId != null) {

      Device device = deviceService.findById(deviceId);

      if (!device.isActive()) {
        throw new RuntimeException(
            "Device is not active, you only can associate an active device.");
      }

    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.globant.training.google.maps.item.service.ItemService#findById(java.lang.Long)
   */
  @Override
  public Item findById(Long id) {
    
    Item item = itemDao.get(id);
    
    if (item == null) {
      throw new RuntimeException("item Not Found");
    }
    
    if (item.getDeviceId() != null) {
      Device device = deviceService.findById(item.getDeviceId());
      item.setDeviceName(device.getName());
      item.setDeviceType(device.getType());
    }
    
    return item;
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

  @Override
  public Item findItemByDeviceId(Long deviceId) {
    Item item = itemDao.findItemByDeviceId(deviceId);

    if (item == null) {
      throw new RuntimeException("Item Not Found for the device id: " + deviceId);
    }

    return item;
  }

}
