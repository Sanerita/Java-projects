/**
 * @(#)DiagnoseDatabase.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/14
 */


import javax.swing.*;
import java.sql.*;

public class DiagnoseDatabase
{

    public DiagnoseDatabase()
    {

    }

    public DiagnoseDatabase(String lastName, String firstName, int idNumber, String specialisation , String medication, int quantity)
    {

        Connection connection = null;
        Statement statement = null;


        try {

			ConnectDatabase connectDatabase = new ConnectDatabase();

			connection = connectDatabase.dbConnect();

            statement = connection.createStatement();


            statement.executeUpdate("INSERT INTO DIAGNOSE_TABLE ( Surname, IdNumber, Specialisation, Medication, QUANTITY ) VALUES ('" + lastName + "', '" + idNumber + "','" + specialisation + "','" + medication + "','" + quantity + "' );");


            JOptionPane.showMessageDialog(null, "Details inserted successfully into database");

        }
        	catch (Exception e)
        		{
                  e.printStackTrace();
         		}

         	finally
         		{
                  try {
                		statement.close();
                		connection.close();
            		  }

                  catch (Exception exception)
            	     {
                       exception.printStackTrace();
                         System.out.print("error");
                     }
                }

    }


}