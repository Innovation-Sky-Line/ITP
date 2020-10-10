package com.ossms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class DelVehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idvehicle")
	private int idvehicle;
	
	@Column(name = "registrationno")
	private String registrationno;
	
	

	public DelVehicle() {
		super();
	}


	public DelVehicle(int idvehicle, String registrationno) {
		super();
		this.idvehicle = idvehicle;
		this.registrationno = registrationno;
	}



	public int getIdvehicle() {
		return idvehicle;
	}



	public void setIdvehicle(int idvehicle) {
		this.idvehicle = idvehicle;
	}



	public String getRegistrationno() {
		return registrationno;
	}



	public void setRegistrationno(String registrationno) {
		this.registrationno = registrationno;
	}



	@Override
	public String toString() {
		return "DelVehicle [idvehicle=" + idvehicle + ", registrationno=" + registrationno + "]";
	}

	
}

