package com.cabbooking.entity;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.cabbooking.util.CabType;




@Entity
public class Cab {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Integer cabId;
	@Enumerated(EnumType.STRING)
	private CabType cabType;
	private Double ratePerKm;
	private String registrationNo;
	private Boolean cabAvailability;
	private String currentLocation;

	@OneToOne 
	private Driver driver;
	
	public Cab(){}

	public Cab(Integer cabId, CabType cabType, Double ratePerKm, String registrationNo, Boolean cabAvailability,
			String currentLocation, Driver driver) {
		super();
		this.cabId = cabId;
		this.cabType = cabType;
		this.ratePerKm = ratePerKm;
		this.registrationNo = registrationNo;
		this.cabAvailability = cabAvailability;
		this.currentLocation = currentLocation;
		this.driver = driver;
	}

	public Integer getCabId() {
		return cabId;
	}

	public void setCabId(Integer cabId) {
		this.cabId = cabId;
	}

	public CabType getCabType() {
		return cabType;
	}

	public void setCabType(CabType cabType) {
		this.cabType = cabType;
	}

	public Double getRatePerKm() {
		return ratePerKm;
	}

	public void setRatePerKm(Double ratePerKm) {
		this.ratePerKm = ratePerKm;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	public Boolean getCabAvailability() {
		return cabAvailability;
	}

	public void setCabAvailability(Boolean cabAvailability) {
		this.cabAvailability = cabAvailability;
	}

	public String getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	@Override
	public String toString() {
		return "Cab [cabId=" + cabId + ", cabType=" + cabType + ", ratePerKm=" + ratePerKm + ", registrationNo="
				+ registrationNo + ", cabAvailability=" + cabAvailability + ", currentLocation=" + currentLocation
				+ ", driver=" + driver + "]";
	}
	
	
	
	
	
	
	
}
