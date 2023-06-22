/**
 * @(#)DispanseGui.java
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

public class DispanseGui extends JFrame
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
     private JButton dispanceJButton;
    private JScrollPane scrollPane;
   	private JTable recordsTable;


	private int idnum;

	List<RecordClass> list = new ArrayList<RecordClass>();


      DefaultTableModel model = new DefaultTableModel(new String[]{"SURNAME", "ID NUMBER", "SPECIALISATION", "MEDICATION", "QUANTITY"}, 0);

     public void doctors()
    {

    }

    public DispanseGui()
    {
    	super("PATIENT DETAILS");
    	setLayout(null);

        this.getContentPane().setBackground(Color.lightGray);


    	backJButton = new JButton("BACK");
    	backJButton.setBounds(20,280,150,20);
    	add(backJButton);

    	exitJButton = new JButton("EXIT");
    	exitJButton.setBounds(550,280,150,20);
    	add(exitJButton);

    	dispanceJButton = new JButton("DISPANSE");
    	dispanceJButton.setBounds(280,280,150,20);
    	add(dispanceJButton);


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
		dispanceJButton.addActionListener(myHandler);



    }//end of constructor


    private class ButtonHandler implements ActionListener

{

			public void actionPerformed(ActionEvent myEvent)
			{

				//**************nested if statement*******************

				if(myEvent.getSource()==backJButton)
				{
	            	dispose();
		MainGui myMainGui = new MainGui();//instantiating the main gui class
		myMainGui.setSize(400,250);//this sets the length and the height of the frame
		myMainGui.setVisible(true);//this makes the GUI Frame to be visible
		myMainGui.setResizable(false);//this closes the program once the user clicks the close
		myMainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this positions the frame to be at the centre of the screen
		myMainGui.setLocationRelativeTo(null);// this set GUI not to be espanded

				}

				else if(myEvent.getSource()==exitJButton)
				{
				System.exit(0);
				}

				else if(myEvent.getSource()==dispanceJButton)
				{
						try
					{
						Statement statement = connection.createStatement();
						statement.executeUpdate("delete from DIAGNOSE_TABLE where idNumber = ('" + idnum + "');");
						JOptionPane.showMessageDialog(null, "The patient can now collect the meddication","Dispansed", JOptionPane.INFORMATION_MESSAGE);
					}catch(SQLException ex){System.out.println(ex);}

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

           resultSet = statement.executeQuery("SELECT * FROM DIAGNOSE_TABLE" );


            while ( resultSet.next() )
            	{
            		String a= resultSet.getString("SurName");
            	    //String b = resultSet.getString("FirstName");
    				int b = resultSet.getInt("IdNumber");
    				String c = resultSet.getString("Specialisation");
    				String d= resultSet.getString("Medication");
    				int e = resultSet.getInt("Quantity");
						idnum= resultSet.getInt("IdNumber");


    				model.addRow(new Object[]{a, b, c, d, e});
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
                //connection.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    public DefaultTableModel getModel()
    {
    	return model;
    }


}//end of DispanseGui class