package com.ossms.model;

import java.io.Serializable;

public class AttId implements Serializable {
	
	private int empId;
	private String monthId;
	
	
	public AttId() {
		
	}


	public AttId(int empId, String monthId) {
		super();
		this.empId = empId;
		this.monthId = monthId;
	}


	public int getEmpId() {
		return empId;
	}


	public String getMonthId() {
		return monthId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public void setMonthId(String monthId) {
		this.monthId = monthId;
	}


	@Override
	public String toString() {
		return "AttId [empId=" + empId + ", monthId=" + monthId + "]";
	}
	
	
}
