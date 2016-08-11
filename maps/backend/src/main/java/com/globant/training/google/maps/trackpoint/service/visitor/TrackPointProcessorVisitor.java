package com.globant.training.google.maps.trackpoint.service.visitor;

import com.google.inject.Inject;

import com.globant.training.google.maps.antenna.entity.Antenna;
import com.globant.training.google.maps.antenna.service.AntennaService;
import com.globant.training.google.maps.device.entity.Device;
import com.globant.training.google.maps.device.entity.DeviceType;
import com.globant.training.google.maps.device.service.DeviceService;
import com.globant.training.google.maps.item.entity.Item;
import com.globant.training.google.maps.item.service.ItemService;
import com.globant.training.google.maps.trackpoint.entity.GpsTrackPoint;
import com.globant.training.google.maps.trackpoint.entity.RfidTrackPoint;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;

import org.apache.commons.lang3.Validate;

/**
 * TrackPoint Processor Visitor Class. Defines logic to validate {@link TrackPoint}.
 * 
 * @author gabriel.sideri
 */
public class TrackPointProcessorVisitor implements TrackPointVisitor {

  private DeviceService deviceService;

  private ItemService itemService;

  private AntennaService antennaService;

  /**
   * Injects the needed services.
   * 
   * @param deviceService the device service
   * @param itemService the item service
   */
  @Inject
  public TrackPointProcessorVisitor(DeviceService deviceService, ItemService itemService,
      AntennaService antennaService) {
    this.deviceService = deviceService;
    this.itemService = itemService;
    this.antennaService = antennaService;
  }

  @Override
  public void visit(GpsTrackPoint trackPoint) {
    Validate.notNull(trackPoint.getDeviceId(), "Device Id can not be null");

    Device device = deviceService.findById(trackPoint.getDeviceId());

    if (!device.getType().equals(DeviceType.GPS)) {
      throw new RuntimeException(
          "Device is not a GPS. With given parameters, "
          + "you only can add trackpoints for a GPS device.");
    }

    if (!device.isActive()) {
      throw new RuntimeException(
          "Device is not active, you only can add a track point for an active device.");
    }


    Item item = itemService.findItemByDeviceId(trackPoint.getDeviceId());

    if (!item.isActive()) {
      throw new RuntimeException("The Item assigned to the device is not active, "
          + "you only can add a track point for an active item.");
    }

    trackPoint.setItemId(item.getId());

  }

  @Override
  public void visit(RfidTrackPoint trackPoint) {
    Validate.notNull(trackPoint, "RfidTrackPoint not be null");
    Validate.notNull(trackPoint.getAntennaId(), "Antenna Id can not be null");
    Validate.notEmpty(trackPoint.getRfidId(), "Rfid Id can not be null or empty");

    Device device = deviceService.findDeviceByRfidId(trackPoint.getRfidId());

    if (!device.getType().equals(DeviceType.RFID)) {
      throw new RuntimeException(
          "Device is not a RFID. With given parameters, "
          + "you only can add trackpoints for a RFID device.");
    }

    if (!device.isActive()) {
      throw new RuntimeException(
          "Device is not active, you only can add a track point for an active device.");
    }

    Item item = itemService.findItemByDeviceId(device.getId());

    if (!item.isActive()) {
      throw new RuntimeException("The Item assigned to the rfid device is not active, "
          + "you only can add a track point for an active item.");
    }

    Antenna antenna = antennaService.findById(trackPoint.getAntennaId());

    if (!antenna.isActive()) {
      throw new RuntimeException(
          "Antenna is not active, you only can add a track point for an active Antenna.");
    }

    trackPoint.setLatitude(antenna.getLatitude());
    trackPoint.setLongitude(antenna.getLongitude());
    trackPoint.setItemId(item.getId());
    trackPoint.setDeviceId(device.getId());

  }

}
