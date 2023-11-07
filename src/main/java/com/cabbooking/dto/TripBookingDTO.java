package com.cabbooking.dto;

import java.time.LocalDateTime;

import com.cabbooking.util.BookingStatus;
import com.cabbooking.util.CabType;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString


public class TripBookingDTO {

	private Integer tripBookingId;
	private CustomerDTO customer;
	private CabType cabType;
	private String pickupLocation;
	private String dropoffLocation;
	private LocalDateTime startDateTime;
	private BookingStatus bookingStatus; 
	//Could be generated randomly
	private Double distanceInKm;
	private Double bill;
	
	public TripBookingDTO() {
		
	}

	public TripBookingDTO(Integer tripBookingId, CustomerDTO customer, CabType cabType, String pickupLocation,
			String dropoffLocation, LocalDateTime startDateTime, BookingStatus bookingStatus, Double distanceInKm,
			Double bill) {
		super();
		this.tripBookingId = tripBookingId;
		this.customer = customer;
		this.cabType = cabType;
		this.pickupLocation = pickupLocation;
		this.dropoffLocation = dropoffLocation;
		this.startDateTime = startDateTime;
		this.bookingStatus = bookingStatus;
		this.distanceInKm = distanceInKm;
		this.bill = bill;
	}

	public Integer getTripBookingId() {
		return tripBookingId;
	}

	public void setTripBookingId(Integer tripBookingId) {
		this.tripBookingId = tripBookingId;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
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

	@Override
	public String toString() {
		return "TripBookingDTO [tripBookingId=" + tripBookingId + ", customer=" + customer + ", cabType=" + cabType
				+ ", pickupLocation=" + pickupLocation + ", dropoffLocation=" + dropoffLocation + ", startDateTime="
				+ startDateTime + ", bookingStatus=" + bookingStatus + ", distanceInKm=" + distanceInKm + ", bill="
				+ bill + "]";
	}
	
}

