package com.cabbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.cabbooking.dto.RideDTO;
import com.cabbooking.entity.Ride;

public interface IRideService {
	

	public Ride addRide(Ride ride);

	public Ride updateRide(Ride ride,int rideId);

	public Ride cancleRide(Integer rideId);

	public List<Ride> viewAllRides();

	public Ride viewRideByCustomerId(Integer customerId);

	public List<Ride> viewRideByDriverId(Integer driverId);

	public List<Ride> viewRidesByCabId(Integer cabId);
	
	public List<Ride> viewRidesByStatus(String status);
	
	public List<Ride> viewRidesByDate(LocalDate date);
}
