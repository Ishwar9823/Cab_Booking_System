package com.cabbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Driver extends User{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverId;
	private String driverName;
	private String licenseNo;
	private Boolean driverAvailability;
	
	@OneToOne
	@JsonIgnore
	private Cab cab;
	
	public Driver() {
		
	}
	public Driver(String driverName, String licenseNo, Boolean driverAvailability,int driverId,Cab cab ) {
		super();
		this.driverName = driverName;
		this.licenseNo = licenseNo;
		this.driverAvailability = driverAvailability;
		this.driverId = driverId;
		this.cab = cab;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public Boolean getDriverAvailability() {
		return driverAvailability;
	}
	public void setDriverAvailability(Boolean driverAvailability) {
		this.driverAvailability = driverAvailability;
	}
	
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	
	public Cab getCab() {
		return cab;
	}
	public void setCab(Cab cab) {
		this.cab = cab;
	}
	@Override
	public String toString() {
		return "Driver [driverId=" + driverId + ", driverName=" + driverName + ", licenseNo=" + licenseNo
				+ ", driverAvailability=" + driverAvailability + ", cab=" + cab + "]";
	}
	
	
	
	
	
	
	
}
