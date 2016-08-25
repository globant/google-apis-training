package com.globant.training.google.maps.export.service;

import org.joda.time.DateTime;

/**
 * Heat map service to process trackpoints.
 * 
 * @author gaston.aguilera
 */
public interface ExportService {

  /**
   * Export trackpoints by filter.
   * 
   * @param fromDate from date.
   * @param toDate to date.
   * @param itemId item id.
   */
  void exportTrackPoints(DateTime fromDate,
      DateTime toDate, Long itemId);

}
