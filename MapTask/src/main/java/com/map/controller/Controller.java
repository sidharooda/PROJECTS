package com.map.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.map.model.Employee;
import com.map.model.EmployeeProjectDTO;
import com.map.model.Project;
import com.map.model.ProjectEmployeeDTO;
import com.map.service.Service;

@RestController
@RequestMapping("/task")
public class Controller {
	@Autowired
	private Service service;
	@PostMapping("/add")
	public void addData(@RequestBody Employee emp)
	{
		service.addData(emp);
	}
	@GetMapping("/viewall")
	public List<Employee> getAllEmployees()
	{
		return service.getAllEmployees();
	}
	@PutMapping("/updatedata")
	public String updateEmp(@RequestBody Employee emp)
	{
		return service.updateEmp(emp);
	}
	@GetMapping("/viewone")
	public Employee getoneEmp( @RequestParam("id") int id)
	{
		return service.getoneEmp(id);
	}
	@DeleteMapping("/deleteone")
	public String deleteEmp( @RequestParam("id") int id)
	{
		return service.deleteEmp(id);
	}
	
	//with department
	@PostMapping("/addwithdept")
	public void addEMPwithAddressDepart(@RequestBody Employee emp)
	{
		service.addEMPwithAddressDepart(emp);
	}
	@GetMapping("/viewallwithdept")
	public List<Employee> getAllEmployeeswithDept()
	{
		return service.getAllEmployeeswithDept();
	}
	@GetMapping("/viewonewithdept")
	public Employee getOneEMPwithDEPT(@RequestParam("id") int id)
	{
		return service.getOneEMPwithDEPT(id);
	}
	@PutMapping("/updempwithdept")
	public String updEMPwithDEPT(@RequestBody Employee emp)
	{
		return service.updEMPwithDEPT(emp);
	}
	
	@DeleteMapping("/deleteonewithdept")
	public String deleteEmpwithDEPT( @RequestParam("id") int id)
	{
		return service.deleteEmpwithDEPT(id);
	}
	//third task many to many
	
	@PutMapping("/assignProject")
	public String assignProjectToEmployee(
	    @RequestParam("eid")int empId,
	    @RequestParam("pid") int projectId
	) {
	   
	    service.assignProjects(empId,projectId);

	    return "Project assigned to employee successfully!";
	}
	
	@GetMapping("/getemppro")
	public EmployeeProjectDTO getoneEMPPRO(@RequestParam("id") int id)	
	{
		return service.getoneEMPPRO(id);
	}
	@GetMapping("/getproemp")
	public ProjectEmployeeDTO getonePROEMP(@RequestParam("id") int id)
	{
		return service.getonePROEMP(id);
	}
	
	

}
