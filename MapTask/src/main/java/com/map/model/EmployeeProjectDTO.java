package com.map.model;

import java.util.List;

public class EmployeeProjectDTO {
	
	 private String employeeName;
	    private List<String> projects;

	    // Constructors
	    public EmployeeProjectDTO() {}
	    
	    public EmployeeProjectDTO(String employeeName, List<String> projects) {
	        this.employeeName = employeeName;
	        this.projects = projects;
	    }

	    // Getters and Setters
	    public String getEmployeeName() {
	        return employeeName;
	    }
	    public void setEmployeeName(String employeeName) {
	        this.employeeName = employeeName;
	    }
	    public List<String> getProjects() {
	        return projects;
	    }
	    public void setProjects(List<String> projects) {
	        this.projects = projects;
	    }


}
