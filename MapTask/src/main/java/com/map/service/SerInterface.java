package com.map.service;

import java.util.List;
import java.util.Set;

import com.map.model.Employee;
import com.map.model.EmployeeProjectDTO;
import com.map.model.Project;
import com.map.model.ProjectEmployeeDTO;

public interface SerInterface {
	//with address one to one 
	public void addData(Employee emp);
	public List<Employee> getAllEmployees();
    public String updateEmp(Employee emp);
    public Employee getoneEmp(int id);
    public String deleteEmp(int id);
    //with department   many to one and one to many
    public void addEMPwithAddressDepart(Employee emp) ;
    public List<Employee> getAllEmployeeswithDept();
    public Employee getOneEMPwithDEPT(int id);
    public String updEMPwithDEPT(Employee emp);
    public String deleteEmpwithDEPT(int id);

    //many to many mapping 3rd task
    public Project getProjectById(int projectId);
    public void assignProjects(int empId,int projectId);
    public EmployeeProjectDTO getoneEMPPRO(int id) ;
    public ProjectEmployeeDTO getonePROEMP(int id) ;
    
}
