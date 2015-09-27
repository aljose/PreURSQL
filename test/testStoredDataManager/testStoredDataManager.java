package testStoredDataManager;

import Shared.Structures.Field;
import Shared.Structures.Row;
import StoredDataManager.Main.StoredDataManager;

import java.util.ArrayList;

/**
 * Created by manzumbado on 26/09/15.
 */
public class testStoredDataManager {


    public static void main(String[] args){


        StoredDataManager storedDataManager = new StoredDataManager();
        System.out.println(System.getProperty("user.dir"));
        storedDataManager.createDatabase("prueba");
        storedDataManager.initStoredDataManager("prueba");
        storedDataManager.createTableFile("Tabla1");

        ArrayList<Field> fields = new ArrayList<Field>();
        fields.add(new Field("valor123456","String",false,"Tabla1", "prueba",true));
        fields.add(new Field("valorabcdefg", "String", false,"Tabla1", "prueba",false));
        fields.add(new Field("valorqwerty","String",false,"Tabla1", "prueba",false));
        fields.add(new Field("valor0987654321","String",false,"Tabla1", "prueba",false));
        fields.add(new Field("valor3193", "String", false,"Tabla1", "prueba",false));
        Row row = new Row(fields);
        row.setTableName("Tabla1");
        storedDataManager.insertIntoTable(row);

        fields = new ArrayList<Field>();
        fields.add(new Field("valorc1","String",false,"Tabla1", "prueba",true));
        fields.add(new Field("valorcacabubu", "String", false,"Tabla1", "prueba",false));
        fields.add(new Field("valormecague","String",false,"Tabla1", "prueba",false));
        fields.add(new Field("valoryiscrist","String",false,"Tabla1", "prueba",false));
        fields.add(new Field("valor4194","String",false,"Tabla1", "prueba",false));
        row = new Row(fields);
        row.setTableName("Tabla1");
        storedDataManager.insertIntoTable(row);

        storedDataManager.createDatabase("prueba2");
        storedDataManager.initStoredDataManager("prueba2");
        storedDataManager.createTableFile("Tabla2");

         fields = new ArrayList<Field>();
        fields.add(new Field("valorsdsdsd","String",false,"Tabla2", "prueba2",true));
        fields.add(new Field("valorassdg", "String", false,"Tabla2", "prueba2",false));
        fields.add(new Field("valorqwedsd","String",false,"Tabla2", "prueba2",false));
        fields.add(new Field("valor0984321","String",false,"Tabla2", "prueba2",false));
        fields.add(new Field("valor319ddf3", "String", false,"Tabla2", "prueba2",false));
         row = new Row(fields);
         row.setTableName("Tabla1");
        storedDataManager.insertIntoTable(row);

        fields = new ArrayList<Field>();
        fields.add(new Field("valormerge","String",false,"Tabla2", "prueba2",true));
        fields.add(new Field("valorsub", "String", false,"Tabla2", "prueba2",false));
        fields.add(new Field("valorcrio","String",false,"Tabla2", "prueba2",false));
        fields.add(new Field("valorjude","String",false,"Tabla2", "prueba2",false));
        fields.add(new Field("valor4554","String",false,"Tabla2", "prueba2",false));
        row = new Row(fields);
        row.setTableName("Tabla2");
        storedDataManager.insertIntoTable(row);




        //storedDataManager.flushToDisk();
/*
        long[] offsets= new long[3];

        for (int i=0; i<3;i++){
           offsets[i]= writer.writeToDBFile(field[i]);
            System.out.println("Value of offset  "+ offsets[i]);
        }
        writer.closeFile();



        storedDataManager.createTableFile("Tabla2");

        field= new DBField[3];
        field[0]= new DBField("cacabubu",10);
        field[1]= new DBField("123456778890",10);
        field[2]= new DBField("ayercomipescado",10);


        writer = new DBWriter();
        writer.setTableFile(DIRECTORIO_DATOS+File.separator+storedDataManager.mCurrentDataBase+File.separator+"Tabla2"+EXTENSION_ARCHIVO_TABLA);

        offsets= new long[3];

        for (int i=0; i<3;i++){
            offsets[i]= writer.writeToDBFile(field[i]);
            System.out.println("Value of offset  "+ offsets[i]);
        }
        writer.closeFile();




        storedDataManager.createTableFile("Tabla3");

        field= new DBField[3];
        field[0]= new DBField("campo1","laconcha",10);
        field[1]= new DBField("campo2","requeson",10);
        field[2]= new DBField("campo3","lacasadeallado",10);


         writer = new DBWriter();
        writer.setTableFile(DIRECTORIO_DATOS+File.separator+storedDataManager.mCurrentDataBase+File.separator+"Tabla3"+EXTENSION_ARCHIVO_TABLA);

        offsets= new long[3];

        for (int i=0; i<3;i++){
            offsets[i]= writer.writeToDBFile(field[i]);
            System.out.println("Value of offset  "+ offsets[i]);
        }
        writer.closeFile();

        DBReader reader = new DBReader();
        reader.setTableFile(DIRECTORIO_DATOS+File.separator+storedDataManager.mCurrentDataBase+File.separator+"Tabla3"+EXTENSION_ARCHIVO_TABLA);

        for(int i=0; i<3; i++){

            DBField field1 = reader.readFromDBFile(offsets[i]);
            System.out.println(field1.toString());

        }
        reader.closeFile();



        //StoredDataManager.Main.StoredDataManager sdm = new StoredDataManager.Main.StoredDataManager();
        //sdm.initStoredDataManager("prueba");

*/


    }
}
