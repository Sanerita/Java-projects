/**
 * @(#)SpecialisationDatabase.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/13
 */
import javax.swing.*;
import java.sql.*;

public class SpecialisationDatabase
{

    public SpecialisationDatabase()
    {

    }

     public SpecialisationDatabase(int categoryId,String categoryName)
    {

        Connection connection = null;
        Statement statement = null;


        try {

			ConnectDatabase connectDatabase = new ConnectDatabase();

			connection = connectDatabase.dbConnect();

            statement = connection.createStatement();

            statement.executeUpdate("INSERT INTO CATEGORY_TABLE  VALUES ('"+ categoryId + "', '" + categoryName + "');");

             JOptionPane.showMessageDialog(null, ""+categoryName+" is successfully Added ");

        }
        	catch (Exception e)
        		{
                 //e.printStackTrace();
                 JOptionPane.showMessageDialog(null,"CATEGORY ID ALREADY \n IN DATABASE","Error",JOptionPane.ERROR_MESSAGE);
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
                     }
           }
    }


}