package com.ossms.model;

import java.time.LocalDate;


public class CustomerOrder {

	private int orderId;
	private LocalDate date;
	private String name;
	public CustomerOrder(int orderId, LocalDate date, String name) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.name = name;
	}
	public CustomerOrder() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
