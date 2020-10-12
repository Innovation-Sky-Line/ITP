package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ossms.model.Employee;
import com.ossms.model.Order;

public interface DelEmployeRepository extends JpaRepository<Employee,Integer>{
	@Query(value="SELECT * FROM employee WHERE idEmployee = :id", nativeQuery = true)
	Employee getNameOfEmpById(int id);
	
	List<Employee> findEmployeeByTypeContaining(String type);
}
