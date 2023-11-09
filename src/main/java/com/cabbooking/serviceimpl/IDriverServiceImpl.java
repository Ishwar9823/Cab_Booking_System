package com.cabbooking.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.entity.Driver;
import com.cabbooking.repository.DriverRepo;
import com.cabbooking.service.IDriverService;

@Service
public class IDriverServiceImpl implements IDriverService{

	@Autowired
	DriverRepo driverRepo;

	@Override
	public Driver addDriver(Driver driver) {

		if(driver.getRoles().equals("Driver")) {
			return driverRepo.save(driver);
		}
		return null;
	}

	@Override
	public Driver updateDriver(Driver driver, int driverId) {

		Optional<Driver> driv = driverRepo.findById(driverId);
		if(driv.isPresent()) {
			Driver updateDriver = driv.get();
			updateDriver.setDriverName(driver.getDriverName());
			updateDriver.setLicenseNo(driver.getLicenseNo());
			updateDriver.setDriverAvailability(driver.getDriverAvailability());
			updateDriver.setUserName(driver.getUserName());
			updateDriver.setPassword(driver.getPassword());
			updateDriver.setAddress(driver.getAddress());
			updateDriver.setMobileNumber(driver.getMobileNumber());
			updateDriver.setEmail(driver.getEmail());
			updateDriver.setRoles(driver.getRoles());
			updateDriver.setCab(driver.getCab());
			
			return driverRepo.save(updateDriver);
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public List<Driver> viewDrivers() {

		return driverRepo.findAll();
	}

	@Override
	public Driver viewDriverById(Integer driverId) {
		
		Optional<Driver> viewById = driverRepo.findAll().stream().filter(e->e.getUserId()==driverId).findAny();
		if(viewById.isPresent()) {
			return viewById.get();
		}
		else {
			return null;
		}
	}

	@Override
	public List<Driver> viewDriverByAvailability() {
		
		List<Driver> driv = driverRepo.findAll().stream().filter(e->e.getDriverAvailability()).collect(Collectors.toList());
		if(!driv.isEmpty()) {
			return driv;
		}
		else {
			return null;
		}
	}
}
