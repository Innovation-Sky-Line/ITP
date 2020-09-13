package com.ossms.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ossms.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{

	@Query(value="SELECT * FROM payment WHERE orderId = :orderId", nativeQuery = true)
	Payment findPaymentByOrderId(@Param("orderId") int orderId);
}
