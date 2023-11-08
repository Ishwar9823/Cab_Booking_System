package com.cabbooking.service;

import java.util.List;

import com.cabbooking.dto.DriverDTO;
import com.cabbooking.entity.Driver;

public interface IDriverService {

	public Driver addDriver(Driver driver);

	public Driver updateDriver(Driver driver,int driverId);

	public List<Driver> viewDrivers();

	public Driver viewDriverById(Integer driverId);

	public List<Driver> viewDriverByAvailability();
}
