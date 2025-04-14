package com.map.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	@ManyToMany(mappedBy = "projects",cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Employee> employee;
	public Project() {
		super();
	}
	public Project(String name, Set<Employee> employee) {
		super();
		this.name = name;
		this.employee = employee;
	}
	public Project(int id, String name, Set<Employee> employee) {
		super();
		this.id = id;
		this.name = name;
		this.employee = employee;
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
	public Set<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}
	



}
