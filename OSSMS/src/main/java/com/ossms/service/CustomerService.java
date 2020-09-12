package com.ossms.service;

import com.ossms.model.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);
	
	public Customer getCustomer( int id);
	
	public void update(Customer customer , int id);
	
	public void deleteCustomer( int id );


	
	
}

