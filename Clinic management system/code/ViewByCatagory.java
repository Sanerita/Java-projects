/**
 * @(#)ViewByCatagory.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/15
 */


import javax.swing.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.*;
import javax.swing.table.DefaultTableModel;



public class ViewByCatagory
{
	   String category;

      public ViewByCatagory(String cat)
      {
       category=cat;
      }

	  Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
      private JTextField surNameJTextField;
	  private JTextField firstNameJTextField;
	  private JTextField idNumberJTextField;
	  private JTextField specialisationJTextField;

      DefaultTableModel model = new DefaultTableModel(new String[]{"SURNAME", "FIRST NAME", "ID NUMBER", "SPECIALISATION"}, 0);


  public void getDataFromDatabase()
  {

  }

    public void retrieveFromDb()
    	{
        try {
            StringBuilder sb = new StringBuilder();

		  ConnectDatabase myConnect_Database = new ConnectDatabase();
          connection = myConnect_Database.dbConnect();
          statement = connection.createStatement();
          resultSet = statement.executeQuery("SELECT * FROM PATIENT_TABLE WHERE CategoryName = '"+category+"';" );

         while ( resultSet.next() )
           	{
            	String a = resultSet.getString("Surname");
    			String b = resultSet.getString("FirstName");
    	        int c = resultSet.getInt("IdNumber");
    			Double d= resultSet.getDouble("Specialisation");

    			model.addRow(new Object[]{a, b, c, d});
            }
        }

       	catch (Exception  e)
        		{
                  e.printStackTrace();
        		}
      finally
        {
         try {
                resultSet.close();
                statement.close();
                connection.close();
            }
          catch (Exception exception)
          	{
                exception.printStackTrace();
            }
        }
    }
    public DefaultTableModel getModel()
    {
    	return model;
    }

}//--------------end of class ViewByCategory---------------------------