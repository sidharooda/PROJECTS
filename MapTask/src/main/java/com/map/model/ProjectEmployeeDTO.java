package com.map.model;

import java.util.List;

public class ProjectEmployeeDTO {

	
	 private String projectName;
	    private List<String> employees;

	    // Constructors
	    public ProjectEmployeeDTO() {}
	    
	    public ProjectEmployeeDTO(String projectName, List<String> employees) {
	        this.projectName = projectName;
	        this.employees = employees;
	    }

		public String getProjectName() {
			return projectName;
		}

		public void setProjectName(String projectName) {
			this.projectName = projectName;
		}

		public List<String> getEmployees() {
			return employees;
		}

		public void setEmployees(List<String> employees) {
			this.employees = employees;
		}

	  



}
