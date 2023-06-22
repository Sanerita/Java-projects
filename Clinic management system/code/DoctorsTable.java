/**
 * @(#)DoctorsTable.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/14
 */

import javax.swing.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import javax.*;
import java.awt.*;
import javax.swing.table.*;
import java.awt.*;



public class DoctorsTable extends JFrame
{

   	private JScrollPane scrollPane;
	private JTable recordsTable;
	private JButton back;
	private JButton exit;
	String lastName;


    public DoctorsTable()
    {
    	super("DISPANCE MEDICATION ");
    	setLayout(null);

    	this.getContentPane().setBackground(Color.lightGray);
    	Components();

    	back = new JButton("BACK");
    	back.setBounds(20,280,150,20);
    	add(back);

    	exit = new JButton("EXIT");
    	exit.setBounds(550,280,150,20);
    	add(exit);

    	ButtonHandler myHandler=new ButtonHandler();
		exit.addActionListener(myHandler);
		back.addActionListener(myHandler);


    }

     public void Components()
    {
    	View_doctors data = new View_doctors();
    	data.retrieveFromDb();
    	recordsTable = new JTable();
    	recordsTable.setEnabled(false);
    	recordsTable.setVisible(true);
    	recordsTable.setModel(data.getModel());
    	scrollPane = new JScrollPane(recordsTable);
    	scrollPane.setBounds(20,20, 680, 250);
    	scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setAutoscrolls(true);
    	add(scrollPane);
    }
     	private class ButtonHandler implements ActionListener
		{

			public void actionPerformed(ActionEvent myEvent)
			{

	//--------------------if statement----------------------//

				if(myEvent.getSource()==exit)
				{
				System.exit(0);
				}

			else if(myEvent.getSource()==back)
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



}