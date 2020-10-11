package com.ossms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ossms.model.Customer;

public interface CustomerRepository extends CrudRepository< Customer , Integer > {
	
	String findPasswordByEmail(String email);
	
	Customer findCustomerByEmail( String email);

	@Query(value = "SELECT address FROM customer WHERE idCustomer = :customerId", nativeQuery = true)
	String getAddressById(@Param("customerId")int customerId);
  
}
