package com.ossms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	@Column(name = "idorder")
	private int idOrder;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "customerid")
	private int customerId;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "deliverystatus")
	private String deliveryStatus;
	
	@Column(name = "deliveryaddress")
	private String deliveryAddress;
	

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", date=" + date + ", customerId=" + customerId + ", status=" + status
				+ ", deliveryStatus=" + deliveryStatus + ", deliveryAddress=" + deliveryAddress + "]";
	}


	
	

}

