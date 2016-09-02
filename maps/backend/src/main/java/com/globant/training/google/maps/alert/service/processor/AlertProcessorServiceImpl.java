package com.globant.training.google.maps.alert.service.processor;

import com.google.inject.Inject;
import com.google.maps.android.PolyUtil;

import com.globant.training.google.maps.alert.entity.Alert;
import com.globant.training.google.maps.alert.entity.LatLng;
import com.globant.training.google.maps.alert.service.AlertService;
import com.globant.training.google.maps.alert.service.notification.EmailService;
import com.globant.training.google.maps.alert.service.notification.entity.EmailNotification;
import com.globant.training.google.maps.alert.service.notification.entity.EntryPointAlertNotification;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.item.service.ItemService;
import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.service.UserService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Logger;

/**
 * Alert processor service.
 * Used to process TrackPointAddedEvent and check if there is match with some active alert-
 * 
 * @author gaston.aguilera
 */
public class AlertProcessorServiceImpl implements AlertProcessorService {

  private Logger logger = Logger.getLogger(AlertProcessorServiceImpl.class.getName());

  private final AlertService alertService;

  private final EmailService emailService;

  private final ItemService itemService;

  private final UserService userService;

  /**
   * Constructor.
   * 
   * @param alertService alert Service.
   * @param emailService email Service.
   * @param itemService item Service.
   * @param userService user Service.
   */
  @Inject
  public AlertProcessorServiceImpl(AlertService alertService, EmailService emailService,
      ItemService itemService, UserService userService) {
    this.alertService = alertService;
    this.emailService = emailService;
    this.itemService = itemService;
    this.userService = userService;
  }

  @Override
  public void process(TrackPointAddedEvent point) {
    logger.info("procesing alerts for entrypoint point for item" + point);

    checkAlerts(point);

    logger.info("entry point " + point + " processed by alert processor");
  }


  /**
   * Check a coordinate {@link TrackPointAddedEvent} with current active alerts.
   * 
   * @param trackPoint {@link TrackPointAddedEvent} track point to be checked location.
   */
  private void checkAlerts(TrackPointAddedEvent trackPoint) {

    LatLng point = new LatLng(trackPoint.getLatitude(), trackPoint.getLongitude());

    Map<Long, Alert> activeAlerts = getAlertPolygonsMap();

    for (Entry<Long, Alert> entry : activeAlerts.entrySet()) {

      Alert alert = entry.getValue();
      
      List<LatLng> polygon = alert.getPoligonRegion();

      boolean polygonContainsLocation = PolyUtil.containsLocation(point, polygon, true);

      if (alert.checkTrigger(polygonContainsLocation)) {

        // get fresh alert
        Alert freshAlert = alertService.findById(entry.getKey());

        sendNotification(freshAlert, trackPoint);

      }
    }
  }

  private void sendNotification(Alert alert, TrackPointAddedEvent trackPoint) {
    

    Item item = itemService.findById(trackPoint.getItemId());

    // @formatter:off
    EmailNotification notification = new EntryPointAlertNotification.Builder()
        .alert(alert)
        .trackPoint(trackPoint)
        .item(item)
        .recipients(getAdminEmails())
        .build();
    // @formatter:on
    emailService.send(notification);
  }

  /**
   * Get the list of admin emails.
   * 
   * @return a list of admin emails.
   */
  private Set<String> getAdminEmails() {
    Set<String> emails = new HashSet<>();

    for (AppUser user : userService.getAllUsers()) {
      if (user.isAdmin()) {
        emails.add(user.getEmail());
      }
    }
    return emails;
  }

  /**
   * Return a Map of key=alertId and Polygon (list of coordinates) of active alerts. TODO add
   * caching in this level.
   * 
   * @return a Map.
   */
  private Map<Long, Alert> getAlertPolygonsMap() {

    Map<Long, Alert> alertPoligonsMaps = new HashMap<Long, Alert>();
    for (Alert alert : alertService.findActive()) {
      alertPoligonsMaps.put(alert.getId(), alert);
    }
    return alertPoligonsMaps;
  }

}
