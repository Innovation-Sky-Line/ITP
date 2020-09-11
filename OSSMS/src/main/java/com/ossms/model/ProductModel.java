package com.ossms.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "product")
public class ProductModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idproduct")
	private int idProduct;
	
	@Column(name = "productname")
	private String productName;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "discount")
	private float discount;
	
	@Column(name = "currentstock")
	private int currentStock;
	
	@Column(name = "productimage")
	private Blob[] productImage;
	
	@Column(name = "supplierid")
	private int supplierId;
	
	@Column(name = "categoryid")
	private int categoryId;
	
	@Column(name = "buyinglimit")
	private int buyingLimit;
	
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getCurrentStock() {
		return currentStock;
	}
	public void setCurrentStock(int currentStock) {
		this.currentStock = currentStock;
	}
	
	
	public Blob[] getProductImage() {
		return productImage;
	}
	public void setProductImage(Blob[] productImage) {
		this.productImage = productImage;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getBuyingLimit() {
		return buyingLimit;
	}
	public void setBuyingLimit(int buyingLimit) {
		this.buyingLimit = buyingLimit;
	}
	
	
	
	
}
