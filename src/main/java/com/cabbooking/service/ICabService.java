package com.cabbooking.service;

import java.util.List;

import com.cabbooking.dto.CabDTO;
import com.cabbooking.entity.Cab;
import com.cabbooking.exception.CabException;

public interface ICabService {
	
	public Cab addCab(Cab cab) ;

	public Cab updateCab(Cab cab,int cabId);

	public List<Cab> viewCabs();

	public List<Cab> viewCabByType(String cabType);

	public List<Cab> viewCabByCurrentLocation(String currentLocation);
	
	public Cab viewCabByDriverId(int driverId);

	public Cab viewCabById(int cabId);

	public List<Cab> viewCabByTypeAndLocation(String cabType,String currentLocation);

	public List<Cab> viewCabByAvailability();

}
