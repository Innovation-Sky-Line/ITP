package com.ossms.model;

public class DeliveryList {

	private Delivery delivery;
	private Customer delCustomer;
	private DelVehicle delVehicle;
	public Order order;
	private Employee delEmployee;
	
	public DeliveryList(Delivery delivery, Customer delCustomer, DelVehicle delVehicle, Order order,
			Employee delEmployee) {
		super();
		this.delivery = delivery;
		this.delCustomer = delCustomer;
		this.delVehicle = delVehicle;
		this.order = order;
		this.delEmployee = delEmployee;
	}
	
	public DeliveryList() {
		super();
	}
	
	public DeliveryList(Delivery delivery, DelVehicle delVehicle, Employee delEmployee, Customer delCustomer) {
		super();
		this.delivery = delivery;
		this.delVehicle = delVehicle;
		this.delEmployee = delEmployee;
		this.delCustomer = delCustomer;
	}



	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Customer getDelCustomer() {
		return delCustomer;
	}

	public void setDelCustomer(Customer delCustomer) {
		this.delCustomer = delCustomer;
	}

	public DelVehicle getDelVehicle() {
		return delVehicle;
	}

	public void setDelVehicle(DelVehicle delVehicle) {
		this.delVehicle = delVehicle;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Employee getEmployee() {
		return delEmployee;
	}

	public void setEmployee(Employee delEmployee) {
		this.delEmployee = delEmployee;
	}

	@Override
	public String toString() {
		return "DeliveryList [delivery=" + delivery + ", delCustomer=" + delCustomer + ", delVehicle=" + delVehicle
				+ ", order=" + order + ", delEmployee=" + delEmployee + "]";
	}
	
	
	
	
}
