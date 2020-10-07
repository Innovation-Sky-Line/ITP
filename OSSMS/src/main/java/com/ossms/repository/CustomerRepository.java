package com.ossms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ossms.model.Customer;

public interface CustomerRepository extends CrudRepository< Customer , Integer > {
	
	String findPasswordByEmail(String email);
	
	Customer findCustomerByEmail( String email);
	
}
