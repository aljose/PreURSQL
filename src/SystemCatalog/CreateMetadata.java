package SystemCatalog;

import StoredDataManager.Main.StoredDataManager;
import java.util.ArrayList;

/**
 *
 * @author Kevin
 */
/**
 * Clase encargada de construir el System Catalog que almacena la información
 * que controla urSQL y las bases de datos existentes.
 *
 */
public class CreateMetadata {

    ArrayList<ArrayList<ArrayList<String>>> Metadata = new ArrayList<ArrayList<ArrayList<String>>>();

    public void buildSystemCatalog() {
        //Definición del nombre del catálogo del sistema.   
        String catalogName = "system";

        //Definición del nombre de las tablas que serán ingresadas en el System Catalog.
        String schemaName = "Schema";
        String tableName = "Table";
        String columnName = "Column";
        String queryLogName = "QueryLog";
        String foreignKeyName = "ForeignKey";

        //Definición de las columnas a ingresar en tabla Schema.
        ArrayList<String> schemaColumns = new ArrayList<String>();
        String schema = "SchemaName";
        schemaColumns.add(schema);

        //Definición de las columnas a ingresar en tabla Table.
        ArrayList<String> tableColumns = new ArrayList<String>();
        String tableFirstCol = "SchemaName";
        String tableSecondCol = "TableName";
        tableColumns.add(tableFirstCol);
        tableColumns.add(tableSecondCol);

        //Definición de las columnas a ingresar en la tabla Column.
        ArrayList<String> columnColumns = new ArrayList<String>();
        String columnFirstCol = "Schema";
        String columnSecondCol = "Table";
        String columnThirdCol = "Column";
        String columnFourthCol = "Type";
        String columnFifthCol = "Constraint";
        String columnSixthCol = "PrimaryKey'";
        String columnSeventhCol = "ForeignKey";
        columnColumns.add(columnFirstCol);
        columnColumns.add(columnSecondCol);
        columnColumns.add(columnThirdCol);
        columnColumns.add(columnFourthCol);
        columnColumns.add(columnFifthCol);
        columnColumns.add(columnSixthCol);
        columnColumns.add(columnSeventhCol);
        //Definición de las columnas a ingresar en la tabla Query Log.
        ArrayList<String> queryColumns = new ArrayList<String>();
        String queryFirstCol = "Schema";
        String querySecondCol = "Table";
        String queryThirdCol = "Query";
        queryColumns.add(queryFirstCol);
        queryColumns.add(querySecondCol);
        queryColumns.add(queryThirdCol);

        //Definición de las columnas a ingresar en la tabla Foreign Key.
        ArrayList<String> foreignKeyColumns = new ArrayList<String>();
        String foreignFirstCol = "Schema";
        String foreignSecondCol = "Column";
        String foreignThirdCol = "OriginTable";
        String foreignFourthCol = "ColumnReferenced";
        String foreignFifthCol = "TableReferenced";
        foreignKeyColumns.add(foreignFirstCol);
        foreignKeyColumns.add(foreignSecondCol);
        foreignKeyColumns.add(foreignThirdCol);
        foreignKeyColumns.add(foreignFourthCol);
        foreignKeyColumns.add(foreignFifthCol);

        StoredDataManager storedDataManager = new StoredDataManager();
        Metadata.get(Constants.SCHEMA).add(schemaColumns);
        Metadata.get(Constants.TABLES).add(tableColumns);
        Metadata.get(Constants.COLUMNS).add(columnColumns);
        Metadata.get(Constants.QUERYLOG).add(queryColumns);
        Metadata.get(Constants.FOREIGNKEY).add(foreignKeyColumns);

        //Serialización del objeto árbol para almacenarlo en disco.
        /*
         StoredDataManager metadata = new StoredDataManager();
         metadata.createDatabase(catalogName);
         metadata.initStoredDataManager(catalogName);
         metadata.createTableFile(schemaName);
         metadata.createTableFile(tableName);
         metadata.createTableFile(columnName);
         metadata.createTableFile(schemaName);
         metadata.createTableFile(queryLogName);
         metadata.createTableFile(foreignKeyName);
         */
        // metadata.createTable
        //DatabaseRuntimeProcessor.createDatabase(catalogName);
        //DatabaseRuntimeProcessor.createTable(catalogName, schemaName, schemaColumns);    
        //DatabaseRuntimeProcessor.createTable(catalogName, tableName, tableColumns);
        //DatabaseRuntimeProcessor.createTable(catalogName, columnName, columnColumns);
        //DatabaseRuntimeProcessor.createTable(catalogName, queryLogName, queryColumns);
        //DatabaseRuntimeProcessor.createTable(catalogName, foreignKeyName, foreignKeyColumns); 
    }
}
