package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ossms.model.Customer;

public interface DelCustomerRepository extends JpaRepository<Customer,Integer>{

	@Query(value ="select * from customer where idCustomer = :id", nativeQuery = true)
    Customer getCustomerName(int id);

}
