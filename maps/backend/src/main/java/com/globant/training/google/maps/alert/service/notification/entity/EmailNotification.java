package com.globant.training.google.maps.alert.service.notification.entity;

import java.util.Set;

/**
 * Base contract for an email notification.
 * 
 * @author gaston.aguilera
 *
 */
public interface EmailNotification {

  /**
   * Get email subject.
   * 
   * @return subject.
   */
  String getSubject();

  /**
   * Get the email body.
   * 
   * @return an String body.
   */
  String getBody();

  /**
   * Get recipients emails.
   * 
   * @return a Set of emails.
   */
  Set<String> getRecipients();

}
