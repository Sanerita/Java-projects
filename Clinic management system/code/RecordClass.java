/**
 * @(#)RecordClass.java
 *
 *
 * @author Sileku, 212054058
 * @version 1.00 2018/11/13
 */

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class RecordClass
{
	private int idNumber;
	private String lastName;
	private String firstName;
	private int yearOfGrad;
	private String specialisation;
	private int employNumber;
	private String medication;
	private int quantity;


    private int idNumberArray[] = new int[10];
	private String lastNameArray[] = new String[10];
	private int yearOfGradArray[] = new int[10];
	private String specialisationArray[] = new String[10];
	private int employNumberArray[] = new int[10];
	private String firstNameArray[] = new String[10];
	private int medicationArray[] = new int[10];
	private String quantityArray[] = new String[10];


	private int arrayCounter = 0;


    public RecordClass()
    	{

    	}//null argument constractor


     public RecordClass(int id, int en, int yg, String fn, String ln, String sp, int qt, String md )
    {
    	idNumber = id;
    	employNumber = en;
    	yearOfGrad = yg;
    	firstName = fn;
    	lastName = ln;
    	specialisation = sp;
    	medication = md;
    	quantity = qt;

    }//four argument constructor


 ///////ACCESSORS//////////////////////////////////
     public void setIdNumber(int id)
    {
    	idNumber = id;
    }//--------------------------------------

    public void setFirstName(String fn)
    {
    	firstName = fn;
    }//--------------------------------------

    public void setEmployNumber(int en)
    {
    	employNumber = en;
    }//---------------------------------------

    public void setLastName(String ln)
    {
    	lastName = ln;
    }//----------------------------------------

    public void setYearOfGrad(int yg)
    {
    	yearOfGrad = yg;
    }//----------------------------------------
      public void setSpecialisation(String sp)
    {
    	specialisation = sp;
    }//----------------------------------------

      public void setMedication(String md)
    {
    	medication = md;
    }//--------------------------------------

    public void setQuantity(int qt)
    {
    	quantity = qt;
    }//--------------------------------------



////////////MUTATORS////////////////////////////////

    public int getIdNumber()
    {
    	return idNumber;
    }//--------------------------------------

    public String getFirstName()
    {
    	return firstName;
    }//--------------------------------------

    public int getEmployNumber()
    {
    	return employNumber;
    }//---------------------------------------

    public String getLastName()
    {
    	return lastName;
    }//----------------------------------------

    public int getYearOfGrad()
    {
    	return yearOfGrad;
    }//----------------------------------------

      public String getSpecialisation()
    {
    return specialisation;
    }//----------------------------------------

     public int getQuantity()
    {
    	return quantity;
    }//--------------------------------------

    public String getMedication()
    {
    	return medication;
    }//--------------------------------------



//----------------------------------------------------

		public String toString()
		{
			return String.format("%d %s %d %s %d %s %s %d ", getIdNumber(), getFirstName(), getEmployNumber(),  getLastName(), getYearOfGrad(), getSpecialisation(),getQuantity(),getMedication() );
		}

}