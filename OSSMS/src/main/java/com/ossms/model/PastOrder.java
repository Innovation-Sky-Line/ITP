package com.ossms.model;

public class PastOrder {
	
	private float total;
	private Order order;

	public PastOrder(Order order, float total) {
		this.order = order;
		this.total = total;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
	
	
}

