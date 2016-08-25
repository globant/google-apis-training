package com.globant.training.google.maps.alert.service.notification;

import com.globant.training.google.maps.alert.service.notification.entity.EmailNotification;

public interface EmailService {
  /**
   * Send an alert notification.
   * 
   * @param notification notification.
   */
  void send(EmailNotification notification);
}
