
/**
 * @(#)Retrieve.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/14
 */

import javax.swing.*;
import java.sql.*;

import java.util.LinkedList;
import java.util.Arrays;

public class Retrieve
{

		String output;

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        LinkedList< RecordClass > recordsList =    new LinkedList< RecordClass >( );
        RecordClass record;



public Retrieve()
{

}

    public  LinkedList< RecordClass > retrieveFromDb() {


        try {


            StringBuilder sb = new StringBuilder();

		   ConnectDatabase connectDatabase = new ConnectDatabase();
           connection = connectDatabase.dbConnect();


           statement = connection.createStatement();


           resultSet = statement.executeQuery("SELECT Surname, FirstName, IdNumber, EmplymentNumber, YearOfGrad, Specialisation FROM DOCTOR_TABLE" );


           ResultSetMetaData metaData = resultSet.getMetaData();
           int numberOfColumns = metaData.getColumnCount();
           System.out.println( "DOCTOR_TABLE Table of clinic_system Database:\n" );
           sb.append("DOCTOR_TABLE Table of clinic_system Database:\n");


           resultSet = statement.executeQuery("SELECT Surname, FirstName, IdNumber, Specialisation FROM PATIENT_TABLE" );
           System.out.println( "PATIENT_TABLE Table of clinic_system Database:\n" );
           sb.append("PATIENT_TABLE Table of clinic_system Database:\n");


           resultSet = statement.executeQuery("SELECT Surname, IdNumber, Specialisation, Medication, QUANTITY FROM PATIENT_TABLE" );
           System.out.println( "PATIENT_TABLE Table of clinic_system Database:\n" );
           sb.append("PATIENT_TABLE Table of clinic_system Database:\n");



           /*resultSet = statement.executeQuery("SELECT Surname, IdNumber, Specialisation, FROM DIAGNOSE_TABLE " );
           System.out.println( "DIAGNOSE_TABLE  Table of clinic_system Database:\n" );
           sb.append("DIAGNOSE_TABLE  Table of clinic_system Database:\n");*/



           for ( int i = 1; i <= numberOfColumns; i++ ) {
               System.out.printf("%-8s\t", metaData.getColumnName(i));
               sb.append(metaData.getColumnName(i) + "\t");
           }
           sb.append("\n");
           System.out.println();

            while ( resultSet.next() ) {
                for ( int i = 1; i <= numberOfColumns; i++ ) {
                  sb.append(resultSet.getObject(i) + "\t");
                  System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                sb.append("\n");

                try
                {
                //	output = String.format("%s", (String)resultSet.getObject(1) );
                	record = new RecordClass(Integer.parseInt(output),Integer.parseInt(output),Integer.parseInt(output),(String)resultSet.getObject(1), (String)resultSet.getObject(2), (String)resultSet.getObject(3), Integer.parseInt(output), (String)resultSet.getObject(4));
                      //Integer.valueOf((String) resultSet.getObject(1));
					recordsList.add(record);
                }
                catch (Exception e)
                {
                	System.out.println("failed to retrieve data from database");
                }



                System.out.println();
            }
          // return sb.toString();
          return recordsList;

        }
        	catch (Exception  e)
        		{
                  e.printStackTrace();
        		}
        	finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
          return recordsList;
    }

    //----------------------------end of retrive method-----------------------------

}//end of database connecting class.



//if the count of the arraylist is more than two, populate the first record and set nextButton visible