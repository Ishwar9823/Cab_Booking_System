package com.cabbooking.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.entity.TripBooking;
import com.cabbooking.serviceimpl.ITripBookingServiceImpl;


@RestController
public class TripBookingController {
	
	@Autowired
	ITripBookingServiceImpl iTripBookingServiceImpl;
	
	@PostMapping("/tripbookdata")
	public TripBooking addTripBooking(@RequestBody TripBooking tripBooking) {
		return iTripBookingServiceImpl.addTripBooking(tripBooking);
	}
	
	@PutMapping("/updatetrip")
	public TripBooking updateTripBooking(@RequestBody TripBooking tripBooking) {
		return iTripBookingServiceImpl.updateTripBooking(tripBooking);
	}
	
	@PutMapping("/cancletrip/{tripBookingId}")
	public TripBooking cancleTripBooking(@PathVariable("tripBookingid") int tripBookingId) {
		return iTripBookingServiceImpl.cancleTripBooking(tripBookingId);
	}
	
	@GetMapping("/viewbookinglist")
	public List<TripBooking> viewAllBookings(){
		return iTripBookingServiceImpl.viewAllBookings();
	}
	
	@GetMapping("/viewbybookingid/{tripBookingId}")
	public TripBooking viewBookingByBookingId(@PathVariable("tripBookingid") int tripBookingId) {
		return iTripBookingServiceImpl.viewBookingByBookingId(tripBookingId);
	}
	
	@GetMapping("/viewbookinglistbycustid/{customerId}")
	public List<TripBooking> viewBookingByCustomerId(@PathVariable("customerId") int customerId){
		return iTripBookingServiceImpl.viewBookingByCustomerId(customerId);
	}
	
	@GetMapping("/viewlistbookingbystatus/{status}")
	public List<TripBooking> viewBookingByBookingStatus(@PathVariable("status") String status){
		return iTripBookingServiceImpl.viewBookingByBookingStatus(status);
	}
	
	@GetMapping("/viewlistbycabtype/{cabType}")
	public List<TripBooking> viewBookingByCabType(@PathVariable("cabType") String cabType){
		return iTripBookingServiceImpl.viewBookingByCabType(cabType);
	}
	
	@GetMapping("/viewlistbydatesorting")
	public List<TripBooking> viewBookingsByDatewiseSortingOrder(){
		return iTripBookingServiceImpl.viewBookingsByDatewiseSortingOrder();
	}
	
	@GetMapping("/viewlistbyidanddate/{custId}/{fromDate}/{toDate}")
	public List<TripBooking> viewBookingsByCustomerBasedOnDates(@PathVariable("custId") int customerId,@PathVariable("fromDate") LocalDate fromDate,@PathVariable("toDate") LocalDate toDate)
	{
		return iTripBookingServiceImpl.viewBookingsByCustomerBasedOnDates(customerId, fromDate, toDate);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
