/**
 * @(#)DoctorGui.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/13
 */
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.JFrame;
import java.util.List;
import java.sql.*;
import java.awt.Color;

public class DoctorGui extends JFrame
{
	RecordClass myRecordClass = new RecordClass();

	private int idNumber;
	private String lastName;
	private String firstName;
	private int yearOfGrad;
	private String specialisation;
	private int employNumber;


		// ------------------JLabel-----------------

	private JLabel nameJLabel;
	private JLabel surNameJLabel;
	private JLabel specialisationJLabel;
	private JLabel idNumberJLabel;
	private JLabel employmentJLabel;
	private JLabel yearOfGradJLabel;

	//-------------------JText field-------------

	private JTextField nameJTextField;
	private JTextField surNameJTextField;
	private JComboBox specialisationJTextField;
	private JTextField idNumberJTextField;
	private JTextField employmentJTextField;
	private JTextField yearOfGradJTextField;


	//------------------JButtons-----------------

    private JButton saveJButton;
	private JButton clearJButton;
	private JButton exitJButton;
	private JButton viewJButton;

    public DoctorGui()
    {
    	super("DOCTOR REGISTRSTION");
    	setLayout(null);

    		this.getContentPane().setBackground(Color.lightGray);


    	//--------Instantiating and populating Labels--------------------------

		nameJLabel = new JLabel("NAME");
		nameJLabel.setBounds(10,20,100,25);
		add(nameJLabel);

		surNameJLabel = new JLabel("SURNAME");
		surNameJLabel.setBounds(10,70,100,25);
		add(surNameJLabel);

		specialisationJLabel = new JLabel("SPECIALISATION");
		specialisationJLabel.setBounds(10,110,100,25);
		add(specialisationJLabel);

		idNumberJLabel = new JLabel("ID NUMBER");
		idNumberJLabel.setBounds(10,150,100,25);
		add(idNumberJLabel);

		employmentJLabel = new JLabel("EMPLOYMENT#");
		employmentJLabel.setBounds(10,190,100,25);
		add(employmentJLabel);

		yearOfGradJLabel = new JLabel("YEAR OF GRAD");
		yearOfGradJLabel.setBounds(10,230,100,25);
		add(yearOfGradJLabel);

		//--------- populating the TextFields-----------------------

		nameJTextField = new JTextField();
		nameJTextField.setBounds(150,20,100,25);
		add(nameJTextField);

		surNameJTextField = new JTextField();
		surNameJTextField.setBounds(150,70,100,25);
		add(surNameJTextField);

		specialisationJTextField = new JComboBox();
        specialisationJTextField.setBounds(150,110,100,25);
        add(specialisationJTextField);
       try
        {
           populateJComboBox(specialisationJTextField);
        }
        catch (SQLException ex) {}

		idNumberJTextField = new JTextField();
		idNumberJTextField.setBounds(150,150,100,25);
		add(idNumberJTextField);

		employmentJTextField = new JTextField();
		employmentJTextField.setBounds(150,190,100,25);
		add(employmentJTextField);

		yearOfGradJTextField = new JTextField();
		yearOfGradJTextField.setBounds(150,230,100,25);
		add(yearOfGradJTextField);


		//-------and populating the Buttons--------------------

		saveJButton=new JButton("SAVE");
		saveJButton.setBounds(10,330,80,30);
		add(saveJButton);

		clearJButton=new JButton("CLEAR");
		clearJButton.setBounds(110,330,80,30);
		add(clearJButton);


		exitJButton=new JButton("EXIT");
		exitJButton.setBounds(210,330,80,30);
		add(exitJButton);

		viewJButton = new JButton("VIEW DOCTORS");
		viewJButton.setBounds(100,280,110,20);
		add(viewJButton);


    	ButtonHandler myHandler=new ButtonHandler();
    	exitJButton.addActionListener(myHandler);
		saveJButton.addActionListener(myHandler);
		clearJButton.addActionListener(myHandler);
		viewJButton.addActionListener(myHandler);


    }//end of constructor


public void populateJComboBox(JComboBox ItemList) throws SQLException
	{
    	Connection connection = null;
        ResultSet rs = null;
        PreparedStatement pst = null;
        ResultSet rs2 = null;
        Statement statement;


    String query = "select CategoryName from CATEGORY_TABLE";
	ConnectDatabase connectDatabase = new ConnectDatabase();
	connection = connectDatabase.dbConnect();
    statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(query); //run your query

    while (resultSet.next()) //go through each row that your query returns
    {
        String ItemList2 = resultSet.getString("CategoryName"); //get the element in column "item_code"
        ItemList.addItem(ItemList2);
    }

    resultSet.close();
    statement.close();
	}


 private class ButtonHandler implements ActionListener

{

			public void actionPerformed(ActionEvent myEvent)
			{

				//**************nested if statement*******************

				if(myEvent.getSource()==exitJButton)
				{
              	 dispose();
			     MainGui myMainGui = new MainGui();//instantiating the main gui class
	           	 myMainGui.setSize(400,250);//this sets the length and the height of the frame
		         myMainGui.setVisible(true);//this makes the GUI Frame to be visible
		         myMainGui.setResizable(false);//this closes the program once the user clicks the close
		         myMainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this positions the frame to be at the centre of the screen
		         myMainGui.setLocationRelativeTo(null);// this set GUI not to be espanded


				}



				else if(myEvent.getSource()==saveJButton)
				{
                  RecordClass myRecordClass = new RecordClass();
				 try
				{

				 lastName = surNameJTextField.getText();
				 firstName = nameJTextField.getText();
				 idNumber = Integer.parseInt(idNumberJTextField.getText());
				 employNumber = Integer.parseInt(employmentJTextField.getText());
				 yearOfGrad = Integer.parseInt(yearOfGradJTextField.getText());
				 specialisation =specialisationJTextField.getSelectedItem().toString();

                 DoctorDatabase data = new DoctorDatabase();

				if(!surNameJTextField.getText().substring(0,1).matches("[A-Z]"))
				{
					JOptionPane.showMessageDialog(null,"please enter a correct surname","Error",JOptionPane.ERROR_MESSAGE);

				}
				else
				{
					 DoctorDatabase myDoctorDatabase = new DoctorDatabase(lastName, firstName, idNumber, employNumber ,yearOfGrad , specialisation);
				}




				}
				catch(NumberFormatException ex)
				{
				JOptionPane.showMessageDialog(null,"Please ensure all your details are correct","Error",JOptionPane.ERROR_MESSAGE);
				}

				}





				else if(myEvent.getSource()==clearJButton)
				{
                   nameJTextField.setText(null);
	               surNameJTextField.setText(null);
	               idNumberJTextField.setText(null);
	               employmentJTextField.setText(null);
                   yearOfGradJTextField.setText(null);


				}

				else if(myEvent.getSource()==viewJButton)
				{
					dispose();
					View_doctors myView_doctors = new View_doctors();
					myView_doctors.setSize(760,350);
					myView_doctors.setResizable(false);
					myView_doctors.setVisible(true);
					myView_doctors.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					myView_doctors.setLocationRelativeTo(null);


				}

			}
}

}