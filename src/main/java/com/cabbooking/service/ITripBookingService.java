package com.cabbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.cabbooking.dto.TripBookingDTO;
import com.cabbooking.entity.TripBooking;
import com.cabbooking.exception.RideBookingException;
import com.cabbooking.exception.TripBookingException;

public interface ITripBookingService {

	public TripBooking addTripBooking(TripBooking tripBooking) ;

	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException;

	public TripBooking cancleTripBooking(Integer tripBookingId) throws TripBookingException;

	public List<TripBooking> viewAllBookings() throws TripBookingException;

	public TripBooking viewBookingByBookingId(Integer tripBookingId) throws TripBookingException;

	public List<TripBooking> viewBookingByCustomerId(Integer customerId) throws TripBookingException;

	public List<TripBooking> viewBookingByBookingStatus(String status) throws TripBookingException;

	public List<TripBooking> viewBookingByCabType(String cabType) throws TripBookingException;

	public List<TripBooking> viewBookingsByDatewiseSortingOrder() throws TripBookingException;

	public List<TripBooking> viewBookingsByCustomerBasedOnDates(Integer customerId, LocalDate fromDate, LocalDate toDate) throws TripBookingException;
}
