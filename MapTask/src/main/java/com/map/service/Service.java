package com.map.service;



import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


import com.map.dao.Dao;
import com.map.model.Employee;
import com.map.model.EmployeeProjectDTO;
import com.map.model.Project;
import com.map.model.ProjectEmployeeDTO;
@org.springframework.stereotype.Service
public class Service implements SerInterface{
	@Autowired
	private Dao dao;

	@Override
	public void addData(Employee emp) {

		dao.addData(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Override
	public String updateEmp(Employee emp) {
		
		return  dao.updateEmp(emp);
	}

	@Override
	public Employee getoneEmp(int id) {
		Employee emp=dao.getoneEmp(id);
		if(emp!=null)
		{
			return emp;
		}
		else
		{
			return null;
		}
	}

	@Override
	public String deleteEmp(int id) {
		return dao.deleteEmp(id);
	}

	public void addEMPwithAddressDepart(Employee emp) {

		dao.addEMPwithAddressDepart(emp);
		
	}

	@Override
	public List<Employee> getAllEmployeeswithDept() {
		return dao.getAllEmployeeswithDept();
	}

	@Override
	public Employee getOneEMPwithDEPT(int id) {
	

		Employee emp=dao.getOneEMPwithDEPT(id);
		if(emp!=null)
		{
			return emp;
		}
		else
		{
			return null;
		}
	
		
	}

	@Override
	public String updEMPwithDEPT(Employee emp) {
		return dao.updEMPwithDEPT(emp);
	}

	@Override
	public String deleteEmpwithDEPT(int id) {
	   return dao.deleteEmpwithDEPT(id);
	}

	public Project getProjectById(int projectId) {
		
		return dao.getProjectById(projectId);
		 
	}

	public void assignProjects(int empId,int projectId) {
		
		dao.assignProjects(empId,projectId);
		
	}

	public EmployeeProjectDTO getoneEMPPRO(int id) {
		
		return dao.getoneEMPPRO(id);
		
	}

	public ProjectEmployeeDTO getonePROEMP(int id) {
		return dao.getonePROEMP(id);
		
	}
	
	

}
