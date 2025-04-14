package com.map.dao;

import java.util.List;
import java.util.Set;

import com.map.model.Employee;
import com.map.model.EmployeeProjectDTO;
import com.map.model.Project;
import com.map.model.ProjectEmployeeDTO;

public interface DaoInterface {
	//one to one 
	public void addData(Employee emp);
	public List<Employee> getAllEmployees();
    public String updateEmp(Employee emp);
    public Employee getoneEmp(int id);
    public String deleteEmp(int id);
    //second with department //many to one and one to many
    public void addEMPwithAddressDepart(Employee emp);
    public List<Employee> getAllEmployeeswithDept();
    public Employee getOneEMPwithDEPT(int id);
    public String updEMPwithDEPT(Employee emp);
    public String deleteEmpwithDEPT(int id);
    //third task many to many mapping
    public Project getProjectById(int Id);
    public void assignProjects(int empId ,int projectId);
    public EmployeeProjectDTO getoneEMPPRO(int id);
    public ProjectEmployeeDTO getonePROEMP(int id) ;
}
