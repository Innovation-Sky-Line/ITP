package com.ossms.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(OrderDeliveryId.class)
@Table(name = "orderdelivery")
public class Delivery {

	@Id
	@Column(name = "orderid")
	private int orderid;
	
	@Id
	@Column(name = "driverid")
	private int driverid;
	
	@Id
	@Column(name = "vehicleid")
	private int vehicleid;
	
	@Column(name = "deliverydate")
	private LocalDate deliverydate;

	public Delivery() {
		super();
	}

	public Delivery(int orderid, int driverid, int vehicleid, LocalDate deliverydate) {
		super();
		this.orderid = orderid;
		this.driverid = driverid;
		this.vehicleid = vehicleid;
		this.deliverydate = deliverydate;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getDriverid() {
		return driverid;
	}

	public void setDriverid(int driverid) {
		this.driverid = driverid;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public LocalDate getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(LocalDate deliverydate) {
		this.deliverydate = deliverydate;
	}

	@Override
	public String toString() {
		return "Delivery [orderid=" + orderid + ", driverid=" + driverid + ", vehicleid=" + vehicleid
				+ ", deliverydate=" + deliverydate + "]";
	}

	
	
	
	
	
	
	
	
	
}
