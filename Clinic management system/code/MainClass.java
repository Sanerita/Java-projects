/**
 * @(#)MainClass.java
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


public class MainClass extends JFrame
{
 public static void main(String[] args)
    {
   	try
		{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		MainGui myMainGui = new MainGui();//instantiating the main gui class
		myMainGui.setSize(400,250);//this sets the length and the height of the frame
		myMainGui.setVisible(true);//this makes the GUI Frame to be visible
		myMainGui.setResizable(false);//this closes the program once the user clicks the close
		myMainGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this positions the frame to be at the centre of the screen
		myMainGui.setLocationRelativeTo(null);// this set GUI not to be espanded

		}

    catch(Exception nm)

    	{
			nm.printStackTrace();
		}
    }
}//----------------------end of class Main_Class-------------------------------




