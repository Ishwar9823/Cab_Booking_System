package com.cabbooking.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import com.cabbooking.util.RideStatus;




@Entity
public class Ride {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rideId;
	@NotBlank(message = "Pickup location cannot be blank")
	private String pickupLocation;
	@NotBlank(message = "Drop-off location cannot be blank")
	private String dropoffLocation;
	@NotNull(message = "Start time cannot be null")
	private LocalDateTime startTime;
	@NotNull(message = "End time cannot be null")
	private LocalDateTime endTime;
	
	@NotNull(message = "Ride status cannot be null")
	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus;
	
	
	
	@OneToOne
	private Cab cab;
	
	@OneToOne
	private Customer customer;
	
	@OneToOne
	private Driver driver;
	
	public Ride() {
		
	}

	public Ride(Integer rideId, String pickupLocation, String dropoffLocation, LocalDateTime startTime,
			LocalDateTime endTime, RideStatus rideStatus, Cab cab, Customer customer,Driver driver) {
		super();
		this.rideId = rideId;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rideStatus = rideStatus;
		this.cab = cab;
		this.customer = customer;
		this.driver = driver;
	}

	public Integer getRideId() {
		return rideId;
	}

	public void setRideId(Integer rideId) {
		this.rideId = rideId;
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

	public Cab getCab() {
		return cab;
	}

	public void setCab(Cab cab) {
		this.cab = cab;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	

}
