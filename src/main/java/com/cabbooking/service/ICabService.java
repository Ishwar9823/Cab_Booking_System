package com.cabbooking.service;

import java.util.List;

import com.cabbooking.dto.CabDTO;
import com.cabbooking.entity.Cab;
import com.cabbooking.exception.CabBookingException;

public interface ICabService {
	
	public Cab addCab(Cab cab) throws CabBookingException ;

	public Cab updateCab(Cab cab,int cabId) throws CabBookingException;

	public List<Cab> viewCabs() throws CabBookingException;

	public List<Cab> viewCabByType(String cabType) throws CabBookingException;

	public List<Cab> viewCabByCurrentLocation(String currentLocation)throws CabBookingException;
	
	public Cab viewCabByDriverId(int driverId) throws CabBookingException;

	public Cab viewCabById(int cabId) throws CabBookingException;

	public List<Cab> viewCabByTypeAndLocation(String cabType,String currentLocation)throws CabBookingException;

	public List<Cab> viewCabByAvailability() throws CabBookingException;

}
