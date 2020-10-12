package com.ossms.service;



import java.util.List;

import com.ossms.model.Paymentss;


public interface PaymentssService {
	
	public List<Paymentss> getAllPayments();

	public Paymentss getPaymentssById(int idPayment);
	
	public void saveOrUpdate(Paymentss paymentss);
	
	public void deletePaymentss(int idPayment);

}
