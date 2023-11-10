package com.cabbooking.entity;

import java.time.LocalDateTime;
import com.cabbooking.util.RideStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

@Entity
public class Ride {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer rideId;
	private String pickupLocation;
	private String dropoffLocation;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	@Enumerated(EnumType.STRING)
	private RideStatus rideStatus;
	
	

	@OneToOne
	private Cab cab;
	

	@OneToOne
	private Customer customer;
	
	public Ride() {
		
	}

	public Ride(Integer rideId, String pickupLocation, String dropoffLocation, LocalDateTime startTime,
			LocalDateTime endTime, RideStatus rideStatus, Cab cab, Customer customer) {
		super();
		this.rideId = rideId;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.startTime = startTime;
		this.endTime = endTime;
		this.rideStatus = rideStatus;
		this.cab = cab;
		this.customer = customer;
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

	@Override
	public String toString() {
		return "Ride [rideId=" + rideId + ", pickupLocation=" + pickupLocation + ", dropoffLocation=" + dropoffLocation
				+ ", startTime=" + startTime + ", endTime=" + endTime + ", rideStatus=" + rideStatus + ", cab=" + cab
				+ ", customer=" + customer + "]";
	}
	
	


}
