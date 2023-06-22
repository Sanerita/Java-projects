/**
 * @(#)PatientDatabase.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/13
 */
import javax.swing.*;
import java.sql.*;

public class PatientDatabase
{

    public PatientDatabase()
    {

    }


    public PatientDatabase( String lastName, String firstName, int idNumber, String specialisation )
    {

        Connection connection = null;
        Statement statement = null;


        try {

			ConnectDatabase connectDatabase = new ConnectDatabase();

			connection = connectDatabase.dbConnect();

            statement = connection.createStatement();


            statement.executeUpdate("INSERT INTO PATIENT_TABLE (Surname, FirstName, IdNumber, Specialisation) VALUES ('" + lastName + "', '" +firstName + "','" + idNumber + "','" + specialisation + "' );");

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