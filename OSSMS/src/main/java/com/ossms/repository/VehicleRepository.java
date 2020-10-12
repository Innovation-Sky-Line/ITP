package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ossms.model.DelVehicle;
import com.ossms.model.Order;

public interface VehicleRepository extends JpaRepository<DelVehicle,Integer>{

	@Query(value="SELECT * FROM vehicle WHERE idVehicle = :id", nativeQuery = true)
	DelVehicle getVehiclesById(int id);

	
	
}
