package com.ossms.service;

import com.ossms.model.Customer;


public interface CustomerService {

	public void addCustomer(Customer customer);
	
	public String getPasswordByEmail(String email);
	
	public Customer findCustomerByEmail( String email);
	
	public void update(Customer customer , int id);
	
	public void deleteCustomer( Customer customer );

	public Customer getCustomer(int id);
  
  public String getAddressById(int userId);	
	
}

