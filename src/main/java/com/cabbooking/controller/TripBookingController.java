package com.cabbooking.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.entity.TripBooking;
import com.cabbooking.exception.TripBookingException;
import com.cabbooking.serviceimpl.ITripBookingServiceImpl;


@RestController
@RequestMapping("tripbooking")
public class TripBookingController {
	
	@Autowired
	ITripBookingServiceImpl iTripBookingServiceImpl;
	
	@PostMapping("/adddata")
	public TripBooking addTripBooking(@Valid @RequestBody TripBooking tripBooking) {
		return iTripBookingServiceImpl.addTripBooking(tripBooking);
	}
	
	@PutMapping("/update")
	public TripBooking updateTripBooking(@Valid @RequestBody TripBooking tripBooking) throws TripBookingException{
		
		return iTripBookingServiceImpl.updateTripBooking(tripBooking);
	}
	
	@PutMapping("/cancletrip/{tripBookingId}")
	public TripBooking cancleTripBooking(@PathVariable("tripBookingId") int tripBookingId) throws TripBookingException{
		return iTripBookingServiceImpl.cancleTripBooking(tripBookingId);
	}
	
	@GetMapping("/viewbookinglist")
	public List<TripBooking> viewAllBookings() throws TripBookingException{
		return iTripBookingServiceImpl.viewAllBookings();
	}
	
	@GetMapping("/viewbybookingid/{tripBookingId}")
	public TripBooking viewBookingByBookingId(@PathVariable("tripBookingId") int tripBookingId) throws TripBookingException{
		return iTripBookingServiceImpl.viewBookingByBookingId(tripBookingId);
	}
	
	@GetMapping("/viewlistbycustid/{customerId}")
	public List<TripBooking> viewBookingByCustomerId(@PathVariable("customerId") int customerId) throws TripBookingException{
		return iTripBookingServiceImpl.viewBookingByCustomerId(customerId);
	}
	
	@GetMapping("/viewlistbystatus/{status}")
	public List<TripBooking> viewBookingByBookingStatus(@PathVariable("status") String status) throws TripBookingException{
		return iTripBookingServiceImpl.viewBookingByBookingStatus(status);
	}
	
	@GetMapping("/viewlistbycabtype/{cabType}")
	public List<TripBooking> viewBookingByCabType(@PathVariable("cabType") String cabType) throws TripBookingException{
		return iTripBookingServiceImpl.viewBookingByCabType(cabType);
	}
	
	@GetMapping("/viewlistbydatesorting")
	public List<TripBooking> viewBookingsByDatewiseSortingOrder() throws TripBookingException{
		return iTripBookingServiceImpl.viewBookingsByDatewiseSortingOrder();
	}
	
	@GetMapping("/viewlistbyidanddate/{custId}/{fromDate}/{toDate}")
	public List<TripBooking> viewBookingsByCustomerBasedOnDates(@PathVariable("custId") int customerId,@PathVariable("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,@PathVariable("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate toDate)
			throws TripBookingException{
		return iTripBookingServiceImpl.viewBookingsByCustomerBasedOnDates(customerId, fromDate, toDate);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
