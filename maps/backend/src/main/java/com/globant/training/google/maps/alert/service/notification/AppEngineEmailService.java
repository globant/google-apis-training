package com.globant.training.google.maps.alert.service.notification;

import com.google.appengine.api.utils.SystemProperty;

import com.globant.training.google.maps.alert.service.notification.entity.EmailNotification;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * App engine basic email service.
 * 
 * @author gaston.aguilera
 *
 */
public class AppEngineEmailService implements EmailService {

  private static final Logger log = Logger.getLogger(AppEngineEmailService.class.getName());

  @Override
  public void send(EmailNotification notification) {

    Properties props = new Properties();
    Session session = Session.getDefaultInstance(props, null);
    String body = notification.getBody();
    try {
      Message message = new MimeMessage(session);
      InternetAddress from = new InternetAddress(
          String.format("noreply@%s.appspotmail.com", SystemProperty.applicationId.get()),
          "POC Maps");
      message.setFrom(from);
      for (String email : notification.getRecipients()) {
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email, ""));

      }
      message.setSubject(notification.getSubject());
      message.setText(body);
      Transport.send(message);
    } catch (Exception ex) {
      log.log(Level.WARNING,
          String.format("Failed to send an mail to %s", notification.getSubject()), ex);
      throw new RuntimeException(ex);
    }
  }

}
