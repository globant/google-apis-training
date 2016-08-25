package com.globant.training.google.maps.export.service.fusiontables;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.extensions.appengine.auth.oauth2.AppIdentityCredential;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.Permission;
import com.google.api.services.fusiontables.Fusiontables;
import com.google.api.services.fusiontables.Fusiontables.Query.Sql;
import com.google.api.services.fusiontables.FusiontablesScopes;
import com.google.api.services.fusiontables.model.Column;
import com.google.api.services.fusiontables.model.Table;
import com.google.api.services.fusiontables.model.TableList;
import com.google.appengine.api.utils.SystemProperty;

import com.globant.training.google.maps.configs.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Google fusion tables v2-rev13-1.22.0 implementation.
 * 
 * @author gaston.aguilera
 */
public class FusionTablesServiceImpl implements FusionTablesService {

  private Logger logger = Logger.getLogger(FusionTablesServiceImpl.class.getName());

  /**
   * Name of maps app to be identified by api client.
   */
  private static final String APP_NAME = "Maps-FusionTables/1.0";

  /**
   * Global instance of the JSON factory.
   */
  private static final JacksonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

  /**
   * Global Transport of the JSON factory.
   */
  private static final HttpTransport TRANSPORT = new NetHttpTransport();

  /**
   * Google Fusion table service.
   */
  private Fusiontables fusionTables = null;

  /**
   * Google Drive service.
   */
  private Drive drive = null;

  public FusionTablesServiceImpl() {
    init();
  }

  @Override
  public Table getTableByName(String tableName) throws IOException {

    Fusiontables.Table.List listTables = fusionTables.table().list();
    TableList tablelist = listTables.execute();

    Table table = null;

    for (Table currentTable : tablelist.getItems()) {
      if (tableName.equals(currentTable.getName())) {
        table = currentTable;
      }
    }

    return table;
  }

  @Override
  public Table createTable(String tableName, Column[] columns, List<String> shareEmails)
      throws IOException {

    // Create a new table
    Table table = new Table();
    table.setName(tableName);
    table.setIsExportable(false);
    table.setDescription("Poc Maps Table");

    // Set columns for new table
    table.setColumns(Arrays.asList(columns));

    // Adds a new column to the table.
    Fusiontables.Table.Insert insertTable = fusionTables.table().insert(table);
    
    Permission permission = new Permission();
    for (String email : shareEmails) {
      permission.setValue(email);
      permission.setType("user");
      permission.setRole("writer");
    }

    Table resultTable = insertTable.execute();

    drive.permissions().insert(resultTable.getTableId(), permission).execute();

    return resultTable;
  }

  @Override
  public void insertRows(String tableId, Column[] columns, List<String[]> rows) throws IOException {
    Sql sql = null;
    for (String[] row : rows) {
      sql = fusionTables.query().sql(createSqlInsertStatement(tableId, columns, row));
    }
    if (sql != null) {
      sql.execute();
    }
  }


  @Override
  public void deleteTable(String tableId) throws IOException {
    Fusiontables.Table.Delete delete = fusionTables.table().delete(tableId);
    delete.execute();
  }
  
  /**
   * Initialize credentials (HttpRequestInitializer), fusionTableService and driveService.
   */
  private void init() {
    HttpRequestInitializer httpRequestInitializer = getRequestInitializer();

    fusionTables = new Fusiontables.Builder(TRANSPORT, JSON_FACTORY, httpRequestInitializer)
        .setApplicationName(APP_NAME).build();

    drive = new Drive.Builder(TRANSPORT, JSON_FACTORY, httpRequestInitializer)
        .setApplicationName(APP_NAME).build();
  }

  /**
   * Gets a request initializer.
   * 
   * @return {@link HttpRequestInitializer} with credentials depending the enviroment.
   */
  private HttpRequestInitializer getRequestInitializer() {

    HttpRequestInitializer httpRequestInitializer = null;

    Collection<String> scopes =
        Arrays.asList(DriveScopes.DRIVE, DriveScopes.DRIVE_FILE, FusiontablesScopes.FUSIONTABLES);

    try {

      if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
        httpRequestInitializer = new AppIdentityCredential(scopes);
      } else {
        InputStream resourceAsStream = new FileInputStream(Constants.JSON_CREDENTIALS_PATH);
        httpRequestInitializer = GoogleCredential.fromStream(resourceAsStream).createScoped(scopes);
      }
    } catch (Exception ex) {
      logger.log(Level.SEVERE, "Cannot initialize credentials for HeatmapFusionTablesService", ex);
    }
    return httpRequestInitializer;
  }

  /**
   * Creates a sql insert statement.
   * 
   * @param tableId table id.
   * @param columnsNames columns.
   * @param row row to be inserted.
   * @return the insert statement.
   */
  private String createSqlInsertStatement(String tableId, Column[] columnsNames, String[] row) {

    StringBuilder columns = new StringBuilder("(");
    StringBuilder values = new StringBuilder("(");

    for (int i = 0; i < row.length; i++) {
      columns.append(columnsNames[i].getName());

      if (row[i] == null) {
        values.append("''");
      } else {
        values.append("'" + row[i] + "'");
      }

      if (i < row.length - 1) {
        columns.append(",");
        values.append(",");
      }
    }
    columns.append(")");
    values.append(")");

    StringBuilder sb = new StringBuilder("INSERT INTO ");
    return sb.append(tableId + " ").append(columns.toString() + " VALUES ")
        .append(values.toString()).toString();
  }
  
}
