package com.ossms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderdelivery")
public class Delivery {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "orderid")
	private int orderid;
	
	@Column(name = "driverid")
	private int driverid;
	
	@Column(name = "vehicleid")
	private int vehicleid;
	
	@Column(name = "deliverydate")
	private Date deliverydate;

	public Delivery() {
		super();
	}

	public Delivery(int orderid, int driverid, int vehicleid, Date deliverydate) {
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

	public Date getDeliverydate() {
		return deliverydate;
	}

	public void setDeliverydate(Date deliverydate) {
		this.deliverydate = deliverydate;
	}

	@Override
	public String toString() {
		return "Delivery [orderid=" + orderid + ", driverid=" + driverid + ", vehicleid=" + vehicleid
				+ ", deliverydate=" + deliverydate + "]";
	}

	
	
	
	
	
	
	
	
	
}
