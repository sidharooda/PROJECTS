package com.map.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Employee {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String name;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id") 
	    private Address address;

	    @ManyToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "dept_id")
	    private Department department;
	    
	    @ManyToMany(cascade = CascadeType.ALL)
	    @JoinTable(
	            name = "employee_project", // Join table
	            joinColumns = @JoinColumn(name = "employee_id"), // FK to employee
	            inverseJoinColumns = @JoinColumn(name = "project_id") // FK to project
	        )
	    private Set<Project> projects;
	    
	    
		public Employee() {
			
		}

		public Employee(int id, String name, Address address) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
		}

		public Employee(String name, Address address) {
			super();
			this.name = name;
			this.address = address;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
		}

		public Employee(int id, String name, Address address, Department department) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
			this.department = department;
		}

		public Employee(String name, Address address, Department department) {
			super();
			this.name = name;
			this.address = address;
			this.department = department;
		}

		public Department getDepartment() {
			return department;
		}

		public void setDepartment(Department department) {
			this.department = department;
		}

		public Employee(int id, String name, Address address, Department department, Set<Project> projects) {
			super();
			this.id = id;
			this.name = name;
			this.address = address;
			this.department = department;
			this.projects = projects;
		}

		public Employee(String name, Address address, Department department, Set<Project> projects) {
			super();
			this.name = name;
			this.address = address;
			this.department = department;
			this.projects = projects;
		}

		public Set<Project> getProjects() {
			return projects;
		}

		public void setProjects(Set<Project> projects) {
			this.projects = projects;
		}
		
		

}
