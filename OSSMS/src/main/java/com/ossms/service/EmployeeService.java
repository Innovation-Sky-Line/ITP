package com.ossms.service;

import java.util.List;
import java.util.Optional;

import com.ossms.model.AttId;
import com.ossms.model.Attendance;
import com.ossms.model.EmpBasicInfo;
import com.ossms.model.Employee;


public interface EmployeeService {
	
	public void saveorUpdate(Employee employee);
	
	public void saveorUpdate(Attendance attendance);
	
	public List <Employee> getallEmployees();
	
	public List<Employee> searchEmployees(String type);
	
	public List <Attendance> getallAttendance();
	
	public Employee getEmployeeById(Integer id);
	
	public void deleteEmployee(Integer id);
	
	public void saveEmp(Employee employee);
	
	public String findByType(Integer id);
	
	public Optional<EmpBasicInfo> findById(String type);
	
	public Attendance findAttendance(int empId, String monthId); 
	
	public List<Attendance> getAllAttendanceDesc(String monthId);


}