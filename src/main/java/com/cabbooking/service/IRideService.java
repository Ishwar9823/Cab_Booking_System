package com.cabbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.cabbooking.dto.RideDTO;

public interface IRideService {
	

	public RideDTO addRide(RideDTO ride);

	public RideDTO updateRide(RideDTO ride);

	public RideDTO cancleRide(Integer rideId);

	public List<RideDTO> viewAllRides();

	public RideDTO viewRideByCustomerId(Integer customerId);

	public List<RideDTO> viewRideByDriverId(Integer driverId);

	public List<RideDTO> viewRidesByCabId(Integer cabId);
	
	public List<RideDTO> viewRidesByStatus(String status);
	
	public List<RideDTO> viewRidesByDate(LocalDate date);
}
