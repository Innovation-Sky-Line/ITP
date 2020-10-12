package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ossms.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{
	
	@Query(value="SELECT type FROM employee WHERE idEmployee = :id", nativeQuery = true)
	String findEmpType(@Param("id")int id);
	
	@Query(value ="select * from employee where type like %?1%", nativeQuery = true)
    List<Employee> searchEmployee(String type);
	
}
