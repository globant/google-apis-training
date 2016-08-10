package com.globant.training.google.maps.item.endpoint.transformer;

import com.google.api.server.spi.config.Transformer;

import com.globant.training.google.maps.core.endpoint.validation.DtoValidator;
import com.globant.training.google.maps.item.endpoint.dtos.ItemDto;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.trackpoint.endpoint.dtos.TrackPointDto;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import org.apache.commons.lang3.Validate;

import java.util.Date;


/**
 * Transformer implementation for {@link ItemDto} api.
 * 
 * @author gaston.aguilera
 *
 */
public class ItemApiTransformer implements Transformer<Item, ItemDto> {

  @Override
  public Item transformFrom(ItemDto dto) {
    DtoValidator.validate(dto);

    // @formatter:off
    Item item = new Item()
        .setName(dto.getName())
        .setActive(dto.isActive())
        .setDeviceId(dto.getDeviceId());
    // @formatter:on
    if (dto.getId() != null) {
      item.setId(dto.getId());
    } 
    
    return item;
  }

  @Override
  public ItemDto transformTo(Item item) {
    Validate.notNull(item, "Item can not be null");
    
    ItemDto dto = new ItemDto();
    
    // @formatter:off
    dto.setId(item.getId())
       .setName(item.getName())
       .setActive(item.isActive())
       .setCreated(item.getCreated())
       .setLastUpdated(item.getLastUpdated())
       .setDeviceId(item.getDeviceId());
   
    // @formatter:on
    return dto;
  }

}
