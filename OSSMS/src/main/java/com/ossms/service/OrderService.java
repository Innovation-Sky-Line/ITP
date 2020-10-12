package com.ossms.service;

import java.util.List;
import java.util.Optional;

import com.ossms.model.Order;

public interface OrderService {

	public List<Order> getPreviousOrders(int customerId);
	
	public Optional<Order> getOrderById(int orderId);
	
	public void saveOrder(Order order);
	
	public List<Order> getOrdersForMonth(int month);
	
	public Order getNewOrder(int cusId);
	
	public List<Order> getPendingOrders( int idCustomer );
	
	public List <Order> getOrderDetailsForList(int idCustomer);
	
}
