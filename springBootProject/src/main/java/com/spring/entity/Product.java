package com.spring.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Product {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	private String pname;
	private int price;
	private int qty;
	@OneToMany(mappedBy = "product")
	private List<Order1> order;
	public Product()
	{
		
	}
	
	public Product(int id, String pname, int price, int qty, List<Order1> order) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.qty = qty;
		this.order = order;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	public List<Order1> getOrder() {
		return order;
	}

	public void setOrder(List<Order1> order) {
		this.order = order;
	}
	
	

}
