/**
 * @(#)View_patientGui.java
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

public class View_patientGui extends JFrame
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
    private JScrollPane scrollPane;
   	private JTable recordsTable;


	private int nextPatient = 0;

	List<RecordClass> list = new ArrayList<RecordClass>();


      DefaultTableModel model = new DefaultTableModel(new String[]{"SURNAME", "FIRST NAME", "ID NUMBER", "SPECIALISATION"}, 0);

     public void doctors()
    {

    }

    public View_patientGui(List<RecordClass> patientArray)
    {
    	super("PATIENT DETAILS");
    	setLayout(null);

    		list = patientArray;

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
		backJButton.addActionListener(myHandler);
		exitJButton.addActionListener(myHandler);


    }//end of constructor


    private class ButtonHandler implements ActionListener

{

			public void actionPerformed(ActionEvent myEvent)
			{

				//**************nested if statement*******************

				if(myEvent.getSource()==backJButton)
				{
	            	dispose();
					PatientGui myPatientGui=new PatientGui();
					myPatientGui.setSize(310,350);
					myPatientGui.setResizable(false);
					myPatientGui.setVisible(true);
					myPatientGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					myPatientGui.setLocationRelativeTo(null);

				}

				else if(myEvent.getSource()==exitJButton)
				{
				System.exit(0);
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

           resultSet = statement.executeQuery("SELECT * FROM PATIENT_TABLE" );


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


}//end of View_patientGui class