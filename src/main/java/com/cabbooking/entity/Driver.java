package com.cabbooking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Driver extends User{
	
	private String driverName;
	private String licenseNo;
	private Boolean driverAvailability; 
	
	
	public Driver() {
		
	}
	public Driver(String driverName, String licenseNo, Boolean driverAvailability,int driverId) {
		super();
		this.driverName = driverName;
		this.licenseNo = licenseNo;
		this.driverAvailability = driverAvailability;
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
	
	
	
	
	@Override
	public String toString() {
		return "Driver [driverName=" + driverName + ", licenseNo=" + licenseNo
				+ ", driverAvailability=" + driverAvailability + "]";
	}
	
	
	
	
	
	
	
	
}
