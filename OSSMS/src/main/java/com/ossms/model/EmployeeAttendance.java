package com.ossms.model;


public class EmployeeAttendance {
	Employee employee;
	Attendance attendance;
	
	public Employee getEmployee() {
		return employee;
	}
	public Attendance getAttendance() {
		return attendance;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
	}
	public EmployeeAttendance(Employee employee, Attendance attendance) {
		super();
		this.employee = employee;
		this.attendance = attendance;
	}
	public EmployeeAttendance() {
		super();
	}
	
	

}
