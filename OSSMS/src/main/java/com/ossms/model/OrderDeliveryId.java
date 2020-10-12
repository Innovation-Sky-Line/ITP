package com.ossms.model;

import java.io.Serializable;

public class OrderDeliveryId implements Serializable{

	private int orderid;
	private int driverid;
	private int vehicleid;
	public OrderDeliveryId() {
		super();
	}
	public OrderDeliveryId(int orderId, int driverId, int vehicleId) {
		super();
		this.orderid = orderId;
		this.driverid = driverId;
		this.vehicleid = vehicleId;
	}
	public int getOrderId() {
		return orderid;
	}
	public void setOrderId(int orderId) {
		this.orderid = orderId;
	}
	public int getDriverId() {
		return driverid;
	}
	public void setDriverId(int driverId) {
		this.driverid = driverId;
	}
	public int getVehicleId() {
		return vehicleid;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleid = vehicleId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + driverid;
		result = prime * result + orderid;
		result = prime * result + vehicleid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDeliveryId other = (OrderDeliveryId) obj;
		if (driverid != other.driverid)
			return false;
		if (orderid != other.orderid)
			return false;
		if (vehicleid != other.vehicleid)
			return false;
		return true;
	}
	
	
	
}
