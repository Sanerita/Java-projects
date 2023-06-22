/**
 * @(#)DiagnoseGui.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/14
 */

import javax.swing.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.Color;
import javax.*;
import java.awt.*;
import javax.swing.table.*;

public class DiagnoseGui extends JFrame
{
    private JScrollPane scrollPane;
	private JTable recordsTable;
	private JButton backJButton;
	private JButton exitJButton;
	String lastName;


	 public void DiagnoseGui()
    {
        // lastName = ln;

    }

     Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
    private JTextField nameJTextField;
	private JTextField surNameJTextField;
	private JComboBox specialisationJTextField;
	private JTextField idNumberJTextField;

    DefaultTableModel model = new DefaultTableModel(new String[]{"SURNAME"}, 0);



     public DiagnoseGui()
    {
    	super("DISPANCE MEDICATION ");
    	setLayout(null);

    	this.getContentPane().setBackground(Color.lightGray);

    	backJButton = new JButton("BACK");
    	backJButton.setBounds(20,280,150,20);
    	add(backJButton);

    	exitJButton = new JButton("EXIT");
    	exitJButton.setBounds(550,280,150,20);
    	add(exitJButton);

    	//DiagnoseGui data = new DiagnoseGui(lastName);
    	retrieveFromDb();
    	recordsTable = new JTable();
    	recordsTable.setEnabled(false);
    	recordsTable.setVisible(true);
    	getDataFromDatabase();
    	recordsTable.setModel(getModel());
    	scrollPane = new JScrollPane(recordsTable);
    	scrollPane.setBounds(20,20, 680, 250);
    	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setAutoscrolls(true);
    	add(scrollPane);

    	ButtonHandler myHandler=new ButtonHandler();
		exitJButton.addActionListener(myHandler);
		backJButton.addActionListener(myHandler);

    }

    	private class ButtonHandler implements ActionListener
		{

			public void actionPerformed(ActionEvent myEvent)
			{

	//--------------------if statement----------------------//

				if(myEvent.getSource()==exitJButton)
				{
				System.exit(0);
				}

			else if(myEvent.getSource()==backJButton)
				{
				  	dispose();
				  	SearchPatient mySearchPatient = new SearchPatient();
					mySearchPatient.setSize(300,350);
					mySearchPatient.setVisible(true);
					mySearchPatient.setResizable(false);
					mySearchPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mySearchPatient.setLocationRelativeTo(null);

				}
			}

	}



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
           resultSet = statement.executeQuery("SELECT * FROM PATIENT_TABLE WHERE Surname = '" + lastName + "'" );


        if ( resultSet.next() )
           	{
           		    String a= resultSet.getString("Lastname");
            	    int b = resultSet.getInt("IdNumber");
    				String c = resultSet.getString("Specialisation");
    				String d= resultSet.getString("Medication");
            	    int e = resultSet.getInt("QUANTITY");



    				model.addRow(new Object[]{a, b, c, d,e});
            }
        }
       	catch (Exception  e)
        	{
                e.printStackTrace();
        	}
       	finally {
           try
           	 {
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



}