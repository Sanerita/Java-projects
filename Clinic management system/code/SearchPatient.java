/**
 * @(#)SearchPatient.java
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

public class SearchPatient extends JFrame
{
	private Connection connection=null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    Statement statement;

	private JButton surNameJButton;
	private JButton searchJButton;
	private JButton backJButton;
	private JLabel title;

	private  JTextField surNameJTextField;

	private int nextPatient = 0;

	List<RecordClass> list = new ArrayList<RecordClass>();

    public SearchPatient()
    {
    	super("SEARCH PATIENT");
		setLayout(null);

	    //list = surNameArray;

		this.getContentPane().setBackground(Color.lightGray);

		title=new JLabel("SEARCH PATIENT BY LASTNAME");
		title.setBounds(50,20,180,20);
		add(title);

		surNameJTextField = new JTextField();
        surNameJTextField.setBounds(30,60,180,30);
        add(surNameJTextField);

        searchJButton=new JButton("Search");
		searchJButton.setBounds(30,120,80,25);
		add(searchJButton);

		backJButton=new JButton("Back");
		backJButton.setBounds(130,120,80,25);
		add(backJButton);

		ButtonHandler myHandler=new ButtonHandler();
		searchJButton.addActionListener(myHandler);
		backJButton.addActionListener(myHandler);

    }

    private class ButtonHandler implements ActionListener
		{

			public void actionPerformed(ActionEvent myEvent)
			{

				//------------- if statement------------------------------

		if(myEvent.getSource()==searchJButton)
			{
					String surNname = surNameJTextField.getText();
					if(surNname.equals(null))
					{
					JOptionPane.showMessageDialog(null,"Please enter correct Surname name","Error",JOptionPane.ERROR_MESSAGE);
					}
			else
				{
					dispose();
				  	DiagnoseTable myDiagnoseTable = new DiagnoseTable(surNname);
					myDiagnoseTable.setSize(720,400);
					myDiagnoseTable.setVisible(true);
					myDiagnoseTable.setResizable(false);
					myDiagnoseTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					myDiagnoseTable.setLocationRelativeTo(null);
				}
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


}