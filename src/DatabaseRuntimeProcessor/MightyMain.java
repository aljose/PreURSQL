package DatabaseRuntimeProcessor;/*
 *               MightyMain 
 *     Clase inicializa y recibe las instrucciones del usuario ejecuta los analisis y retorna los 
 *     outputs. 
 */


import Analysis.LexicalAnalysis;
import GUI.GUI;
import Shared.Structures.Field;
import Shared.Structures.Row;

import java.util.ArrayList;

/**
 *
 * @author nicolasjimenez
 */
public class MightyMain {

    /**
     * Ejecuta main
     *
     * @param args
     */
    public static void main(String[] args) {

        GUI guiInstance = new GUI();

        LexicalAnalysis lex = new LexicalAnalysis();
        ArrayList<String> instructionSet = lex.tokenize(null);

        for (String instruccion : instructionSet) {

        }
    }

    private void processer(ArrayList<String> instruccion, String databaseName) {

        String instruction0 = instruccion.get(0);

        switch (instruction0) {

            case "create":

                if (instruccion.get(1).equals("database")) {

                    CreateDatabase temp = new CreateDatabase();
                    temp.createDatabase(instruccion.get(2));
                    PlanEjecucion plan = new PlanEjecucion("createDatabase", instruccion);
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
                                        i = i+3;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, false);
                                        i= i+3; 
                                    }
                                } else {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, true);
                                        i=i+4;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, false);
                                        i = i+4;
                                    }
                                }
                            } else if (instruccion.get(i + 1).equals("decimal")) {

                                if (instruccion.get(i + 7).equals("null")) {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, true);
                                        i = i + 8;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, false);
                                        i = i+8;
                                    }
                                } else {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, true);
                                        i = i +9;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, false);
                                        i= i+9;
                                    }
                                }
                            } else {

                                if (instruccion.get(i + 5).equals("null")) {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, true);
                                        i = i+6;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), true, instruccion.get(1), databaseName, false);
                                        i = i+6;
                                    }
                                } else {

                                    if (i == 5) {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, true);
                                        i = i+7;
                                    } else {
                                        campo = new Field(instruccion.get(i), instruccion.get(i + 1), false, instruccion.get(1), databaseName, false);
                                        i = i+ 7;
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

                } else {

                }
            case "drop":

                if (instruccion.get(1).equals("table")) {
                    DropTable dropTab = new DropTable();
                    dropTab.dropTable(databaseName, instruccion.get(2));
                    PlanEjecucion plan = new PlanEjecucion("dropTable", instruccion);
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

            case "alter":
                AlterTable alter = new AlterTable();
                alter.alterTable(databaseName, instruccion.get(2), instruccion.get(8), instruccion.get(11), instruccion.get(13));
                PlanEjecucion planAT = new PlanEjecucion("createTable", instruccion);

                break;

            case "select":

            case "update":

            case "delete":

            case "insert":
        }
    }

}
