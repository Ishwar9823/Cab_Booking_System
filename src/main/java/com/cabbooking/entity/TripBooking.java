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
import com.cabbooking.util.BookingStatus;
import com.cabbooking.util.CabType;


@Entity



public class TripBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tripBookingId;
	
	@NotNull(message = "Cab type cannot be null")
	@Enumerated( EnumType.STRING)
	private CabType cabType;
	@NotBlank(message = "Pickup location cannot be blank")
	private String pickupLocation;
	@NotBlank(message = "Drop-off location cannot be blank")
	private String dropoffLocation;
	@NotNull(message = "Start date and time cannot be null")
	private LocalDateTime startDateTime;
	@NotNull(message = "Booking status cannot be null")
	@Enumerated(EnumType.STRING)
	private BookingStatus bookingStatus;
	// Could be generated randomly
	@NotNull(message = "Distance in kilometers cannot be null")
	private Double distanceInKm;
	@NotNull(message = "Bill cannot be null")
	private Double bill;
	
	
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
