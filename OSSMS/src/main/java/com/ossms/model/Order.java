package com.ossms.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@Column(name = "idorder")
	private int orderId;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "status")
	private String status;
	@Column(name = "deliverystatus")
	private String deliveryStatus;
	@Column(name = "deliveryaddress")
	private String deliveryAddress;
	@Column(name = "customerid")
	private int customerId;
	
	public Order() {
		
	}
	
	public Order(int customerId) {
		this.customerId = customerId;
	}
	
	public Order(int orderId, LocalDate date, String status, String deliveryStatus, String deliveryAddress,
			int customerId) {
		super();
		this.orderId = orderId;
		this.date = date;
		this.status = status;
		this.deliveryStatus = deliveryStatus;
		this.deliveryAddress = deliveryAddress;
		this.customerId = customerId;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeliveryStatus() {
		return deliveryStatus;
	}
	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}	
	
}
