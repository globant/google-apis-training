package com.globant.training.google.maps.item.endpoint;

import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.response.NotFoundException;
import com.google.api.server.spi.types.DateAndTime;
import com.google.appengine.api.oauth.OAuthRequestException;
import com.google.inject.Inject;

import com.globant.training.google.maps.configs.Constants;
import com.globant.training.google.maps.core.endpoint.BaseEndpoint;
import com.globant.training.google.maps.item.endpoint.dtos.ItemDto;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.item.service.ItemService;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.trackpoint.service.TrackPointService;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.service.UserService;

import org.joda.time.DateTime;

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

  private TrackPointService trackPointService;

  /**
   * Constructor.
   * 
   * @param itemService the item service.
   */
  @Inject
  public ItemEndpoint(ItemService itemService, UserService userService,
      TrackPointService trackPointService) {
    super(userService);
    this.itemService = itemService;
    this.trackPointService = trackPointService;
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
  public Item getItem(@Named("itemId") final Long itemId, User user) throws OAuthRequestException {

    AppUser loggedUser = loginUser(user);

    if (!loggedUser.isAdmin()) {
      throw new RuntimeException("User not authorized");
    }

    Item item = itemService.findById(itemId);

    if (item == null) {
      throw new RuntimeException("Item Not Found");
    }

    return item;
  }

  /**
   * Add Item.
   *
   * @param user provided user.
   * @param itemToSave the item request
   * @return item the item persisted with id
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "items.add", path = "items", httpMethod = HttpMethod.POST)
  public Item addItem(User user, Item itemToSave) throws OAuthRequestException {

    validateAdmin(user);

    Item item = itemService.create(itemToSave);

    return item;
  }

  /**
   * Modify Item.
   * 
   * @param user provided user.
   * @param itemId item to update.
   * @param itemToUpdate the item request
   * @return item the item
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "items.put", path = "items/{itemId}", httpMethod = HttpMethod.PUT)
  public Item modifyItem(User user, @Named("itemId") final Long itemId, Item itemToUpdate)
      throws OAuthRequestException {

    validateAdmin(user);

    Item item = itemService.update(itemId, itemToUpdate);

    return item;
  }

  /**
   * Find items.
   * 
   * @return List of {@link ItemDto}
   * @throws OAuthRequestException returns a exception if the user is not authenticated
   */
  @ApiMethod(name = "items.find", path = "items", httpMethod = HttpMethod.GET)
  public List<Item> findItems(User user) throws OAuthRequestException {

    validateAdmin(user);

    List<Item> items = itemService.getAll();

    return items;

  }

  /**
   * Delete item by id.
   * 
   * @throws OAuthRequestException
   * 
   */
  @ApiMethod(name = "items.delete", path = "items/{itemId}", httpMethod = HttpMethod.DELETE)
  public void deleteItem(@Named("itemId") final Long itemId, User user)
      throws OAuthRequestException {

    validateAdmin(user);

    itemService.deleteById(itemId);

  }

  /**
   * Find track points by item id and date range.
   * 
   * @throws OAuthRequestException return an exception if the user is not logged.
   */
  @ApiMethod(name = "items.find.trackpoints", path = "items/{itemId}/trackpoints",
      httpMethod = HttpMethod.GET)
  public List<TrackPoint> findTrackPointsByItemId(@Named("itemId") final Long itemId,
      @Named("from") DateAndTime start, @Named("to") DateAndTime end, User user)
      throws OAuthRequestException {

    validateAdmin(user);
    validateDates(start, end);
   
    DateTime fromDate = null;
    DateTime toDate = null;

    if (start == null && end == null) {
      toDate = new DateTime();
      fromDate = toDate.minusWeeks(1);
    } else {
      fromDate = new DateTime(start.toRfc3339String());
      toDate = new DateTime(end.toRfc3339String());
    }
    
    return trackPointService.find(fromDate, toDate, itemId);

  }


  /**
   * Validates that provided dates (range) are: both completed or both null.
   * 
   * @param start the start date.
   * @param end the end date.
   */
  private void validateDates(DateAndTime start, DateAndTime end) {

    if ((start == null && end != null)) {
      throw new RuntimeException(
          "You can not send 'from' parameter as null if 'to' parameters is send it.");
    }

    if ((start != null && end == null)) {
      throw new RuntimeException(
          "You can not send 'to' parameter as null if 'from' parameters is send it.");
    }

  }


}
