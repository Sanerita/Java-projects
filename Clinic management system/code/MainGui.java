/**
 * @(#)MainGui.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/12
 */

import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.List;
import java.awt.Color;


public class MainGui extends JFrame
{
	private JButton doctorsJButton;
	private JButton patientsJButton;
	private JButton exitJButton;
	private JButton specialisationJButton;
	private JButton diagnoseJButton;
	private JButton dispanceJButton;



    public MainGui()
    {
    	super("CLINIC SYSTEM");
    	setLayout(null);



		doctorsJButton=new JButton("ADD DOCTORS");
		doctorsJButton.setBounds(30,20,140,40);
		add(doctorsJButton);

		patientsJButton=new JButton("ADD PATIENTS");
		patientsJButton.setBounds(210,20,140,40);
		add(patientsJButton);

		specialisationJButton=new JButton("VIEW PATIENTS BY CATEGORY");
		specialisationJButton.setBounds(30,80,140,40);
		add(specialisationJButton);

		diagnoseJButton=new JButton("DIAGNOSE");
		diagnoseJButton.setBounds(210,80,140,40);
		add(diagnoseJButton);

		dispanceJButton=new JButton("DISPANCE");
		dispanceJButton.setBounds(30,140,140,40);
		add(dispanceJButton);


		exitJButton=new JButton("EXIT");
		exitJButton.setBounds(210,140,80,40);
		add(exitJButton);

    //----------Instantiating the Button Group----------------------------------------


		ButtonHandler myHandler=new ButtonHandler();
		doctorsJButton.addActionListener(myHandler);
		patientsJButton.addActionListener(myHandler);
		exitJButton.addActionListener(myHandler);
		specialisationJButton.addActionListener(myHandler);
		dispanceJButton.addActionListener(myHandler);
	    diagnoseJButton.addActionListener(myHandler);


      }//end of constructor


    //********************ButtonHandler*************************

private class ButtonHandler implements ActionListener
{

			public void actionPerformed(ActionEvent myEvent)
			{

				//**************nested if statement*******************

				if(myEvent.getSource()==exitJButton)
				{
				System.exit(0);
				}



				else if(myEvent.getSource()==doctorsJButton)
				{
					dispose();
				  	DoctorGui myDoctorGui=new DoctorGui();
					myDoctorGui.setSize(310,440);
					myDoctorGui.setResizable(false);
					myDoctorGui.setVisible(true);
					myDoctorGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					myDoctorGui.setLocationRelativeTo(null);

				}



				else if(myEvent.getSource()==patientsJButton)
				{
					dispose();
					PatientGui myPatientGui=new PatientGui();
					myPatientGui.setSize(310,350);
					myPatientGui.setResizable(false);
					myPatientGui.setVisible(true);
					myPatientGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					myPatientGui.setLocationRelativeTo(null);

				}



				else if(myEvent.getSource()==specialisationJButton)
				{

					dispose();
					Search_Category mySearch_Category=new Search_Category();
					mySearch_Category.setSize(330,350);
					mySearch_Category.setResizable(false);
					mySearch_Category.setVisible(true);
					mySearch_Category.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					mySearch_Category.setLocationRelativeTo(null);


				}


				else if(myEvent.getSource()==diagnoseJButton)
				{
					dispose();
				  	SearchPatient mySearchPatient = new SearchPatient();
					mySearchPatient.setSize(300,350);
					mySearchPatient.setVisible(true);
					mySearchPatient.setResizable(false);
					mySearchPatient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					mySearchPatient.setLocationRelativeTo(null);

				}

	            else if(myEvent.getSource()==dispanceJButton)
				{
					dispose();
				  	DispanseGui myDispanseGui = new DispanseGui();
					myDispanseGui.setSize(760,350);
					myDispanseGui.setVisible(true);
					myDispanseGui.setResizable(false);
					myDispanseGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					myDispanseGui.setLocationRelativeTo(null);

				}



		}

}

}





