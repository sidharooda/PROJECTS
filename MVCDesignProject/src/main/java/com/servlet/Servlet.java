package com.servlet;
import com.dao.Dao;
import com.user.Student;
import com.user.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.User;

@WebServlet("/")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        String path=request.getServletPath();
        switch(path)
        {
        case "/reg":registerUser(request,response);
        	break;
        case "/log":validateUser(request,response);
        	break;
        case "/studenthome":
        String action =	request.getParameter("action");
        	switch(action)
        	{
        	case "add student":addStudent(request,response);
        		
        		break;
        	case "Delete":deleteStudentDetails(request,response);
        		break;
        	case "Display":displayStudentData(request,response);
        		break;
        	case "Update":updateStudent(request,response);
        		break;
        		
        			
        	}
        	break;
        case "/savestudent":saveStudentDetails(request,response);
        	break;
        case "/updatestudent":updateStudentDetails(request,response);
            break;
        case "/updatestudentdetails":updateStudentData(request,response);
            break;
        case "/deletestudentdetails":deleteStudentInformation(request,response);
        }
			
	}

	

	private void deleteStudentInformation(HttpServletRequest request, HttpServletResponse response) {
		
		long mobile=Long.parseLong(request.getParameter("txtnumber"));
		Student s2=new Student(mobile);
		Dao d=new Dao();
		boolean a=d.deleteDetails(s2);
		if(a==true)
		{
			request.setAttribute("message","Delete Details Successfully");
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			request.setAttribute("okk","Enter valid Mobile");
			RequestDispatcher rd=request.getRequestDispatcher("delete.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
	}

	private void deleteStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("delete.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void updateStudentData(HttpServletRequest request, HttpServletResponse response) {
          String name=request.getParameter("txtname");
          int age=Integer.parseInt(request.getParameter("txtage"));
          long mobile=Long.parseLong(request.getParameter("txtmobile"));
          String email=request.getParameter("txtemail");
          String address=request.getParameter("txtaddress");
          String course=request.getParameter("txtcourse");
          Student s2=new Student(name, age, mobile, email, address, course);
          Dao d=new Dao();
          d.updateStudentDetails(s2);
          request.setAttribute("message","Updated successfully");
          RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
          try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          
          
	}

	private void updateStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		
		long mobile=Long.parseLong(request.getParameter("txtnumber"));
		Student s1=new Student(mobile);
		Dao d=new Dao();
		Student s=d.updateDetailsofStudent(s1);
		request.setAttribute("details",s);
		RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.sendRedirect("update.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void displayStudentData(HttpServletRequest request, HttpServletResponse response) {
		Dao d=new Dao();
		ArrayList<Student> alist=d.getData();
		request.setAttribute("student list", alist);
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void saveStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		
		String name=request.getParameter("txtname");
		int age=Integer.parseInt(request.getParameter("txtage"));
		long mobile=Long.parseLong(request.getParameter("txtmobile"));
		String email=request.getParameter("txtemail");
		String address=request.getParameter("txtaddress");
		String course=request.getParameter("txtcourse");
		Student s1=new Student(name, age, mobile, email, address, course);
		Dao d=new Dao();
	boolean isDataPresent =	d.insertStudent(s1);
	if(isDataPresent)
	{
		request.setAttribute("message","mobile no is already exist");
		RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	else
	{
		request.setAttribute("message1","details saved successfully");
		RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
		
		
		
		
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) {
		   
		
		
		try {
			response.sendRedirect("student.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void validateUser(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String email=request.getParameter("txtusername");
		String password=request.getParameter("txtpassword");
		User u=new User(email, password);
		Dao d=new Dao();
		boolean isDatamatching=d.validUser(u);
		if(isDatamatching)
		{
			try {
				response.sendRedirect("home.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			request.setAttribute("message","user does not exist");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

	private void registerUser(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("txtname");
		String email=request.getParameter("txtemail");
		String password=request.getParameter("txtpassword");
		User u=new User(name,email,password);
		Dao d=new Dao();
		boolean isdatainserting=d.insertData(u);
		response.setContentType("text/html");
		PrintWriter out;
		try {
			out = response.getWriter();
			if(isdatainserting)
			{
				response.sendRedirect("login.jsp");
			}
			else
			{
				request.setAttribute("message","email already exist");
				RequestDispatcher rd=request.getRequestDispatcher("reg.jsp");
				try {
					rd.forward(request, response);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
