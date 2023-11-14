package com.cabbooking.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@PrimaryKeyJoinColumn
@Entity
public class Driver extends User{
	@NotBlank(message = "Driver name cannot be blank")
	private String driverName;
	@NotBlank(message = "License number cannot be blank")
	private String licenseNo;
	@NotNull(message = "Driver availability cannot be null")
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
