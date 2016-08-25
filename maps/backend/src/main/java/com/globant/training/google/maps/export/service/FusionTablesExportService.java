package com.globant.training.google.maps.export.service;

import com.google.api.services.fusiontables.model.Column;
import com.google.api.services.fusiontables.model.Table;
import com.google.inject.Inject;

import com.globant.training.google.maps.export.service.fusiontables.FusionTablesService;
import com.globant.training.google.maps.trackpoint.entity.TrackPoint;
import com.globant.training.google.maps.trackpoint.service.TrackPointService;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.service.UserService;

import org.joda.time.DateTime;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Heatmap service fusion tables implementation.
 * 
 * @author gaston.aguilera
 *
 */
public class FusionTablesExportService implements ExportService {
  
  private Logger logger = Logger.getLogger(FusionTablesExportService.class.getName());
  
  /**
   * Default fusion table name for global entrypoints.
   */
  public static final String FUSION_TABLE_ENTRY_POINTS_NAME = "maps-global-points";
  
  /**
   * Columns on fusion table.
   */
  public static final Column[] COLUMNS = {new Column().setName("ItemId").setType("NUMBER"),
      new Column().setName("DeviceId").setType("NUMBER"),
      new Column().setName("Location").setType("LOCATION"),
      new Column().setName("Date").setType("DATETIME")};
  
  
  private final UserService userService;
  
  private final FusionTablesService fusionTablesService;
  
  private final TrackPointService trackPointService;

  @Inject
  public FusionTablesExportService(FusionTablesService fusionTablesService,
      UserService userService, TrackPointService trackPointService) {
    this.fusionTablesService = fusionTablesService;
    this.userService = userService;
    this.trackPointService = trackPointService;
  }

  @Override
  public void exportTrackPoints(DateTime fromDate, DateTime toDate, Long itemId) {
    List<TrackPoint> trackpointsToExport = trackPointService.find(fromDate, toDate, itemId);
    
    List<String[]> rows = extractRows(trackpointsToExport);
    try {
      fusionTablesService.insertRows(createTable(), COLUMNS, rows);
    } catch (IOException ex) {
      logger.log(Level.SEVERE, "Cannot export entrypoint data to fusion tables", ex);
    }
  }
  
  /**
   * Generate fusion table row form entrypoint.
   * @param point point to be processed.
   * @return String[] current row.
   */
  private List<String[]> extractRows(List<TrackPoint> points) {
    
    List<String[]> rows = new ArrayList<String[]>();

    for (TrackPoint point : points) {
      
      Date measureDate = point.getMeasuredDate().toDate();
      
      String[] row = {String.valueOf(point.getItemId()), String.valueOf(point.getDeviceId()),
          point.getLocation(),
          new com.google.api.client.util.DateTime(measureDate).toStringRfc3339()};
      rows.add(row);
    }

    return rows;
  }

  /**
   * Creates a table and return the table id.
   * Permissions are granted to admin users. 
   * 
   * @return String the fusion table id.
   * @throws IOException on fusion table communication error.
   */
  public String createTable() throws IOException {
    String tableId = null;
    Table table =
        fusionTablesService.createTable(FUSION_TABLE_ENTRY_POINTS_NAME, COLUMNS, getAdminEmails());
    tableId = table.getTableId();
    return tableId;
  }

  /**
   * Get the list of admin emails.
   * 
   * @return a list of admin emails.
   */
  private List<String> getAdminEmails() {
    List<String> emails = new ArrayList<>();

    for (AppUser user : userService.getAllUsers()) {
      if (user.isAdmin()) {
        emails.add(user.getEmail());
      }
    }
    return emails;
  }


}
