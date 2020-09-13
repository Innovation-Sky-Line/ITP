package com.ossms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository cr;
	
	@Override
	public String getAddressById(int userId) {
		return cr.getAddressById(userId);
	}

}
