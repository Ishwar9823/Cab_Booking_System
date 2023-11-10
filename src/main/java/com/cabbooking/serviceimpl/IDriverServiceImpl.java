package com.cabbooking.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.dto.DriverDTO;
import com.cabbooking.entity.Driver;
import com.cabbooking.exception.DriverBookingException;
import com.cabbooking.repository.DriverRepo;
import com.cabbooking.service.IDriverService;

@Service
public class IDriverServiceImpl implements IDriverService{

	@Autowired
	DriverRepo driverRepo;

	@Override
	public DriverDTO addDriver(Driver driver) {

		if(driver.getRoles().equals("Driver")) {
			
			driverRepo.save(driver);
			return toDriverDTO(driver);
		}
		return null;
	}

	@Override
	public DriverDTO updateDriver(Driver driver, int driverId) throws DriverBookingException{

		Optional<Driver> driv = driverRepo.findById(driverId);
		if(driv.isPresent()) {
			driverRepo.save(driver);
			return toDriverDTO(driver);
		}
		else {
			throw new DriverBookingException("Driver not found");
		}
		
		
	}

	@Override
	public List<DriverDTO> viewDrivers() throws DriverBookingException{

		List<DriverDTO> cust =   driverRepo.findAll().stream().map(e->toDriverDTO(e)).collect(Collectors.toList());
		
		if(!cust.isEmpty()) {
			return cust;
		}
		else {
			throw new DriverBookingException("Drivers not found");
		}
	}

	@Override
	public DriverDTO viewDriverById(Integer driverId) throws DriverBookingException{
		
		Optional<Driver> viewById = driverRepo.findAll().stream().filter(e->e.getUserId()==driverId).findAny();
		if(viewById.isPresent()) {
			driverRepo.save(viewById.get());
			return toDriverDTO(viewById.get());
		}
		else {
			throw new DriverBookingException("Driver not found by driverID");
		}
	}

	@Override
	public List<DriverDTO> viewDriverByAvailability() throws DriverBookingException{
		
		List<DriverDTO> driv = driverRepo.findAll().stream().filter(e->e.getDriverAvailability()).map(e->toDriverDTO(e)).collect(Collectors.toList());
		if(!driv.isEmpty()) {
			return driv;
		}
		else {
			throw new DriverBookingException("Drivers not available at the moment");
		}
	}
	private DriverDTO toDriverDTO(Driver driver) {
		
		DriverDTO updateDriver = new DriverDTO();
		updateDriver.setDriverName(driver.getDriverName());
		updateDriver.setLicenseNo(driver.getLicenseNo());
		updateDriver.setDriverAvailability(driver.getDriverAvailability());
		updateDriver.setUserName(driver.getUserName());
		updateDriver.setAddress(driver.getAddress());
		updateDriver.setEmail(driver.getEmail());
		updateDriver.setRoles(driver.getRoles());
		
		return updateDriver;
	}
}
