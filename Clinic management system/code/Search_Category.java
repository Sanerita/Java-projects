/**
 * @(#)Search_Category.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/15
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


public class Search_Category extends JFrame
{
		List<RecordClass> list = new ArrayList<RecordClass>();

	private Connection connection=null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs2 = null;
    Statement statement;

	private JComboBox categoryJList;
	private JButton searchJButton;
	private JButton backJButton;
	private JLabel title;

  public Search_Category()
    {
    	super("SEARCH CATEGORY");
		setLayout(null);

		title=new JLabel("SELECT CATEGORY");
		title.setBounds(50,20,180,20);
		add(title);

		categoryJList = new JComboBox();
        categoryJList.setBounds(30,60,180,30);
        add(categoryJList);
        try {
            populateJComboBox(categoryJList);
        } catch (SQLException ex) {}

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
					String name = categoryJList.getSelectedItem().toString();
					if(name.equals(null))
					{
					JOptionPane.showMessageDialog(null,"Please enter correct category name","Error",JOptionPane.ERROR_MESSAGE);
					}
			else
				{
					dispose();
					Specialisation mySpecialisation=new Specialisation(name);
					mySpecialisation.setSize(730,350);
					mySpecialisation.setResizable(false);
					mySpecialisation.setVisible(true);
					mySpecialisation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					mySpecialisation.setLocationRelativeTo(null);

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

	public void populateJComboBox(JComboBox ItemList) throws SQLException
	{
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

}