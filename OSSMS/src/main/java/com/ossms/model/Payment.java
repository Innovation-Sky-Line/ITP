package com.ossms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@Column(name = "idpayment")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	@Column(name = "paymentdate")
	private LocalDate date;
	@Column(name = "amount")
	private float amount;
	@Column(name = "type")
	private String type;
	@Column(name="orderid")
	private int orderId;
	
	public Payment() {
		
	}
	public Payment(LocalDate date, float amount, String type, int orderId) {
		super();
		this.date = date;
		this.amount = amount;
		this.type = type;
		this.orderId = orderId;
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
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
		
}
