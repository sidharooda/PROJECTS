package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.user.Student;
import com.user.User;

public class Dao {
	Connection c=null;
	Statement s=null;
	PreparedStatement ps=null;
	String Driver="com.mysql.jdbc.Driver";
	String query="insert into user (name,email,password) values (?,?,?);";
	String query1="select * from user";
	String student="select * from student";
	String insertStudentData="insert into student (name,age,mobile,email,address,cource) values (?,?,?,?,?,?);";
	public boolean insertData(User u)
	{
		boolean isDatainserting=true;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Ksiddu0575@");
			s=c.createStatement();
		   ResultSet rs=s.executeQuery(query1);
		   while(rs.next())
		   {
			   if(rs.getString(3).equals(u.getEmail()))
			   {
				   isDatainserting=false;
				   break;
			   }
		   }
		   if(isDatainserting)
		   {
			   ps=c.prepareStatement(query);
				ps.setString(1,u.getName());
				ps.setString(2,u.getEmail());
				ps.setString(3,u.getPassword());
				ps.executeUpdate();
			   
		   }
			
		} catch (ClassNotFoundException e) {
			System.out.println("class not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("data base connection problem");
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
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
		return isDatainserting;
	}
	public boolean validUser(User u)
	{
		boolean isDataPresent=false;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Ksiddu0575@");
			s=c.createStatement();
	        ResultSet rs=s.executeQuery(query1);
	        while(rs.next())
	        {
	        	if(rs.getString(3).equals(u.getEmail()) && rs.getString(4).equals(u.getPassword()))
	        	{
	        		isDataPresent=true;
	        		break;
	        	}
	        }
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("class not found");
          			e.printStackTrace();
		} catch (SQLException e) {
			
			System.out.println("Data base problem");
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
		return isDataPresent;
		
		
		
		
		
	}
	public boolean insertStudent(Student s1) 
	{
		boolean isDataPresent=false;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Ksiddu0575@");
			s=c.createStatement();
	ResultSet rs=s.executeQuery(student);
	while(rs.next())
	{
		if(rs.getLong("mobile")==s1.getMobile() || rs.getString("email").equals(s1.getEmail()))
		{
			isDataPresent=true;
			break;
		}
	}
	if(!isDataPresent)
	{
		ps=c.prepareStatement(insertStudentData);
		ps.setString(1,s1.getName());
		ps.setInt(2,s1.getAge());
		ps.setLong(3,s1.getMobile());
		ps.setString(4,s1.getEmail());
		ps.setString(5,s1.getAddress());
		ps.setString(6,s1.getCource());
		ps.executeUpdate();
		
	}
		} catch (ClassNotFoundException e) {
			System.out.println("class problem");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("database problem");
			e.printStackTrace();
		}
		return isDataPresent;
		
		
		
	}
	public ArrayList<Student> getData()
	{
		ArrayList<Student> al=new ArrayList<Student>();
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Ksiddu0575@");
			s=c.createStatement();
		   ResultSet rs=s.executeQuery("select * from student");
		   
		   while(rs.next())
		   {
			  int sid= rs.getInt("id");
			  String name=rs.getString("name");
			  int age=rs.getInt("age");
			  long mobile=rs.getLong("mobile");
			  String email=rs.getString("email");
			  String address=rs.getString("address");
			  String course = rs.getString("cource");
			  Student s=new Student(sid, name, age, mobile, email, address, course);
			  
			  al.add(s);
		   }
		   
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
		
	}
	public Student updateDetailsofStudent(Student s2) {
		Student s=null;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Ksiddu0575@");
			ps=c.prepareStatement("select * from student where mobile=?");
			ps.setLong(1,s2.getMobile());
		    ResultSet rs=ps.executeQuery();
		    if(rs.next())
		    {
		    	String name=rs.getString("name");
		    	int age=rs.getInt("age");
		    	long mobile=rs.getLong("mobile");
		    	String email=rs.getString("address");
		    	String address=rs.getString("email");
		    	String course=rs.getString("cource");
		    	 s=new Student(name, age, mobile, email, address, course);
		    }
			
		} catch (ClassNotFoundException e) {
			System.out.println("class");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("database");
			e.printStackTrace();
		}finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
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
		
		return s;
	
	}
	public void updateStudentDetails(Student s2) {
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Ksiddu0575@");
			ps=c.prepareStatement("update student set name=?, age=?, mobile=?, email=?, address=?, cource=? where mobile=?");
			ps.setString(1,s2.getName());
			ps.setInt(2,s2.getAge());
			ps.setLong(3,s2.getMobile());
			ps.setString(4,s2.getAddress());
			ps.setString(5,s2.getEmail());
			ps.setString(6,s2.getCource());
			ps.setLong(7,s2.getMobile());
			ps.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
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
	public boolean deleteDetails(Student s2) {
		boolean is=true;
		try {
			Class.forName(Driver);
			c=DriverManager.getConnection("jdbc:mysql://localhost:3306/palle","root","Ksiddu0575@");
			s=c.createStatement();
	        ResultSet rs=s.executeQuery("select * from student");
	        while(rs.next())
	        {
	        	if(s2.getMobile()==rs.getLong("mobile"))
	        	{
	        		ps=c.prepareStatement("delete from student where mobile=?");
	    			ps.setLong(1,s2.getMobile());
	    			ps.executeUpdate();
	        	}
	        	else
	        	{
	        		is=false;
	        		break;
	        	}
	        }
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if(ps!=null)
			{
				try {
					ps.close();
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
		return is;
		
		
		
		
		
	
	
	
	
	}
}
