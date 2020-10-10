package com.ossms.model;

public class DeliveryList {

	private Delivery delivery;
	private DelCustomer delCustomer;
	private DelVehicle delVehicle;
	public DeliveryList(Delivery delivery, DelCustomer delCustomer, DelVehicle delVehicle) {
		super();
		this.delivery = delivery;
		this.delCustomer = delCustomer;
		this.delVehicle = delVehicle;
	}
	public Delivery getDelivery() {
		return delivery;
	}
	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	public DelCustomer getDelCustomer() {
		return delCustomer;
	}
	public void setDelCustomer(DelCustomer delCustomer) {
		this.delCustomer = delCustomer;
	}
	public DelVehicle getDelVehicle() {
		return delVehicle;
	}
	public void setDelVehicle(DelVehicle delVehicle) {
		this.delVehicle = delVehicle;
	}
	@Override
	public String toString() {
		return "DeliveryList [delivery=" + delivery + ", delCustomer=" + delCustomer + ", delVehicle=" + delVehicle
				+ "]";
	}
	
	
}
