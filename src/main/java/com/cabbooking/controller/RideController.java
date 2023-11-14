package com.cabbooking.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

import com.cabbooking.entity.Ride;
import com.cabbooking.exception.RideBookingException;
import com.cabbooking.serviceimpl.IRideServiceImpl;

@RestController
@RequestMapping("ride")
public class RideController {

	@Autowired
	IRideServiceImpl iRideServiceImpl;
	
	@PostMapping("/add")
	public Ride addRide(@Valid @RequestBody Ride ride) {
		return iRideServiceImpl.addRide(ride);
	}
	
	@PutMapping("/update/{rideId}")
	public Ride updateRide( @Valid @RequestBody Ride ride,@PathVariable("rideId") int rideId) throws RideBookingException{
		return iRideServiceImpl.updateRide(ride, rideId);
	}
	
	@GetMapping("/cancleride/{rideId}")
	public Ride cancleRide(@PathVariable("rideId") int rideId) throws RideBookingException{
		
		return iRideServiceImpl.cancleRide(rideId);
	}
	
	@GetMapping("/viewlist")
	public List<Ride>viewAllRides() throws RideBookingException{
		return iRideServiceImpl.viewAllRides();
	}
	
	@GetMapping("/viewbycustid/{customerId}")
	public Ride viewRideByCustomerId(@PathVariable("customerId") Integer customerId) throws RideBookingException{
		return iRideServiceImpl.viewRideByCustomerId(customerId);
	}
	
	@GetMapping("/viewbydriverid/{driverId}")
	public Ride viewRideByDriverId(@PathVariable("driverId") int driverId) throws RideBookingException{
		return iRideServiceImpl.viewRideByDriverId(driverId);
	}
	
	@GetMapping("/viewbycabId/{cabId}")
	public Ride viewRidesByCabId(@PathVariable("cabId") int cabId) throws RideBookingException{
		return iRideServiceImpl.viewRidesByCabId(cabId);
	}
	
	@GetMapping("/viewbystatus/{status}")
	public List<Ride> viewRidesByStatus(@PathVariable("status") String status) throws RideBookingException{
		return iRideServiceImpl.viewRidesByStatus(status);
	}
	
	@GetMapping("/viewbydate/{date}")
	public List<Ride> viewRidesByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws RideBookingException {
		
	    return iRideServiceImpl.viewRidesByDate(date);
	}

	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
}
