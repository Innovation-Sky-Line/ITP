package com.ossms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ossms.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

}
