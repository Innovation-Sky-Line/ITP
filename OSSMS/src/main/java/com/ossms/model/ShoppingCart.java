package com.ossms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CartId.class)
@Table(name = "shoppingcart")
public class ShoppingCart {

	@Id
	@Column(name = "productid")
	private int productId;
	@Id
	@Column(name = "cusorderid")
	private int orderId;	
	@Column(name = "quantity")
	private int qty;
	
	public ShoppingCart() {
		super();
	}
	public ShoppingCart(int productId, int orderId, int qty) {
		super();
		this.productId = productId;
		this.orderId = orderId;
		this.qty = qty;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "ShoppingCart [orderId=" + orderId + ", productId=" + productId + ", qty=" + qty + "]";
	}
	
	
}
