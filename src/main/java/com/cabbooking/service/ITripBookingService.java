package com.cabbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.cabbooking.dto.TripBookingDTO;
import com.cabbooking.entity.TripBooking;

public interface ITripBookingService {

	public TripBooking addTripBooking(TripBooking tripBooking);

	public TripBooking updateTripBooking(TripBooking tripBooking);

	public TripBooking cancleTripBooking(Integer tripBookingId);

	public List<TripBooking> viewAllBookings();

	public TripBooking viewBookingByBookingId(Integer tripBookingId);

	public List<TripBooking> viewBookingByCustomerId(Integer customerId);

	public List<TripBooking> viewBookingByBookingStatus(String status);

	public List<TripBooking> viewBookingByCabType(String cabType);

	public List<TripBooking> viewBookingsByDatewiseSortingOrder();

	public List<TripBooking> viewBookingsByCustomerBasedOnDates(Integer customerId, LocalDate fromDate, LocalDate toDate);
}
