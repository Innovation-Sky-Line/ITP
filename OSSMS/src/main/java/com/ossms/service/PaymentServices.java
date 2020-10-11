package com.ossms.service;

import java.util.Optional;

import com.ossms.model.Payment;

public interface PaymentServices {

	public void makePayment(Payment payment);
	
	public Optional<Payment> findPayment(int id);
	
	public Payment findPaymentByOrderId(int id);
	
}
