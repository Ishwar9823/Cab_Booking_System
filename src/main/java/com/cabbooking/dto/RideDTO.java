package com.cabbooking.dto;

import java.time.LocalDateTime;

import com.cabbooking.util.RideStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
@ToString
public class RideDTO {
	
	private Integer rideId;
	private CustomerDTO customer;
	private CabDTO cab;
	private String pickupLocation;
	private String dropoffLocation;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private RideStatus rideStatus;
	
	public RideDTO() {
		
	}

	public RideDTO(Integer rideId, CustomerDTO customer, CabDTO cab, String pickupLocation, String dropoffLocation,
			LocalDateTime startTime, LocalDateTime endTime, RideStatus rideStatus) {
		super();
		this.rideId = rideId;
		this.customer = customer;
		this.cab = cab;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rideStatus = rideStatus;
	}

	public Integer getRideId() {
		return rideId;
	}

	public void setRideId(Integer rideId) {
		this.rideId = rideId;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public CabDTO getCab() {
		return cab;
	}

	public void setCab(CabDTO cab) {
		this.cab = cab;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropoffLocation() {
		return dropoffLocation;
	}

	public void setDropoffLocation(String dropoffLocation) {
		this.dropoffLocation = dropoffLocation;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public RideStatus getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}

	@Override
	public String toString() {
		return "RideDTO [rideId=" + rideId + ", customer=" + customer + ", cab=" + cab + ", pickupLocation="
				+ pickupLocation + ", dropoffLocation=" + dropoffLocation + ", startTime=" + startTime + ", endTime="
				+ endTime + ", rideStatus=" + rideStatus + "]";
	}
	
	
}
