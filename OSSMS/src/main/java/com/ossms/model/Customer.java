package com.ossms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idcustomer")
	private int idcustomer;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contactno")
	private String contactno;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;



	public Customer() {
		super();
	}

	public Customer(int idcustomer, String firstname, String lastname, String address, String contactno,
			String email, String username, String password, Delivery orderInfo) {
		super();
		this.idcustomer = idcustomer;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.contactno = contactno;
		this.email = email;
		this.username = username;
		this.password = password;
		
	}

	public int getIdcustomer() {
		return idcustomer;
	}

	public void setIdcustomer(int idcustomer) {
		this.idcustomer = idcustomer;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	@Override
	public String toString() {
		return "DelCustomer [idcustomer=" + idcustomer + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", contactno=" + contactno + ", email=" + email + ", username=" + username
				+ ", password=" + password + "]";
	}

	
	
	
	
}
