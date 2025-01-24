package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class OrderWrapper {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int oid;
	private int qty;
	private String status;
	private int totalprice;
	private String pname;
	public OrderWrapper() {}
	public OrderWrapper(int oid, int qty, String status, int totalprice, String pname) {
		super();
		this.oid = oid;
		this.qty = qty;
		this.status = status;
		this.totalprice = totalprice;
		this.pname = pname;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	};
	

}
