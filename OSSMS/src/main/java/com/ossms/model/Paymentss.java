package com.ossms.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Paymentss {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY) 
		@Column(name="idpayment")
		private int idPayment;
		
		@Column(name="paymentdate")
		private String paymentDate;
		
		@Column(name="amount")
		private int amount;
		
		@Column(name="type")
		private String type;
		
		@Column(name="prodid")
		private int prodId;
		

		
		public int getIdPayment() {
			return idPayment;
		}

		public void setIdPayment(int idPayment) {
			this.idPayment = idPayment;
		}

		public String getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(String paymentDate) {
			this.paymentDate = paymentDate;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
			
		public int getProdId() {
			return prodId;
		}

		public void setProdId(int prodId) {
			this.prodId = prodId;
		}
		

		@Override
		public String toString() {
			return "Paymentss [idPayment=" + idPayment + ", paymentDate=" + paymentDate + ", amount=" + amount
					+ ", type=" + type +", prodId=" + prodId  + "]";
		}
		

}
