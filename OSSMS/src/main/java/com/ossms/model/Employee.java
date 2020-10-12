package com.ossms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@Column(name="idemployee")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idEmployee ;
	
	@Column(name="position")
	String position;
	
	@Column(name="hoursworked")
	int hoursWorked;
	
	@Column(name="othours")
	int otHours;
	
	@Column(name="type")
	String type;
	
	@Column(name="firstname")
	String firstName;
	
	@Column(name="lastname")
	String lastName;
	
	@Column(name="address")
	String address;
	
	@Column(name="contactno")
	String contactNo;
	
	@Column(name="totalsalary")
	float totSalary;
	
	/*@ManyToOne
	public  EmpBasicInfo empBasicInfo;*/
	
	public int getIdEmployee() {
		return idEmployee;
	}
	public String getPosition() {
		return position;
	}
	public int getHoursWorked() {
		return hoursWorked;
	}
	public int getOtHours() {
		return otHours;
	}
	public String getType() {
		return type;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public String getContactNo() {
		return contactNo;
	}
	public float getTotSalary() {
		return totSalary;
	}
	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	public void setOtHours(int otHours) {
		this.otHours = otHours;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public void setTotSalary(float totSalary) {
		this.totSalary = totSalary;
	}
	
	
		

}
