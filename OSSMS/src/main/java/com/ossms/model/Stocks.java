package com.ossms.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="purchasedstock")
public class Stocks {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		@Column(name="idpurchasedstock")
		private int idPurchasedStock;
		
		@Column(name="quantity")
		private String quantity;
		
		@Column(name="purchasedate")
		private String purchaseDate;
		
		@Column(name="paymentid")
		private String paymentID;

		public int getIdPurchasedStock() {
			return idPurchasedStock;
		}

		public void setIdPurchasedStock(int idPurchasedStock) {
			this.idPurchasedStock = idPurchasedStock;
		}

		public String getQuantity() {
			return quantity;
		}

		public void setQuantity(String quantity) {
			this.quantity = quantity;
		}

		public String getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(String purchaseDate) {
			this.purchaseDate = purchaseDate;
		}

		public String getPaymentID() {
			return paymentID;
		}

		public void setPaymentID(String paymentID) {
			this.paymentID = paymentID;
		}



}
