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

import com.cabbooking.entity.Ride;
import com.cabbooking.serviceimpl.IRideServiceImpl;

@RestController
public class RideController {

	@Autowired
	IRideServiceImpl iRideServiceImpl;
	
	@PostMapping("/addride")
	public Ride addRide(@RequestBody Ride ride) {
		return iRideServiceImpl.addRide(ride);
	}
	
	@PutMapping("/update/{rideId}")
	public Ride updateRide(@ RequestBody Ride ride,@PathVariable("rideId") int rideId) {
		return iRideServiceImpl.updateRide(ride, rideId);
	}
	
	@GetMapping("/cancleride/{rideId}")
	public Ride cancleRide(@PathVariable("rideId") int rideId) {
		return iRideServiceImpl.cancleRide(rideId);
	}
	
	@GetMapping("/viewlistride")
	public List<Ride>viewAllRides(){
		return iRideServiceImpl.viewAllRides();
	}
	
	@GetMapping("/viewbycustid/{customerId}")
	public Ride viewRideByCustomerId(@PathVariable("customerId") Integer customerId) {
		return iRideServiceImpl.viewRideByCustomerId(customerId);
	}
	
	@GetMapping("/viewbydriid/{driverId}")
	public List<Ride> viewRideByDriverId(@PathVariable("driverId") int driverId){
		return iRideServiceImpl.viewRideByDriverId(driverId);
	}
	
	@GetMapping("/viewridebycabId/{cabId}")
	public List<Ride> viewRidesByCabId(@PathVariable("cabId") int cabId){
		return iRideServiceImpl.viewRidesByCabId(cabId);
	}
	
	@GetMapping("/viewridebystatus/{status}")
	public List<Ride> viewRidesByStatus(@PathVariable("status") String status){
		return iRideServiceImpl.viewRidesByStatus(status);
	}
	
	@GetMapping("/viewridebydate/{date}")
	public List<Ride> viewRidesByDate(@PathVariable("date")LocalDate date){
		return viewRidesByDate(date);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
