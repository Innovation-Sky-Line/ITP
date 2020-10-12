package com.ossms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.model.Customer;
import com.ossms.model.Employee;
import com.ossms.model.DelVehicle;
import com.ossms.model.Delivery;
import com.ossms.model.Order;
import com.ossms.repository.DelCustomerRepository;
import com.ossms.repository.DelEmployeRepository;
import com.ossms.repository.DeliveryRepository;
import com.ossms.repository.OrderRepository;
import com.ossms.repository.VehicleRepository;
@Service
public class DeliveryServiceImp implements DeliveryService {
	

		@Autowired
		private DeliveryRepository dRep;
		@Autowired
		private DelCustomerRepository cRep;
		@Autowired
		private VehicleRepository vRep;
		@Autowired
		private OrderRepository oRep;
		@Autowired
		private DelEmployeRepository eRep;
		

		public List<Delivery> getAllDelis(){
			return (List<Delivery>) dRep.findAll();
		}
		
		public List<DelVehicle> getAllVehicles(){
			return (List<DelVehicle>) vRep.findAll();
		}
			
		public List<Order> getAllOrders(){
			return (List<Order>) oRep.findAll();
		}
		
		public List<Employee> getAllEmps(){
			return (List<Employee>) eRep.findEmployeeByTypeContaining("DRV");
		}
		
		@Override
		public List<Customer> getAllCustomers() {
			return (List<Customer>) cRep.findAll();
		}
		
		public void update(Delivery delivery) {
			dRep.save(delivery);
			
		}

		public Delivery get(int orderid) {
			return dRep.findDelivery(orderid);
		}
		

		public void deleteVehicle(int idvehicle) {
			vRep.deleteById(idvehicle);
		}
		
		public void saveVehicle(DelVehicle vehicle) {
			vRep.save(vehicle);
		}
		
		public List<Order> getAllCompletedOrders() {
			return oRep.findCompletedDeliveries();
		}

		public List<Order> getAllIncompletedOrders() {
		
			return oRep.findIncompletedDeliveries();
		}
		
//		public void getdeliveryById(int orderid) {
//			
//			return dRep.findById(orderid).get();v
//		}

		public List<Order> searchStatus(String status) {

			return oRep.searchStatus(status);
		}

		@Override
		public DelVehicle getVehiclesById(int id) {
			return vRep.getVehiclesById(id);
		}

		public Employee getNameOfEmpById(int id){
			return eRep.getNameOfEmpById(id);
		}

		@Override
		public int getCustomerId(int id) {
			return oRep.getCustomerId(id);
		}

		@Override
		public Customer getCustomerName(int id) {
			return cRep.getCustomerName(id);
		}

		@Override
		public List<Order> getAssignedOrders() {
			return oRep.findOrderByDeliveryStatusContaining("Assigned");
		}

		@Override
		public Order findOrder(int orderId) {
			return oRep.findById(orderId).get();
		}

		@Override
		public void saveOrder(Order order) {
			oRep.save(order);
		}

//		@Override
//		public int getOrderId(int id) {
//			
//			return oRep.getOrderId(id);
//		}
	
}
