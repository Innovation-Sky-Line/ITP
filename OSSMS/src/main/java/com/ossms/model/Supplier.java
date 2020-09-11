package com.ossms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsupplier")
	private int idSupplier;
	
	@Column(name = "suppliername")
	private String supplierName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "contactno")
	private String contactNo;
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Supplier(int idSupplier, String supplierName, String address, String email, String status,
			String contactNo) {
		super();
		this.idSupplier = idSupplier;
		this.supplierName = supplierName;
		this.address = address;
		this.email = email;
		this.status = status;
		this.contactNo = contactNo;
	}


	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSuppliwe(int idSupplier) {
		this.idSupplier = idSupplier;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	
	
}
