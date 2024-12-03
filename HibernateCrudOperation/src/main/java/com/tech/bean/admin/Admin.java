package com.tech.bean.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int EId;
	@Column (name ="employee_name")
	private String ename;
	private String email;
	private String password;
	public Admin(String ename, String email, String password) {
		super();
		this.ename = ename;
		this.email = email;
		this.password = password;
	}
	public Admin(int eId, String ename, String email, String password) {
		super();
		EId = eId;
		this.ename = ename;
		this.email = email;
		this.password = password;
	}
	public Admin()
	{
		super();
	}
	public int getEId() {
		return EId;
	}
	public void setEId(int eId) {
		EId = eId;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
