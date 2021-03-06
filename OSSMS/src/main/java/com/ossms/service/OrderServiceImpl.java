package com.ossms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossms.model.Customer;
import com.ossms.model.Order;
import com.ossms.repository.CustomerRepository;
import com.ossms.repository.OrderRepository;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	CustomerRepository cusRepo;


	@Override
	public Order getOrderById(int id) {
		
		return orderRepo.findById(id).get();
	}

	@Override
	public Customer getCusName(int cusId) {
		return cusRepo.findById(cusId).get();
	}

	@Override
	public List<Order> getAllCompletedOrders() {
		return orderRepo.findCompletedOrders();
	}

	@Override
	public List<Order> getAllIncompletedOrders() {
	
		return orderRepo.findIncompletedOrders();
	}

	@Override
	public List<Order> getOrdersForMonth(int month) {
		
		return orderRepo.findOrdersForMonth(month);
	}

	@Override
	public List<Order> searchStatus(String status) {
		return orderRepo.searchStatus(status);
	}

	@Override
	public List<Order> getPreviousOrders(int customerId) {		
		return orderRepo.getPreviousOrders(customerId);
	}

	@Override
	public Order getNewOrder(int cusId) {
		return orderRepo.getNewOrder(cusId);
	}

	@Override
	public List<Order> getPendingOrders(int idCustomer) {
		return orderRepo.getPendingOrders(idCustomer);
	}

	@Override
	public List<Order> getOrderDetailsForList(int idCustomer) {
		
		return orderRepo.getOrderDetailsForList(idCustomer);
	}

	@Override
	public void saveOrder(Order order) {
		orderRepo.save(order);		
	}
	
	
}
