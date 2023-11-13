package com.cabbooking.service;

import java.time.LocalDate;
import java.util.List;

import com.cabbooking.entity.Ride;
import com.cabbooking.exception.RideBookingException;

public interface IRideService {
	

	public Ride addRide(Ride ride) throws RideBookingException;

	public Ride updateRide(Ride ride,int rideId) throws RideBookingException;

	public Ride cancleRide(Integer rideId) throws RideBookingException;

	public List<Ride> viewAllRides() throws RideBookingException;

	public Ride viewRideByCustomerId(Integer customerId) throws RideBookingException;

	public Ride viewRideByDriverId(Integer driverId) throws RideBookingException;

	public Ride viewRidesByCabId(Integer cabId) throws RideBookingException;
	
	public List<Ride> viewRidesByStatus(String status) throws RideBookingException;
	
	public List<Ride> viewRidesByDate(LocalDate date) throws RideBookingException;
}
