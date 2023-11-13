package com.cabbooking.entity;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
