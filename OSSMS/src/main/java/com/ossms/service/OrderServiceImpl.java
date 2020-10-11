package com.ossms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.model.Order;
import com.ossms.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository ord;
	
	@Override
	public List<Order> getPreviousOrders(int customerId) {		
		return ord.getPreviousOrders(customerId);
	}

	@Override
	public Optional<Order> getOrderById(int orderId) {
		return ord.findById(orderId);
	}

	@Override
	public void saveOrder(Order order) {
		ord.save(order);		
	}

	@Override
	public List<Order> getOrdersForMonth(int month) {
		return ord.findOrdersForMonth(month);	
	}

	@Override
	public Order getNewOrder(int cusId) {
		return ord.getNewOrder(cusId);
	}

	@Override
	public List<Order> getPendingOrders(int idCustomer) {
		return ord.getPendingOrders(idCustomer);
	}
	

}
