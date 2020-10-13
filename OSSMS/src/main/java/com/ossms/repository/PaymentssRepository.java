package com.ossms.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ossms.model.Paymentss;

public interface PaymentssRepository extends CrudRepository<Paymentss, Integer> {
	
	List<Paymentss> findPaymentByPaymentDate(String date);
	
}
