package com.cabbooking.service;

import java.util.List;

import com.cabbooking.dto.DriverDTO;

public interface IDriverService {

	public DriverDTO addDriver(DriverDTO driver);

	public DriverDTO updateDriver(DriverDTO driver);

	public List<DriverDTO> viewDrivers();

	public DriverDTO viewDriverById(Integer driverId);

	public List<DriverDTO> viewDriverByAvailability();
}
