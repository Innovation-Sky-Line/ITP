package com.ossms.service;



import java.util.List;

import com.ossms.model.Customer;
import com.ossms.model.Order;

public interface CustomerService {

	public void addCustomer(Customer customer);
	
	public String getPasswordByEmail(String email);
	
	public Customer findCustomerByEmail( String email);
	
	public void update(Customer customer , int id);
	
	public void deleteCustomer( Customer customer );

	public Customer getCustomer(int id);
	
	public List<Customer> getallCustomer();

	public List<Order> getIncompleteOrders(int id);
		
	
	
}

