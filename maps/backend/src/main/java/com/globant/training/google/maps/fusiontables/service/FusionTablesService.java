package com.globant.training.google.maps.fusiontables.service;

import com.google.api.services.fusiontables.model.Column;
import com.google.api.services.fusiontables.model.Table;

import java.io.IOException;
import java.util.List;

/**
 * Contract for fusion tables service operations.
 * 
 * @author gaston.aguilera
 */
public interface FusionTablesService {

  /**
   * Get a table by name, if doesn't.
   * @param tableName name of fusion table to be found.
   * @return a {@link Table} or null if not found.
   * 
   * @throws IOException if an error in communication with fusion tables services.
   */
  Table getTableByName(String tableName) throws IOException;
  
  /**
   * Create table.
   * 
   * @param tableName name of table to be created.
   * @param columns columns to be used for table.
   * @param shareEmails a list of emails who will be added as writers of created table.
   * 
   * @return {@link Table} the created table.
   * @throws IOException if an error in communication with fusion tables services.
   */
  Table createTable(String tableName, Column[] columns, List<String> shareEmails)
      throws IOException;

  /**
   * Insert a row in a fusion table.
   * 
   * @param tableId table id.
   * @param row String[] of row data.
   * 
   * @throws IOException if an error in communication with fusion table service.
   */
  void insertRows(String tableId, Column[] columns, String[] row) throws IOException;

  /**
   * Delete a fusion table by id.
   * 
   * @param tableId id to be deleted.
   * @throws IOException if an error in fusion tables communication.
   */
  void deleteTable(String tableId) throws IOException;

}
