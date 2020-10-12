package com.ossms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossms.model.AttId;
import com.ossms.model.Attendance;
import com.ossms.model.EmpBasicInfo;
import com.ossms.model.Employee;
import com.ossms.repository.AttendanceRepository;
import com.ossms.repository.EmpBasicInfoRepo;
import com.ossms.repository.EmployeeRepository;


@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository empRepo;
	@Autowired
	EmpBasicInfoRepo empBasRepo;
	@Autowired
	AttendanceRepository attRepo;
	
	@Override
	public void saveorUpdate(Employee employee) {
		empRepo.save(employee);
		
	}
	
	@Override
	public void saveorUpdate(Attendance attendance) {
		attRepo.save(attendance);
		
	}


	@Override
	public List<Employee> getallEmployees() {
		
		return (List<Employee>) empRepo.findAll();
	}
	
	@Override
	public List<Attendance> getallAttendance() {
		
		return (List<Attendance>) attRepo.findAll();
	}
	
	@Override
	public Employee getEmployeeById(Integer id) {
		
		return empRepo.findById(id).get();
	}
	
	@Override
	public void deleteEmployee(Integer id) {
		empRepo.deleteById(id);
		
	}
	
	@Override
	public void saveEmp(Employee employee) {
		empRepo.save(employee);
	}

	@Override
	public String findByType(Integer id) {
		return empRepo.findEmpType(id);
	}

	@Override
	public Optional<EmpBasicInfo> findById(String type) {
		return empBasRepo.findById(type);
	}

	@Override
	public Attendance findAttendance(int empId, String monthId) {
		// TODO Auto-generated method stub
		return attRepo.findByEmpIdAndMonthId(empId, monthId);
	}

	@Override
	public List<Employee> searchEmployees(String type){
		return empRepo.searchEmployee(type);
	}

	@Override
	public List<Attendance> getAllAttendanceDesc(String monthId) {
		return attRepo.findEmpAttendanceDesc(monthId);
	}

	

	

}
