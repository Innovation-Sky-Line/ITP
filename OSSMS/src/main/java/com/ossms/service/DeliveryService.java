package com.ossms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.model.DelCustomer;
import com.ossms.model.DelVehicle;
import com.ossms.model.Delivery;
import com.ossms.repository.DelCustomerRepository;
import com.ossms.repository.DeliveryRepository;
import com.ossms.repository.VehicleRepository;



@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository dRep;
	@Autowired
	private DelCustomerRepository cRep;
	@Autowired
	private VehicleRepository vRep;
	
	//Methods for retrieve all data
	public List<Delivery> getAllDelis(){
		return (List<Delivery>) dRep.findAll();
	}
	
	public List<DelVehicle> getAllVehicles(){
		return (List<DelVehicle>) vRep.findAll();
	}
		
	public List<DelCustomer> getAllCustomers(){
		return (List<DelCustomer>) cRep.findAll();
	}
	
	
	//update
	public void update(Delivery delivery) {
		dRep.save(delivery);
		
	}

	
	//Find by  id
	public Delivery get(int orderid) {
		return dRep.findById(orderid).get();
	}
	
	
	//Delete vehicle
	public void deleteVehicle(int idvehicle) {
		vRep.deleteById(idvehicle);
	}
	
	public void saveVehicle(DelVehicle vehicle) {
		vRep.save(vehicle);
	}
	
	
	
}
