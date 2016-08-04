package com.globant.training.google.maps.item.dao.objectify;

import com.globant.training.google.maps.core.dao.objectify.BaseOfyDao;
import com.globant.training.google.maps.item.dao.ItemDao;
import com.globant.training.google.maps.item.entity.Item;

/**
 * Item Objectify DAO.
 * 
 * @author gabriel.sideri
 *
 */
public class ItemOfyDao extends BaseOfyDao<Item> implements ItemDao {

  protected ItemOfyDao() {
    super(Item.class);
  }

}
