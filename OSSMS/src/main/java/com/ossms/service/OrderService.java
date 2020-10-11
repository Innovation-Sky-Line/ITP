package com.ossms.service;

import java.util.List;

import com.ossms.model.Customer;
import com.ossms.model.Order;

public interface OrderService {
	
	public Order getOrderById(int id);
	
	public Customer getCusName(int cusId);
	
	public List<Order> getAllCompletedOrders();
	
	public List<Order> getAllIncompletedOrders();
	
	public Order saveOrder(Order order);
	
	public List<Order> getOrdersForMonth(int month);
	
	public List<Order> searchStatus(String status);

}
