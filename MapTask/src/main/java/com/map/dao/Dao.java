package com.map.dao;

import java.lang.module.Configuration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.map.model.Address;
import com.map.model.Department;
import com.map.model.Employee;
import com.map.model.EmployeeProjectDTO;
import com.map.model.Project;
import com.map.model.ProjectEmployeeDTO;

import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class Dao implements DaoInterface{
	@Autowired
	 private SessionFactory sessionfactory;

	@Override
	public void addData(Employee emp) {
		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		           
		            session.save(emp);
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		
		 

	       
		
		}

	@Override
	public List<Employee> getAllEmployees() {
		Transaction transaction = null;
	    List<Employee> employees = null;
	    try (Session session = sessionfactory.openSession()) {
	        transaction = session.beginTransaction();

	       HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
	        Root<Employee> root = query.from(Employee.class);
	        query.select(root);
            System.out.println(query.toString());
	        employees = session.createQuery(query).getResultList();

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }
	   
	    return employees;
	}

	@Override
	public String updateEmp(Employee emp) {

		String result="";
		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		           int id=emp.getId();
		           System.out.println(emp.toString());
		           System.out.println("Received Employee ID for update: " + id);
		           if (id <= 0) {
		        	    System.out.println("Invalid employee ID received!");
		        	}

		           Employee emp1=session.get(Employee.class,id);
		           if(emp1!=null)
		           {
		        	  emp1.setName(emp.getName());
		        	  
		        	  Address existing=emp1.getAddress();
		        	  Address newadd=emp.getAddress();
		        	  if(existing!=null && newadd!=null)
		        	  {
		        		  existing.setCity(newadd.getCity());
		        		  existing.setType(newadd.getType());
		        		  session.update(emp1);
			        	    result="updated "+id+" employee details saccessfully";
		        	  }
		        	  else
		        	  {
		        		  result=id+"  not present in database";
		        	  }
		        	   
		           }
		          
		           
		          
		           
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		
		 

	     return result;
		
		
		
	}

	@Override
	public Employee getoneEmp(int id) {
		Employee emp=null;

		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		            
		           
		            emp=session.get(Employee.class,id);
		           
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		return emp;
		
		 

	       
		
		
		
	}

	@Override
	public String deleteEmp(int id) {
		String result="";

		Employee emp=null;

		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		            
		           
		            emp=session.get(Employee.class,id);
		            
		            if(emp!=null)
		            {
		            	session.delete(emp);
		            	result=emp.getId()+" employee deleted successfully";
		            }
		            else
		            {
		            	result=emp.getId()+" employee not present in database";
		            }
		           
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		return result;
		
		
		 

	       
		
		
		
	
		
	}

	public void addEMPwithAddressDepart(Employee emp) {
		
		
		

		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		           
		            session.save(emp);
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		
		 

	       
		
		
		
		
	}

	@Override
	public List<Employee> getAllEmployeeswithDept() {
		
		Transaction transaction = null;
	    List<Employee> employees = null;
	    try (Session session = sessionfactory.openSession()) {
	        transaction = session.beginTransaction();

	       HibernateCriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
	        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
	        Root<Employee> root = query.from(Employee.class);
	        query.select(root);
            System.out.println(query.toString());
	        employees = session.createQuery(query).getResultList();

	        transaction.commit();
	    } catch (Exception e) {
	        if (transaction != null) transaction.rollback();
	        e.printStackTrace();
	    }
	   
	    return employees;
		
	}

	@Override
	public Employee getOneEMPwithDEPT(int id) {

		Employee emp=null;

		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		            
		           
		            emp=session.get(Employee.class,id);
		           
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		return emp;
		
		 

	       
		
		
		
	
		
		
	}

	@Override
	public String updEMPwithDEPT(Employee emp) {
		


		String result="";
		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		           int id=emp.getId();
		           System.out.println(emp.toString());
		           System.out.println(emp.getAddress().toString());
		           System.out.println(emp.getDepartment().toString());
		           System.out.println("Received Employee ID for update: " + id);
		           if (id <= 0) {
		        	    System.out.println("Invalid employee ID received!");
		        	}

		           Employee emp1=session.get(Employee.class,id);
		           if(emp1!=null)
		           {
		        	  emp1.setName(emp.getName());
		        	  
		        	  Address existing=emp1.getAddress();
		        	  Address newadd=emp.getAddress();
		        	  Department existingdept=emp1.getDepartment();
		        	  Department newdept=emp.getDepartment();
		        	  if(existing!=null && newadd!=null&&existingdept!=null && newdept!=null)
		        	  {
		        		  existing.setCity(newadd.getCity());
		        		  existing.setType(newadd.getType());
		        		  existingdept.setName(newdept.getName());
		        		 session.update(emp1);
		        		 result=id+" employee details updated successfully";
		        	  }
		        	  else
		        	  {
		        		 result=id+" employee is not found";
		        	  }
		        	 
		        	 
		        	   
		           }
		           else
		           {
		        	   result=id+" not found";
		           }
		         
		          
		           
		          
		           
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		
		 

	     return result;
		
		
		
	
		
	}

	@Override
	public String deleteEmpwithDEPT(int id) {

		String result="";

		Employee emp=null;

		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		            
		           
		            emp=session.get(Employee.class,id);
		            
		            if(emp!=null)
		            {
		            	session.delete(emp);
		            	result=emp.getId()+" employee deleted successfully";
		            }
		            else
		            {
		            	result=emp.getId()+" employee not present in database";
		            }
		           
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		return result;
		
		
		
	}

	public Project getProjectById(int Id) {

		Project pro=null;

		if(sessionfactory!=null)
		{
			Session session=sessionfactory.openSession();
			Transaction tx = null;
			 try {
		            tx = session.beginTransaction();
		            
		           
		            pro=session.get(Project.class,Id);
		           
		            
		            // Automatically saves the associated Address due to CascadeType.ALL
		            tx.commit();
		        } catch (Exception e) {
		            if (tx != null) tx.rollback();
		            e.printStackTrace();
		        } finally {
		            session.close();
		        }
		}
		return pro;
		
		 

	       
		
		
		
	
		
		
		
	}

	public void assignProjects(int empId ,int projectId) {
		
		Session session = sessionfactory.openSession();
	    Transaction tx = null;

	    try {
	        tx = session.beginTransaction();

	        Employee employee = session.get(Employee.class, empId);
	        Project project = session.get(Project.class, projectId);

	        if (employee != null && project != null) {
	            employee.getProjects().add(project);
	            project.getEmployee().add(employee);

	            session.update(employee);
	            session.update(project); // Optional: if bidirectional
	        } else {
	            System.out.println("Employee or Project not found!");
	        }

	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) tx.rollback();
	        e.printStackTrace();
	    } finally {
	        session.close();
	    }

		
		
	}

	public EmployeeProjectDTO getoneEMPPRO(int id) {
		 Session session = sessionfactory.openSession();
		    Employee employee = session.get(Employee.class, id);

		    EmployeeProjectDTO dto = null;

		    if (employee != null) {
		        String name = employee.getName();
		        List<String> projectNames = employee.getProjects().stream()
		                                   .map(Project::getName)
		                                   .collect(Collectors.toList());
		        dto = new EmployeeProjectDTO(name, projectNames);
		    }

		    session.close();
		    return dto;
	}

	public ProjectEmployeeDTO getonePROEMP(int id) {

		 Session session = sessionfactory.openSession();
		    Project project = session.get(Project.class, id);

		    ProjectEmployeeDTO dto = null;

		    if (project != null) {
		        String name = project.getName();
		        List<String> employeetNames = project.getEmployee().stream()
		                                   .map(Employee::getName)
		                                   .collect(Collectors.toList());
		        dto = new ProjectEmployeeDTO(name, employeetNames);
		    }

		    session.close();
		    return dto;
	
		
	}
		
		
		
	

}
