package com.ossms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@Column(name = "idpayment")
	private int paymentId;
	@Column(name = "paymentdate")
	private LocalDate date;
	@Column(name = "amount")
	private float amount;
	@Column(name = "type")
	private String type;
	
	public Payment(int paymentId, LocalDate date, float amount, String type) {
		super();
		this.paymentId = paymentId;
		this.date = date;
		this.amount = amount;
		this.type = type;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
		
}
