package com.ossms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idemployee")
	private int idEmployee;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "hoursworked")
	private int hoursWorked;
	
	@Column(name = "othours")
	private int otHours;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "contactno")
	private String contactNo;
	
	@Column(name = "totalsalary")
	private float totalSalary;
	
	

	public Employee() {
		super();
	}

	public Employee(int idEmployee, String position, int hoursWorked, int otHours, String type, String firstName,
			String lastName, String address, String contactNo, float totalSalary) {
		super();
		this.idEmployee = idEmployee;
		this.position = position;
		this.hoursWorked = hoursWorked;
		this.otHours = otHours;
		this.type = type;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contactNo = contactNo;
		this.totalSalary = totalSalary;
	}

	public int getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(int idEmployee) {
		this.idEmployee = idEmployee;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(int hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public int getOtHours() {
		return otHours;
	}

	public void setOtHours(int otHours) {
		this.otHours = otHours;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public float getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(float totalSalary) {
		this.totalSalary = totalSalary;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", position=" + position + ", hoursWorked=" + hoursWorked
				+ ", otHours=" + otHours + ", type=" + type + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", address=" + address + ", contactNo=" + contactNo + ", totalSalary=" + totalSalary + "]";
	}
	
	
	
	
	
	
	
}
