package com.cabbooking.service;

import java.util.List;

import com.cabbooking.dto.DriverDTO;
import com.cabbooking.entity.Driver;
import com.cabbooking.exception.DriverBookingException;

public interface IDriverService {

	public DriverDTO addDriver(Driver driver) throws DriverBookingException;

	public DriverDTO updateDriver(Driver driver,int driverId) throws DriverBookingException;

	public List<DriverDTO> viewDrivers() throws DriverBookingException;

	public DriverDTO viewDriverById(Integer driverId) throws DriverBookingException;

	public List<DriverDTO> viewDriverByAvailability( ) throws DriverBookingException;
	
}
