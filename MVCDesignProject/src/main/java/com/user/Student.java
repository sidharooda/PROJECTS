package com.user;

public class Student {
	private int sid;
	private String name;
	private int age;
	private long mobile;
	private String address;
	private String email;
	private String cource;
	public Student(String name, int age, long mobile, String address, String email, String cource) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.cource = cource;
	}
	
	
	public Student(long mobile) {
		super();
		this.mobile = mobile;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public Student(int sid, String name, int age, long mobile, String address, String email, String cource) {
		super();
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
		this.cource = cource;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCource() {
		return cource;
	}
	public void setCource(String cource) {
		this.cource = cource;
	}
	

}
