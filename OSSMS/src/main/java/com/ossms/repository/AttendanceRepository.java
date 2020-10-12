package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ossms.model.AttId;
import com.ossms.model.Attendance;

public interface AttendanceRepository extends CrudRepository<Attendance , AttId>{
	

	Attendance findByEmpIdAndMonthId(@Param("empId")int empId, @Param("monthId")String monthId);
	
	@Query(value="SELECT * FROM attendance WHERE monthId =:monthId ORDER BY attendance DESC", nativeQuery = true)
	List<Attendance> findEmpAttendanceDesc(@Param("monthId") String monthId);
	
	
	@Query(value="SELECT * FROM attendance WHERE empId =:empId ", nativeQuery = true)
	List<Attendance>findAttendanceById(@Param("empId") String empId);
}
