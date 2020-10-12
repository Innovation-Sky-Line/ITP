package com.ossms.service;

import java.util.List;
import java.util.Optional;


import com.ossms.model.Customer;
import com.ossms.model.Order;

public interface OrderService {

	public List<Order> getPreviousOrders(int customerId);
	
	public void saveOrder(Order order);
	
	public List<Order> getOrdersForMonth(int month);
	
	public Order getNewOrder(int cusId);
	
	public List<Order> getPendingOrders( int idCustomer ); 

	public Order getOrderById(int id);
	
	public Customer getCusName(int cusId);
	
	public List<Order> getAllCompletedOrders();
	
	public List<Order> getAllIncompletedOrders();
	
	public List<Order> searchStatus(String status);

}
