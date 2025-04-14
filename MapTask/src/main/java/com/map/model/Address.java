package com.map.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Address {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;

	    private String city;
	    private String type;

	    @OneToOne(mappedBy = "address",cascade = CascadeType.ALL)

	   
	    @JsonBackReference
	    private Employee employee;


		public Address() {
			
		}

		public Address(int id, String city, String type, Employee employee) {
			super();
			this.id = id;
			this.city = city;
			this.type = type;
			this.employee = employee;
		}

		public Address(String city, String type, Employee employee) {
			super();
			this.city = city;
			this.type = type;
			this.employee = employee;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Employee getEmployee() {
			return employee;
		}

		public void setEmployee(Employee employee) {
			this.employee = employee;
		}
		
	    

}
