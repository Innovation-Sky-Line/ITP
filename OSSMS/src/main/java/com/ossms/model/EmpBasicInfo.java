package com.ossms.model;

import javax.persistence.*;


@Entity
@Table(name="empbasicinfo")
public class EmpBasicInfo {

	@Id
	@Column(name = "emptype")
	private String empType;
	
	@Column(name="hours")
	private int hours;
	
	@Column(name="basicsalary")
	private float basicSalary;

	public String getEmpType() {
		return empType;
	}

	public int getHours() {
		return hours;
	}

	public float getBasicSalary() {
		return basicSalary;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public void setBasicSalary(float basicSalary) {
		this.basicSalary = basicSalary;
	}

	public EmpBasicInfo(String empType, int hours, float basicSalary) {
		super();
		this.empType = empType;
		this.hours = hours;
		this.basicSalary = basicSalary;
	}

	public EmpBasicInfo() {
		super();
	}

	@Override
	public String toString() {
		return "EmpBasicInfo [empType=" + empType + ", hours=" + hours + ", basicSalary=" + basicSalary + "]";
	}
	
	
}
