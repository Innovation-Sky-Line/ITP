package com.ossms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.model.Payment;
import com.ossms.repository.PaymentRepository;
@Service
public class PaymentServiceImpl implements PaymentServices {
	@Autowired
	private PaymentRepository pr;
	
	@Override
	public void makePayment(Payment payment) {
		pr.save(payment);
	}

}
