package com.tech.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tech.bean.admin.Admin;
import com.tech.bean.employee.Employee;


@WebServlet("/")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		switch(path)
		{
	case "/home":openEmployeeDetails(request,response);
    break;
	case "/deleteemployee":deleteEmployee(request,response);
	break;
	case "/getdatafromtable":editEmployeeData(request,response);
	break;
		}
	}
				private void editEmployeeData(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
	    Employee  e1=s.get(Employee.class, id);
	    request.setAttribute("employeedata", e1);
	    RequestDispatcher rd=request.getRequestDispatcher("addemployee.jsp");
	    try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    t.commit();
	    
	   
		
	}
				private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction t=s.beginTransaction();
			int id=Integer.parseInt(request.getParameter("id"));
	        Employee e1=s.get(Employee.class,id);
			s.delete(e1);
			t.commit();
			try {
				response.sendRedirect("home");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		private void openEmployeeDetails(HttpServletRequest request, HttpServletResponse response) {
			SessionFactory sf=new Configuration().configure().buildSessionFactory();
			Session s=sf.openSession();
			Transaction t=s.beginTransaction();
			Criteria c=s.createCriteria(Employee.class);
			List<Employee> l=c.list();
			request.setAttribute("employee",l);
			RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		switch(path)
		{
		case "/validadmin":adminValidation(request,response);
		                   break;
		case "/adminreg":adminRegisterPage(request,response);
		                   break;
		case "/openform":openEmployeeForm(request,response);
		                   break;
		case "/add":     addEmployee(request,response);
		                   break;
		case "/getdatafromtable":getDataFromTable(request,response);
		break;
		case "/update":update(request,response);
		break;
		
		}
		
	}
	private void update(HttpServletRequest request, HttpServletResponse response) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("txtname");
		int salary=Integer.parseInt(request.getParameter("txtsalary"));
		 Employee e1 =s.get(Employee.class,id);
		 e1.setEname(name);
		 e1.setSalary(salary);
		 s.update(e1);
		 t.commit();
		 try {
			response.sendRedirect("home.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void getDataFromTable(HttpServletRequest request, HttpServletResponse response) {
		int id=Integer.parseInt(request.getParameter("id"));
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		 Employee e1=s.get(Employee.class,id);
		 request.setAttribute("employeedata",e1);
		 RequestDispatcher rd=request.getRequestDispatcher("addemployee.jsp");
		 try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 t.commit();
		
	}


	
		


	private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("txtname");
		int salary=Integer.parseInt(request.getParameter("txtsalary"));
		Employee e1=new Employee(name, salary);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(e1);
		t.commit();
		sf.close();
		s.close();
		request.setAttribute("msg","Data inserted successfully");
		RequestDispatcher rd=request.getRequestDispatcher("addemployee.jsp");
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

	private void openEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			response.sendRedirect("addemployee.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	private void adminRegisterPage(HttpServletRequest request, HttpServletResponse response) {
		String name=request.getParameter("txtname");
		String email=request.getParameter("txtemail");
		String password=request.getParameter("txtpassword");
		Admin a=new Admin(name, email, password);
		SessionFactory sf=new Configuration().configure().buildSessionFactory();  //Create the session Factory
		Session s=sf.openSession();                                               //open the session
		Transaction t=s.beginTransaction(); 
		s.save(a);
		t.commit();
		s.close();
		sf.close();
		request.setAttribute("msg","data registered successfully");
		RequestDispatcher rd=request.getRequestDispatcher("adminreg.jsp");
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

	private void adminValidation(HttpServletRequest request, HttpServletResponse response) {
		boolean isDataPresent=false;
		String username=request.getParameter("txtusername");
		String password=request.getParameter("txtpassword");
		SessionFactory sf=new Configuration().configure().buildSessionFactory();  //Create the session Factory
		Session s=sf.openSession();                                               //open the session
		Transaction t=s.beginTransaction();                                       //starting the transaction
		Criteria c=s.createCriteria(Admin.class);                                 //fetch the all data from Database
		List<Admin> l=c.list();
		Criteria c1=s.createCriteria(Employee.class);
		List<Employee> e1=c1.list();
		request.setAttribute("employee",e1);
		                                                   //we have create object for the retrived data
		 for(Admin a:l)
		 {
			 if(username.equals(a.getEmail()) &&  password.equals(a.getPassword()))
			 {
				 isDataPresent=true;
				 break;
			 }
		 }
		 if(isDataPresent)
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
			 request.setAttribute("error","Invalid username && Password");
			 RequestDispatcher rd=request.getRequestDispatcher("adminvalid.jsp");
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

}
