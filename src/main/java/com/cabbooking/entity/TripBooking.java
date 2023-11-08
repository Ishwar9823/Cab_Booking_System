package com.cabbooking.entity;

import java.time.LocalDateTime;

import com.cabbooking.util.BookingStatus;
import com.cabbooking.util.CabType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter

public class TripBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	
	
	private CabType cabType;
	
	private String pickupLocation;
//	@Nonnull
	private String dropoffLocation;
//	@Nonnull
	private LocalDateTime startDateTime;
	@Nonnull
	private BookingStatus bookingStatus;
	// Could be generated randomly
	
	private Double distanceInKm;
	
	private Double bill;
	
	@JsonIgnore
	@OneToOne
	private Customer customer;
	

	public TripBooking() {
		
	}
	public TripBooking(Integer tripBookingId, CabType cabType, String pickupLocation, String dropoffLocation,
			LocalDateTime startDateTime, BookingStatus bookingStatus, Double distanceInKm, Double bill,
			Customer customer) {
		super();
		this.tripBookingId = tripBookingId;
		this.cabType = cabType;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.startDateTime = startDateTime;
		this.bookingStatus = bookingStatus;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
		this.customer = customer;
	}
	public Integer getTripBookingId() {
		return tripBookingId;
	}
	public void setTripBookingId(Integer tripBookingId) {
		this.tripBookingId = tripBookingId;
	}
	public CabType getCabType() {
		return cabType;
	}
	public void setCabType(CabType cabType) {
		this.cabType = cabType;
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
	public LocalDateTime getStartDateTime() {
		return startDateTime;
	}
	public void setStartDateTime(LocalDateTime startDateTime) {
		this.startDateTime = startDateTime;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public Double getDistanceInKm() {
		return distanceInKm;
	}
	public void setDistanceInKm(Double distanceInKm) {
		this.distanceInKm = distanceInKm;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "TripBooking [tripBookingId=" + tripBookingId + ", cabType=" + cabType + ", pickupLocation="
				+ pickupLocation + ", dropoffLocation=" + dropoffLocation + ", startDateTime=" + startDateTime
				+ ", bookingStatus=" + bookingStatus + ", distanceInKm=" + distanceInKm + ", bill=" + bill
				+ ", customer=" + customer + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
