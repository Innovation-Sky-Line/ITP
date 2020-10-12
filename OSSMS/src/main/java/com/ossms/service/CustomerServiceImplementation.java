package com.ossms.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ossms.model.Customer;

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
	public String getPasswordByEmail(String email) {
		
		return customerRepository.findPasswordByEmail(email);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		
		
		return customerRepository.findCustomerByEmail(email);
	}
	
	@Override
	public String getAddressById(int userId) {
		return customerRepository.getAddressById(userId);
	}

	@Override
	public List<Customer> searchResult(String name) {
		
		return customerRepository.findCustomerByFirstName(name);
	}

	@Override
	public Customer getCustomerByFirstname(String name) {
		
		String email = customerRepository.findEmailByFirstname(name);
		
		return customerRepository.findCustomerByEmail(email);
	}

}
