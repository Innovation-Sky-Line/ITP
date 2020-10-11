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
	public Order saveOrder(Order order) {
		
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getOrdersForMonth(int month) {
		
		return orderRepo.findOrdersForMonth(month);
	}

	@Override
	public List<Order> searchStatus(String status) {
		return orderRepo.searchStatus(status);
	}
	
	
	
	
}
