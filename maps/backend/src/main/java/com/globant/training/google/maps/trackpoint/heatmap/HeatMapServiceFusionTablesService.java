package com.globant.training.google.maps.trackpoint.heatmap;

import com.google.api.services.fusiontables.model.Column;
import com.google.api.services.fusiontables.model.Table;
import com.google.inject.Inject;

import com.globant.training.google.maps.export.fusiontables.FusionTablesService;
import com.globant.training.google.maps.trackpoint.service.event.TrackPointAddedEvent;
import com.globant.training.google.maps.user.entity.AppUser;
import com.globant.training.google.maps.user.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Heatmap service fusion tables implementation.
 * 
 * @author gaston.aguilera
 *
 */
public class HeatMapServiceFusionTablesService implements HeatmapService {
  
  private Logger logger = Logger.getLogger(HeatMapServiceFusionTablesService.class.getName());

  /**
   * Default fusion table name for global entrypoints.
   */
  public static final String FUSION_TABLE_ENTRY_POINTS_GLOBAL = "maps-global-points";

  /**
   * Columns on fusion table.
   */
  public static final Column[] COLUMNS = {new Column().setName("ItemId").setType("NUMBER"),
      new Column().setName("DeviceId").setType("NUMBER"),
      new Column().setName("Location").setType("LOCATION"),
      new Column().setName("Date").setType("DATETIME")};
  
  private final UserService userService;
  
  private final FusionTablesService fusionTablesService;

  @Inject
  public HeatMapServiceFusionTablesService(FusionTablesService fusionTablesService,
      UserService userService) {
    this.fusionTablesService = fusionTablesService;
    this.userService = userService;
  }
  
  /**
   * Global fusion table id holder.
   */
  private String globalTableId = null;
  
  @Override
  public void addEntryPoint(TrackPointAddedEvent point) {

    try {
      
      String[] row = extractRow(point);
      fusionTablesService.insertRows(getGlobalTableId(), COLUMNS, row);

    } catch (IOException ex) {
      logger.log(Level.SEVERE, "Cannot insert point into fusion tables.", ex);
    }
  }

  /**
   * Generate fusion table row form entrypoint.
   * @param point point to be processed.
   * @return String[] current row.
   */
  private String[] extractRow(TrackPointAddedEvent point) {
    String[] row = {String.valueOf(point.getItemId()), String.valueOf(point.getDeviceId()),
        point.getLocation(), point.getDateTime().toStringRfc3339()};
    return row;
  }

  /**
   * Get the global table id.
   * If table doesn't exists is created, and permissions are granted to admin users. 
   * 
   * @return String the fusion table id.
   * @throws IOException on fusion table communication error.
   */
  public String getGlobalTableId() {
    try {
      if (globalTableId == null) {
        Table table;

        table = fusionTablesService.getTableByName(FUSION_TABLE_ENTRY_POINTS_GLOBAL);

        if (table == null) {
          table = fusionTablesService.createTable(FUSION_TABLE_ENTRY_POINTS_GLOBAL, COLUMNS,
              getAdminEmails());
        }
        globalTableId = table.getTableId();
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    return globalTableId;
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
