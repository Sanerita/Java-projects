/**
 * @(#)Specialisation.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/13
 */
 import javax.swing.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;


public class Specialisation extends JFrame
{

   	private JScrollPane scrollPane;
	private JTable recordsTable;
	private JButton backJButton;
	private JButton exitJButton;
	String category;


	  Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
    private JTextField nameJTextField;
	private JTextField surNameJTextField;
	private JComboBox specialisationJTextField;
	private JTextField idNumberJTextField;
	private String specialization = null;

  DefaultTableModel model = new DefaultTableModel(new String[]{"SURNAME", "FIRST NAME", "ID NUMBER", "SPECIALISATION"}, 0);


    public Specialisation(String category)
    {
    		super("PATIENTS RECORDED");
    		setLayout(null);

    		specialization = category;

    		this.getContentPane().setBackground(Color.lightGray);

    		backJButton = new JButton("BACK");
    		backJButton.setBounds(20,280,150,20);
    		add(backJButton);

    		exitJButton = new JButton("EXIT");
    		exitJButton.setBounds(550,280,150,20);
    		add(exitJButton);

        retrieveFromDb();
    	recordsTable = new JTable();
    	recordsTable.setEnabled(false);
    	recordsTable.setVisible(true);
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

				//---------- if statement------------------------

				if(myEvent.getSource()==exitJButton)
				{
				System.exit(0);
				}

				else if(myEvent.getSource()==backJButton)
				{

				  	dispose();

		MainGui myMainGui = new MainGui();//instantiating the main gui class
		myMainGui.setSize(400,250);//this sets the length and the height of the frame
		myMainGui.setVisible(true);//this makes the GUI Frame to be visible
		myMainGui.setResizable(false);//this closes the program once the user clicks the close
		myMainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this positions the frame to be at the centre of the screen
		myMainGui.setLocationRelativeTo(null);// this set GUI not to be espanded


				}
			}

	}

     public void retrieveFromDb()
    	{
        try {
            StringBuilder sb = new StringBuilder();

		    ConnectDatabase myConnectDatabase = new ConnectDatabase();

            connection = myConnectDatabase.dbConnect();
            statement = connection.createStatement();

           resultSet = statement.executeQuery("SELECT * FROM PATIENT_TABLE WHERE Specialisation = '"+specialization+"';" );


            while ( resultSet.next() )
            	{
            		String a= resultSet.getString("SurName");
            	    String b = resultSet.getString("FirstName");
    				int c = resultSet.getInt("IdNumber");
    				String d = resultSet.getString("Specialisation");



    				model.addRow(new Object[]{a, b, c, d});
            }
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
    }
    public DefaultTableModel getModel()
    {
    	return model;
    }

}