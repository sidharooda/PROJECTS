package com.tech.bean.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int Id;
	@Column (name="employee_name")
	private String ename;
	private int salary;
	public Employee(int id, String ename, int salary) {
		super();
		Id = id;
		this.ename = ename;
		this.salary = salary;
	}
	public Employee(String ename, int salary) {
		super();
		this.ename = ename;
		this.salary = salary;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee()
	{
		super();
	}
	

}
