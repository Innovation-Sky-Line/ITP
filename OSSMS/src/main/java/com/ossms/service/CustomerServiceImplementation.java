package com.ossms.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossms.model.Customer;
import com.ossms.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void addCustomer( Customer customer ) {
		
		customerRepository.save(customer);
		
	}

	@Override
	public Customer getCustomer(int id) {
		
		return customerRepository.findById(id).get();
	}

	@Override
	public void deleteCustomer(int id) {
		
		customerRepository.findById(id);
	}

	@Override
	public void update(Customer customer, int id) {
		
		customerRepository.save(customer);
	}

	

}
