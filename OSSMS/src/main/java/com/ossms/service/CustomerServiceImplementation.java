package com.ossms.service;



import java.util.ArrayList;
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
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public void addCustomer( Customer customer ) {
		
		customerRepository.save(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
	
		return customerRepository.findById(id).get();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		
		customerRepository.delete(customer);
	}

	@Override
	public void update(Customer customer, int id) {
		
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getallCustomer() {
		
		List <Customer> customer = new ArrayList<Customer>();
		
		for(Customer customers : customerRepository.findAll()) {
			
			customer.add(customers);
		}
		
		return customer;
	}

	@Override
	public String getPasswordByEmail(String email) {
		
		return customerRepository.findPasswordByEmail(email);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		
		
		return customerRepository.findCustomerByEmail(email);
	}

	@Override
	public List<Order> getIncompleteOrders(int id) {
		
		List <Order> orders = (List<Order>) orderRepository.findOrderBycustomerId(id);
		
			for(Order order : orders) {
			
			if(order.getStatus()=="Not Delivered")
			{
				
				orders.add(order);
				
			}	
			
		}
		
		return orders;
	}

	

}
