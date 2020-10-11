package com.ossms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ossms.model.Customer;
@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
