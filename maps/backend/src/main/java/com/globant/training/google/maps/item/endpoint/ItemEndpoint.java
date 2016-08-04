package com.globant.training.google.maps.item.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.core.endpoint.BaseEndpoint;
import com.globant.training.google.maps.item.dtos.ItemDto;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.item.service.ItemService;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

/**
 * API endpoints for {@link Item} operations.
 * 
 * @author gabriel.sideri
 */

@Api(name = "maps", version = "v1", scopes = {Constants.EMAIL_SCOPE},
    clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID},
    description = "API for maps poc.")
public class ItemEndpoint extends BaseEndpoint {

  private ItemService itemService;

  /**
   * Constructor.
   * 
   * @param itemService the item service.
   */
  @Inject
  public ItemEndpoint(ItemService itemService,
      @Named("userService") UserService userService) {
    super(userService);
    this.itemService = itemService;
  }

  /**
   * Get an Item by id.
   * 
   * @param itemId the id to be found
   * @return {@link Item}
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   * @throws NotFoundException if none item found for provided id
   */
  @ApiMethod(name = "items.get", path = "items/{itemId}", httpMethod = HttpMethod.GET)
  public ItemDto getItem(@Named("itemId") final Long itemId, User user)
      throws OAuthRequestException {

    AppUser loggedUser = loginUser(user);

    if (!loggedUser.isAdmin()) {
      throw new RuntimeException("User not authorized");
    }

    Item item = itemService.findById(itemId);

    if (item == null) {
      throw new RuntimeException("Item Not Found");
    }

    ItemDto response = new ItemDto();
    response.fromEntity(item);

    return response;
  }

  /**
   * Add Item.
   * 
   * @param itemDto the item request
   * @return itemDto the item persisted with id
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "items.add", path = "items", httpMethod = HttpMethod.POST)
  public ItemDto addItem(ItemDto itemDto, User user) throws OAuthRequestException {

    AppUser loggedUser = loginUser(user);

    if (!loggedUser.isAdmin()) {
      throw new RuntimeException("User not authorized");
    }

    Item item = itemService.save(itemDto.toEntity());
    itemDto.fromEntity(item);

    return itemDto;
  }

  /**
   * Modify Item.
   * 
   * @param itemDto the item request
   * @return itemDto the item dto
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "items.put", path = "items/{itemId}", httpMethod = HttpMethod.PUT)
  public ItemDto modifyItem(@Named("itemId") final Long itemId, ItemDto itemDto,
      User user) throws OAuthRequestException {

    AppUser loggedUser = loginUser(user);

    if (!loggedUser.isAdmin()) {
      throw new RuntimeException("User not authorized");
    }

    Item item = itemService.findById(itemId);

    if (item == null) {
      throw new RuntimeException("item Not Found");
    }
        
    itemDto.setId(itemId);

    item = itemService.save(itemDto.toEntity());

    itemDto.setCreated(item.getCreated());
    itemDto.setLastUpdated(item.getLastUpdated());

    return itemDto;
  }

  /**
   * Find items.
   * 
   * @return List of {@link ItemDto}
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "items.find", path = "items", httpMethod = HttpMethod.GET)
  public List<ItemDto> findItems(User user) throws OAuthRequestException {

    AppUser loggedUser = loginUser(user);

    if (!loggedUser.isAdmin()) {
      throw new RuntimeException("User not authorized");
    }

    List<Item> items = itemService.getAll();
    List<ItemDto> itemsDto = new ArrayList<>();

    for (Item item : items) {

      ItemDto itemDto = new ItemDto();
      itemDto.fromEntity(item);
      itemsDto.add(itemDto);

    }

    return itemsDto;

  }

  /**
   * Delete item by id.
   * 
   * @throws OAuthRequestException
   * 
   */
  @ApiMethod(name = "items.delete", path = "items/{itemId}",
      httpMethod = HttpMethod.DELETE)
  public void deleteItem(@Named("itemId") final Long itemId, User user)
      throws OAuthRequestException {

    AppUser loggedUser = loginUser(user);

    if (!loggedUser.isAdmin()) {
      throw new RuntimeException("User not authorized");
    }

    Item item = itemService.findById(itemId);

    if (item == null) {
      throw new RuntimeException("item Not Found");
    }

    itemService.deleteById(itemId);

  }


}
