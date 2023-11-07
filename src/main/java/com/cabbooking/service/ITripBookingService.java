package com.cabbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.cabbooking.dto.TripBookingDTO;

public interface ITripBookingService {

	public TripBookingDTO addTripBooking(TripBookingDTO tripBooking);

	public TripBookingDTO updateTripBooking(TripBookingDTO tripBooking);

	public TripBookingDTO cancleTripBooking(Integer tripBookingId);

	public List<TripBookingDTO> viewAllBookings();

	public TripBookingDTO viewBookingByBookingId(Integer tripBookingId);

	public List<TripBookingDTO> viewBookingByCustomerId(Integer customerId);

	public List<TripBookingDTO> viewBookingByBookingStatus(String status);

	public List<TripBookingDTO> viewBookingByCabType(String cabType);

	public List<TripBookingDTO> viewBookingsByDatewiseSortingOrder();

	public List<TripBookingDTO> viewBookingsByCustomerBasedOnDates(Integer customerId, LocalDate fromDate, LocalDate toDate);
}
