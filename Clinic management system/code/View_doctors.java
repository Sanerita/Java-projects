/**
 * @(#)View_doctors.java
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

public class View_doctors extends JFrame
{
	  String lastName;
	  private JScrollPane scrollPane;
   	  private JTable recordsTable;



    public void doctors()
    {
//    lastName = ln;

    }//end of constructor

     Connection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
    private JTextField nameJTextField;
	private JTextField surNameJTextField;
	private JComboBox specialisationJTextField;
	private JTextField idNumberJTextField;
    private JButton exitJButton;
    private JButton backJButton;
    private int yearOfGrad;
	private int employNumber;

	RecordClass myRecordClass = new RecordClass();


 DefaultTableModel model = new DefaultTableModel(new String[]{"SURNAME", "FIRST NAME", "ID NUMBER","EMPLOYMENT NUMBER", "YEAR OF GRAD","SPECIALISATION"}, 0);

 public View_doctors()
    {
    	super("DOCTORS REGISTERD ");
    	setLayout(null);

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
    	scrollPane.setBounds(20,20,740, 250);
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

				//**************nested if statement*******************

				if(myEvent.getSource()==backJButton)
				{
	            	dispose();
					DoctorGui myDoctorGui=new DoctorGui();
					myDoctorGui.setSize(310,440);
					myDoctorGui.setResizable(false);
					myDoctorGui.setVisible(true);
					myDoctorGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					myDoctorGui.setLocationRelativeTo(null);

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

		    ConnectDatabase myConnect_Database = new ConnectDatabase();

            connection = myConnect_Database.dbConnect();
            statement = connection.createStatement();

           resultSet = statement.executeQuery("SELECT * FROM DOCTOR_TABLE" );


            while ( resultSet.next() )
            	{
            		String a= resultSet.getString("Surname");
    				String b = resultSet.getString("FirstName");
    				int c = resultSet.getInt("IdNumber");
    				int d = resultSet.getInt("EmplymentNumber");
    				int e = resultSet.getInt("YearOfGrad");
    				String f = resultSet.getString("Specialisation");


    				model.addRow(new Object[]{a, b, c, d, e, f});
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
