package com.ossms.service;


import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.model.Paymentss;
import com.ossms.model.Supplier;
import com.ossms.repository.PaymentssRepository;


@Service
@Transactional
public class PaymentssServiceImpl implements PaymentssService {
	
	@Autowired
	PaymentssRepository paymentssRepository;
	
	@Override
	public List<Paymentss> getAllPayments() {
		return (List<Paymentss>) paymentssRepository.findAll();
	}


	@Override
	public Paymentss getPaymentssById(int idPayment) {
		return paymentssRepository.findById(idPayment).get();
	}

	public void saveOrUpdate(Paymentss paymentss) {
		paymentssRepository.save(paymentss);
		
	}

	public void deletePaymentss(int idPayment) {
		paymentssRepository.deleteById(idPayment);
		
	}


	@Override
	public List<Paymentss> getPaymentsByDate(String date) {
		return paymentssRepository.findPaymentByPaymentDate(date);
	}

}
