package com.globant.training.google.maps.core.dao.objectify;


import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.entity.GpsDevice;
import com.globant.training.google.maps.device.entity.RfidDevice;
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
    ObjectifyService.register(AppUser.class);

    ObjectifyService.register(Device.class);
    ObjectifyService.register(RfidDevice.class);
    ObjectifyService.register(GpsDevice.class);
    
    ObjectifyService.register(Antenna.class);
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
