package com.ossms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;




@Entity
@Component
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
	private String productImage;
	
	@Column(name = "supplierid")
	private Integer supplierId;
	
	@Column(name = "categoryid")
	private Integer categoryId;
	
	@Column(name = "buyinglimit")
	private int buyingLimit;
	

	
	public ProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ProductModel(int idProduct, String productName, float price, float discount, int currentStock,
			String productImage, Integer supplierId, Integer categoryId, int buyingLimit) {
		super();
		this.idProduct = idProduct;
		this.productName = productName;
		this.price = price;
		this.discount = discount;
		this.currentStock = currentStock;
		this.productImage = productImage;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.buyingLimit = buyingLimit;
	}



	public ProductModel(String productName, float price, float discount, int currentStock, String productImage,
			int supplierId, int categoryId, int buyingLimit) {
		super();
		this.productName = productName;
		this.price = price;
		this.discount = discount;
		this.currentStock = currentStock;
		this.productImage = productImage;
		this.supplierId = supplierId;
		this.categoryId = categoryId;
		this.buyingLimit = buyingLimit;
	}


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
	
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public Integer getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public int getBuyingLimit() {
		return buyingLimit;
	}
	public void setBuyingLimit(int buyingLimit) {
		this.buyingLimit = buyingLimit;
	}
	
	
	
	
}
