/**
 * @(#)ConnectDatabase.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/13
 */

import javax.swing.*;
import java.sql.*;


public class ConnectDatabase
{

     Connection connection = null;

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost/CLINIC_SYSTEM?autoReconnect=true&useSSL=false";


    public ConnectDatabase()
    {

    }

    public Connection  dbConnect()
    {

    	try
    		{

              Class.forName(JDBC_DRIVER);

              connection = DriverManager.getConnection(DATABASE_URL, "sane", "Tuesday@123");
    	    }

    	   catch (Exception e)
    	   {
    	   		e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Please connect to your database");
    	   }

    	   	return   connection;
    }


}