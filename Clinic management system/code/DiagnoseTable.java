/**
 * @(#)DiagnoseTable.java
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
import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.Color;
import java.util.ArrayList;

public class DiagnoseTable extends JFrame
{
	  Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
    private JTextField nameJTextField;
	private JTextField surNameJTextField;
	private JComboBox specialisationJTextField;
	private JTextField idNumberJTextField;
    private JButton exitJButton;
    private JButton backJButton;
    private JButton saveJButton;
    private JTextField quantityJTextField;
	private JTextField medicineJTextField;
	private JScrollPane scrollPane;
   	private JTable recordsTable;
	private int quantity;
	private String medication;

	private int idNumber;
	private String lastName;
	private String firstName;
	private int yearOfGrad;
	private String specialisation;
	private int employNumber;
	private String a;
	private int b;
	private String c;

    DefaultTableModel model = new DefaultTableModel(new String[]{"SURNAME", "ID NUMBER", "SPECIALISATION"}, 0);

      public void DiagnoseTable()
        {

        }
	private int nextPatient = 0;

	String list;


    public DiagnoseTable(String DiagnoseArray)
    {
    		super("DISPANSE MEDICATION");
    		setLayout(null);

	       list = DiagnoseArray;


    		this.getContentPane().setBackground(Color.lightGray);


			medicineJTextField=new JTextField();
			medicineJTextField.setBounds(20,280,150,40);
			medicineJTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Medication", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
			add(medicineJTextField);

			quantityJTextField=new JTextField();
			quantityJTextField.setBounds(200,280,150,40);
			quantityJTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quantity", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP));
			add(quantityJTextField);



			saveJButton = new JButton("SAVE");
    		saveJButton.setBounds(20,340,150,20);
    		add(saveJButton);

    		backJButton = new JButton("BACK");
    		backJButton.setBounds(200,340,150,20);
    		add(backJButton);

    		exitJButton = new JButton("EXIT");
    		exitJButton.setBounds(400,340,150,20);
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
		saveJButton.addActionListener(myHandler);


    }//end of constructor


    	private class ButtonHandler implements ActionListener
		{

			public void actionPerformed(ActionEvent myEvent)
			{

	//-------------------------- if statement-------------------------

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

	       else if(myEvent.getSource() == saveJButton)
		        {
			       RecordClass myRecordClass = new RecordClass();
				 try
				{

				 //lastName = surNameJTextField.getText();
				// firstName = nameJTextField.getText();
				// specialisation =specialisationJTextField.getSelectedItem().toString();
				 //idNumber = Integer.parseInt(idNumberJTextField.getText());
				  quantity = Integer.parseInt(quantityJTextField.getText());
				  medication = medicineJTextField.getText();

                 PatientDatabase data = new PatientDatabase();

				/*if(!surNameJTextField.getText().substring(0,1).matches("[A-Z]"))
				{
					JOptionPane.showMessageDialog(null,"please enter a correct surname","Error",JOptionPane.ERROR_MESSAGE);

				}*/

					 DiagnoseDatabase myPatientDatabase = new DiagnoseDatabase(list, a, b,  c, medication, quantity );




				}
				catch(NumberFormatException ex)
				{
				JOptionPane.showMessageDialog(null,"Please ensure all your details are correct","Error",JOptionPane.ERROR_MESSAGE);
				}

				}


            }
	}


     public void retrieveFromDb()
    	{
        try {
            StringBuilder sb = new StringBuilder();

		    ConnectDatabase myConnect_Database = new ConnectDatabase();

            connection = myConnect_Database.dbConnect();
            statement = connection.createStatement();

           resultSet = statement.executeQuery("SELECT * FROM PATIENT_TABLE where Surname = '"+list+"';");


            if ( resultSet.next() )
            	{
            		 a= resultSet.getString("Surname");
            		 b = resultSet.getInt("IdNumber");
    				 c = resultSet.getString("Specialisation");
    				//String d = resultSet.getString("Medication");
    				//int e = resultSet.getInt("Quantity");


    				model.addRow(new Object[]{a, b, c});
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