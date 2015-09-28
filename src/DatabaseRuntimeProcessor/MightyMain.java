package DatabaseRuntimeProcessor;/*
 *               MightyMain 
 *     Clase inicializa y recibe las instrucciones del usuario ejecuta los analisis y retorna los 
 *     outputs. 
 */


import Analysis.LexicalAnalysis;
import GUI.GUI;
import Shared.Structures.Field;
import Shared.Structures.Metadata;
import Shared.Structures.Row;
import StoredDataManager.Main.StoredDataManager;
import SystemCatalog.Constants;

import java.util.ArrayList;

/**
 *
 * @author Nicolas Jimenez
 */
public class MightyMain {
    
    private String databaseName;

    /**
     * Ejecuta main
     *
     * @param args
     */
    public static void main(String[] args) {

        GUI guiInstance = new GUI();
        LexicalAnalysis lex = new LexicalAnalysis();
        ArrayList<String> instructionSet = lex.tokenize(null);

        
    }

    public void processer(ArrayList<String> instruccion) {

        String instruction0 = instruccion.get(0);

        switch (instruction0) {
           
            case "create":
                
                if (instruccion.get(1).equals("index")) {
                    
                    String nombreIndice = instruccion.get(2);
                    String tabla = instruccion.get(4);
                    String columna = instruccion.get(6);
                    
                   StoredDataManager stored = new StoredDataManager();
                   break;
                }

                else if (instruccion.get(1).equals("database")) {

                    CreateDatabase temp = new CreateDatabase();
                    temp.createDatabase(instruccion.get(2));
                    PlanEjecucion plan = new PlanEjecucion("createDatabase", instruccion);
                    
                    StoredDataManager storer = new StoredDataManager();
                    
                    Metadata meta = storer.deserealizateMetadata();
                   
                    meta.getMetadata().get(Constants.QUERYLOG ).add(new ArrayList()); 
                    break;

                } else if (instruccion.get(1).equals("table")) {

                    CreateTable createTab = new CreateTable();
                    int i = 5;
                    Field campo = null;
                    ArrayList<Field> columnas = new ArrayList<>();

                    while (!instruccion.get(i).equals("primary")) {

                        if (i + 3 <= instruccion.size()) {
                            if (instruccion.get(i + 1).equals("integer") || instruccion.get(i + 1).equals("varchar") || instruccion.get(i + 1).
                                    equals("datetime")) {

                                if (instruccion.get(i + 2).equals("null")) {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, true);
                                        i = i + 4;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, false);
                                        i = i + 4;
                                    }
                                } else {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, true);
                                        i = i + 5;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, false);
                                        i = i + 5;
                                    }
                                }
                            } else if (instruccion.get(i + 1).equals("decimal")) {

                                if (instruccion.get(i + 7).equals("null")) {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, true);
                                        i = i + 9;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, false);
                                        i = i + 9;
                                    }
                                } else {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, true);
                                        i = i + 10;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, false);
                                        i = i + 10;
                                    }
                                }
                            } else {

                                if (instruccion.get(i + 5).equals("null")) {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, true);
                                        i = i + 7;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, false);
                                        i = i + 7;
                                    }
                                } else {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, true);
                                        i = i + 8;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, false);
                                        i = i + 8;
                                    }
                                }
                            }
                        }
                        columnas.add(campo);
                    }
                    Row columnas1 = new Row(columnas);
                    createTab.createTable(databaseName, instruccion.get(2), columnas1);
                    PlanEjecucion plan = new PlanEjecucion("createTable", instruccion);
                    break;

                } 
            case "drop":

                if (instruccion.get(1).equals("table")) {
                    DropTable dropTab = new DropTable();
                    dropTab.dropTable(databaseName, instruccion.get(2));
                    PlanEjecucion plan = new PlanEjecucion("dropTable", instruccion);
                    plan.procesar();
                    break;

                } else {
                    DropDatabase dropData = new DropDatabase();
                    dropData.dropDatabase(databaseName);
                    PlanEjecucion plan = new PlanEjecucion("dropDatabase", instruccion);
                    break;
                }

            case "get":

            case "stop":

            case "list":
                ListDatabases lister = new ListDatabases();
                lister.listDatabases();
                PlanEjecucion plan = new PlanEjecucion("listDatabases", instruccion);
                break;

            case "display":
                DisplayDatabase display = new DisplayDatabase();
                display.displayDatabase(databaseName);
                PlanEjecucion planDD = new PlanEjecucion("displayDatabase", instruccion);
                break;

            case "set":
                this.databaseName = instruccion.get(2);
                PlanEjecucion planSD = new PlanEjecucion("set", instruccion);
                break;

            case "alter":
                AlterTable alter = new AlterTable();
                alter.alterTable(databaseName, instruccion.get(2), instruccion.get(8), instruccion.get(11), instruccion.get(13));
                PlanEjecucion planAT = new PlanEjecucion("createTable", instruccion);

                break;

            case "select":

            case "update":

                if (instruccion.size() > 6) {
                    //   Update update = new Update(instruccion.get(3), instruccion.get(1), instruccion.get(5), instruccion.get(6), 
                    //         instruccion.get(7), instruccion.get(8) ) ;
                } else {

                }
            case "delete":

                if (instruccion.size() > 3) {

                    //  Delete del = new Delete(, null, databaseName, instruction0, databaseName, value)
                }

            case "insert":

                ArrayList<String> cols = new ArrayList<>();
                ArrayList<String> valores = new ArrayList<>();

                int i;
                for (i = 4; instruccion.get(i).equals(")"); i++) {

                    String elementoActual = instruccion.get(i);
                    if (!elementoActual.equals(",") && !elementoActual.equals(")")) {

                        cols.add(elementoActual);
                    }
                }
                for (i = i + 2; instruccion.get(i).equals(")"); i++) {

                    String elementoActual = instruccion.get(i);
                    if (!elementoActual.equals(",") && !elementoActual.equals(")")) {

                        valores.add(elementoActual);
                    }
                }
                InsertInto ins = new InsertInto();
                ins.executeInsertion(instruccion.get(2), cols, valores, databaseName);
        }
    }
}


