package com.ossms.model;

public class CartItems {
	
	private int prodId;
	private int orderId;
	private String prodName;
	private int qty;
	private float price;
	
	public CartItems(int prodId, int orderId, String prodName, int qty, float price) {
		super();
		this.prodId = prodId;
		this.orderId = orderId;
		this.prodName = prodName;
		this.qty = qty;
		this.price = price;
	}
	
	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartItems [prodId=" + prodId + ", orderId=" + orderId + ", prodName=" + prodName + ", qty=" + qty
				+ ", price=" + price + "]";
	}

}
