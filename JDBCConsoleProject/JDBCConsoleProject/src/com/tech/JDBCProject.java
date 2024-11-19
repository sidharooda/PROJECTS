
package com.tech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Project Name : JDBCconsole Project
 * Description : The main purpose of this project is to explore 
 *               JDBC apis for performing DML operations. 
 */
public class JDBCProject {
	public static int count=1;
	public static void main(String[] args) {
		//call creating function - so that it create table
		Dao d=new Dao();
		/*
		 * lets ask use for input
		 */
		Scanner sc=new Scanner(System.in);//in this we are importing scanner class
		int option=0;
		System.out.println("----JDBC CONSOLE PROJECT WELCOMES YOU----\n");
		do
		{
			System.out.println("-----CHOOSE CORRECT OPTION-----");
			System.out.println("0   :exit");
			System.out.println("1   :create a table");
			System.out.println("2   :insert data into a table");
			System.out.println("3   :update a row based on eno");
			System.out.println("4   :delete a row based on eno");
			System.out.println("5   :display employee records");
			System.out.println("6   :displey record based on eno");
			option=sc.nextInt(); //what ever user enter goes to option variable
			switch(option)
			{
			case 1:
				if(count==1)
				{
					d.creatingTable();  //in this case we are creating a table
					count++;
				}
				else
				{
					System.out.println("YOU CANT CREATE TABLE MULTIPLE TIMES");
				}
				break;
			case 2:
				System.out.println("enter eno,ename,esalary sequentially");
				int enumber=sc.nextInt();
				sc.nextLine();
				String ename=sc.nextLine();
				int esalary=sc.nextInt();
				d.inserting(enumber, ename, esalary); //in this case we are inserting values into emp table
				break;
			case 3:
				//we have to read eno and esalary from salary
				System.out.println("enter eno and new salary");
				int enumber1=sc.nextInt();
				int newsalary=sc.nextInt();
				d.updating(enumber1, newsalary); //in this case we are updating salary based on enumber
				                                 //taking eno and new salary from keyboard
				break;
			case 4:
				System.out.println("enter enumber");
				int enumber2=sc.nextInt();
				d.deleting(enumber2); //in this case we are deleting a record based on enumber
				break;
			case 5:
				d.displaying(); //in this case we are displaying all the emp table data
				break;
			case 6:
				System.out.println("enter enumber");
				int enumber3=sc.nextInt();
				d.displaySingleRow(enumber3); //in this case we are reading single row based on enumber
				break;
			case 0:
				System.out.println("OK IAM EXITING");
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} //this case is used to exiting from operations
				return;
				
				
			}
			
		}
		while(option!=0);
		{
			System.out.println("1   : creating a table");
			System.out.println("2   : inserting into table");
			System.out.println("3   : updating a row table");
			System.out.println("4   : deleting a row of table");
			System.out.println("5   : read one row");
			System.out.println("6   : read all rows");
			System.out.println("0   : exit");
		}
		sc.close();
		
//		d.creatingTable();
//	d.inserting(1,"ramesh",40000); //this will insert first employee
//		d.inserting(2,"suresh",50000); //this will insert second employee
//		d.updating(1,65000); //this will update 1st emloyee salary to 65000
//		d.deleting(1);       //this will deleteb 2nd employee details
//		d.displaying();      //this will display all rows from employee table
//		 d.displaySingleRow(2); //this will display one row  from employee table based on employee number
	}

}

 /*
  * let us take another class for JDBC code 
  * class name : DAO - data access object - DAO layout
  *                 in this class we are going to write code for 5 operations 
  */
class Dao
{
	//in this method we will create employee table
	public void creatingTable()
	{
		Connection c =null;
		Statement  s  =null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Ksiddu0575@");
			 s=c.createStatement();
			s.executeUpdate("create table employee (employee_number int primary key,employee_name varchar(40),employee_salary int);");
		}
		catch (ClassNotFoundException e) {
			System.out.println("DRIVER IS NOT PROPERLY LOADED");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG WITH DATABASE");
			e.printStackTrace();
		}
		finally
		{
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//in this below method we will insert data into employee table
	public void inserting(int eno,String ename,int esalary)
	{
		Connection c= null;
		PreparedStatement s= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Ksiddu0575@");
			String query="insert into employee values (?,?,?)";
			s=c.prepareStatement(query);
			s.setInt(1, eno);
			s.setString(2,ename);
			s.setInt(3,esalary);
			s.executeUpdate();
			System.out.println("SUCCESSFULLY INSERTED A ROW...");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("DRIVER IS NOT LOADED PROPERLY");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG WITH DATABASE");
			e.printStackTrace();
		}
		catch(Exception e)
		{
			//if some unknown exception occurs this catch block will execute 
			System.out.println("SOMETHING UNUSUAL THING HAPPENED");
		}
		finally
		{
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		}
	//in this below method we will update.. for a given eno update new salary
	public void updating(int eno,int newsal)
	{
		Connection c = null;
		PreparedStatement s= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Ksiddu0575@");
			String query="update employee set employee_salary=? where employee_number=?";
			s=c.prepareStatement(query);
			s.setInt(1, newsal);
			s.setInt(2,eno);
			s.executeUpdate();
			System.out.println("RECORD UPDATED SUCCESSFULLY...");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("DRIVER IS NOT PROPERLY LOADED");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG WITH DATABASE");
			e.printStackTrace();
		}
		finally
		{
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//in this below method we will delete a row based on employee number
	public void deleting(int eno)
	{
		Connection c= null;
		PreparedStatement s=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Ksiddu0575@");
			String query="delete from employee where employee_number=?";
			s=c.prepareStatement(query);
			s.setInt(1, eno);
			s.executeUpdate();
			System.out.println("DELETED A RECORD SUCCESSFULLY...");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("DRIVER IS NOT PROPERLY LOADED");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG WITH DATABASE");
			e.printStackTrace();
		}
		finally
		{
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	//in this below method we will read all employees and display their details
	public void displaying()
	{
		Connection c=null;
		Statement s=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Ksiddu0575@");
			s=c.createStatement();
			ResultSet r=s.executeQuery("select * from employee");
			System.out.println("/n-----EMPLOYEE TABLE DATA BELOW-----/n");
			System.out.println("ENO   ENAME   ESALARY");
			System.out.println("---   -----   -------");
			while(r.next()==true)
			{
				System.out.println(r.getInt(1)+"   "+r.getString(2)+"    "+r.getInt(3));
			}
			System.out.println("--------------------------");
		} 
		catch (ClassNotFoundException e) {
			System.out.println("DRIVER IS NOT LOADED PROPERLY");
			e.printStackTrace();
		}
		catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG WITH DATABASE");
			e.printStackTrace();
		}
		finally
		{
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	//in this below method we will read one employee  and display their details
	public void displaySingleRow(int eno)
	{
		Connection c=null;
		PreparedStatement s=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","Ksiddu0575@");
			String query="select * from employee where employee_number=?";
			s=c.prepareStatement(query);
			s.setInt(1, eno);
			ResultSet r=s.executeQuery();
			if(r.next())
			{
			System.out.println(r.getInt(1)+"  "+r.getString(2)+"   "+r.getInt(3));
			}
		} 
		catch (ClassNotFoundException e) {
			System.out.println("CLASS NOT LOADED PROPERLY");
			e.printStackTrace();
		} 
		catch (SQLException e) {
			System.out.println("SOMETHING WENT WRONG WITH DATABASE");
			e.printStackTrace();
		}
		finally
		{
			if(s!=null)
			{
				try {
					s.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(c!=null)
			{
				try {
					c.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}