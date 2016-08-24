package com.globant.training.google.maps.core.dao.objectify;


import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.impl.translate.opt.joda.JodaTimeTranslators;

import com.globant.training.google.maps.alert.entity.Alert;
import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.entity.GpsDevice;
import com.globant.training.google.maps.device.entity.RfidDevice;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.trackpoint.entity.GpsTrackPoint;
import com.globant.training.google.maps.trackpoint.entity.RfidTrackPoint;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.user.entity.AppUser;

/**
 * Class to provide access to {@link Objectify} Methods.
 * All the entities must be registered here.
 * 
 * @author gabriel.sideri
 */
public class OfyService {

  /**
   * Register all entities
   */
  static {
  
    JodaTimeTranslators.add(ObjectifyService.factory());
    
    ObjectifyService.register(AppUser.class);

    ObjectifyService.register(Device.class);
    ObjectifyService.register(RfidDevice.class);
    ObjectifyService.register(GpsDevice.class);
    
    ObjectifyService.register(Antenna.class);
    ObjectifyService.register(Item.class);
    ObjectifyService.register(TrackPoint.class);
    ObjectifyService.register(RfidTrackPoint.class);
    ObjectifyService.register(GpsTrackPoint.class);
    ObjectifyService.register(Alert.class);
   
  }

  /**
   * Access to {@link ObjectifyService#ofy()} Service.
   * 
   * @return the {@link ObjectifyService#ofy()}
   */
  public static Objectify ofy() {
    return ObjectifyService.ofy();
  }

  /**
   * Access to {@link ObjectifyService#factory()}.
   * 
   * @return the  {@link ObjectifyService#factory()}
   */
  public static ObjectifyFactory factory() {
    return ObjectifyService.factory();
  }
}
