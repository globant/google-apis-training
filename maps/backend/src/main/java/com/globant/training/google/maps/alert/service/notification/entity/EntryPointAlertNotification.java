package com.globant.training.google.maps.alert.service.notification.entity;

import com.globant.training.google.maps.alert.entity.Alert;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;

import java.util.HashSet;
import java.util.Set;

/**
 * Entry point alert notification as {@link EmailNotification} implementation.
 * 
 * @author gaston.aguilera
 *
 */
public class EntryPointAlertNotification implements EmailNotification {

  private Alert alert;

  private TrackPointAddedEvent trackPoint;

  private Item item;
  
  Set<String> recipients;

  private EntryPointAlertNotification() {}

  @Override
  public String getSubject() {
    return "Alert recieved from item: " + item.getName();
  }

  @Override
  public String getBody() {
    return "Alert " + alert.getName() + " recieved from item: " + item.getName() + " at "
        + trackPoint.getMeasuredDate();
  }

  @Override
  public Set<String> getRecipients() {
    return recipients;
  }

  /**
   * Builder.
   * 
   * @author gaston.aguilera
   *
   */
  public static class Builder {

    Alert alert;
    TrackPointAddedEvent trackPoint;
    Item item;
    Set<String> recipients = new HashSet<>();


    public Builder alert(Alert alert) {
      this.alert = alert;
      return this;
    }

    public Builder trackPoint(TrackPointAddedEvent trackPoint) {
      this.trackPoint = trackPoint;
      return this;
    }

    public Builder recipients(Set<String> recipients) {
      this.recipients = recipients;
      return this;
    }

    public Builder item(Item item) {
      this.item = item;
      return this;
    }

    /**
     * Builds an AlertEmailNotification.
     * 
     * @return {@link EmailNotification}
     */
    public EmailNotification build() {

      EntryPointAlertNotification notification = new EntryPointAlertNotification();
      notification.alert = alert;
      notification.trackPoint = trackPoint;
      notification.item = item;
      notification.recipients = recipients;
      return notification;


    }
  }

}
