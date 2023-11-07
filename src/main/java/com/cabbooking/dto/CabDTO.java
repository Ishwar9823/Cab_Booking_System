package com.cabbooking.dto;

import com.cabbooking.util.CabType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class CabDTO {

	private Integer cabId;
	private CabType cabType;
	private DriverDTO driver;
	private Double ratePerKm;
	private String registrationNo;
	private Boolean cabAvailability;
	private String currentLocation;
	
	public CabDTO() {
		
	}

	public CabDTO(Integer cabId, CabType cabType, DriverDTO driver, Double ratePerKm, String registrationNo,
			Boolean cabAvailability, String currentLocation) {
		super();
		this.cabId = cabId;
		this.cabType = cabType;
		this.driver = driver;
		this.ratePerKm = ratePerKm;
		this.registrationNo = registrationNo;
		this.cabAvailability = cabAvailability;
		this.currentLocation = currentLocation;
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

	public DriverDTO getDriver() {
		return driver;
	}

	public void setDriver(DriverDTO driver) {
		this.driver = driver;
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

	@Override
	public String toString() {
		return "CabDTO [cabId=" + cabId + ", cabType=" + cabType + ", driver=" + driver + ", ratePerKm=" + ratePerKm
				+ ", registrationNo=" + registrationNo + ", cabAvailability=" + cabAvailability + ", currentLocation="
				+ currentLocation + "]";
	}
	
}
