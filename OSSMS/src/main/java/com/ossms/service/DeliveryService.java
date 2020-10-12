package com.ossms.service;

import java.util.List;

import com.ossms.model.Customer;
import com.ossms.model.Employee;
import com.ossms.model.DelVehicle;
import com.ossms.model.Delivery;
import com.ossms.model.Order;

public interface DeliveryService {
	public List<Delivery> getAllDelis();
	
	public List<DelVehicle> getAllVehicles();
		
	public List<Order> getAllOrders();
	
	public List<Employee> getAllEmps();
	
	public List<Customer> getAllCustomers();
	
	
	
	public DelVehicle getVehiclesById(int id);
	public Employee getNameOfEmpById(int id);
	public int getCustomerId(int id);
	public Customer getCustomerName(int id);
//	public int getOrderId(Order ord);

	
	public void update(Delivery delivery);

	public Delivery get(int orderid);
	
	public Order findOrder(int orderId);
	
	public void saveOrder(Order order);

	public void deleteVehicle(int idvehicle);
	
	public void saveVehicle(DelVehicle vehicle);
	
	public List<Order> getAllCompletedOrders();

	public List<Order> getAllIncompletedOrders();
	
	public List<Order> getAssignedOrders();
	
//	public void getdeliveryById(int orderid) {
//		
//		return dRep.findById(orderid).get();v
//	}

	public List<Order> searchStatus(String status);
}
