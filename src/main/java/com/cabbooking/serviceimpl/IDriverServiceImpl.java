package com.cabbooking.serviceimpl;

import java.util.List;
import java.util.Optional;

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
		// TODO Auto-generated method stub
		if(driver.getRoles().equals("Customer")) {
			return driverRepo.save(driver);
		}
		return null;
	}

	@Override
	public Driver updateDriver(Driver driver, int driverId) {
		// TODO Auto-generated method stub
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
			
			return driverRepo.save(updateDriver);
		}
		else {
			return null;
		}
		
		
	}

	@Override
	public List<Driver> viewDrivers() {
		// TODO Auto-generated method stub
		return driverRepo.findAll();
	}

	@Override
	public Driver viewDriverById(Integer driverId) {
		// TODO Auto-generated method stub
		Optional<Driver> driv = driverRepo.findById(driverId);
		if(driv.isPresent()) {
			return driv.get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<Driver> viewDriverByAvailability() {
		// TODO Auto-generated method stub
		List<Driver> driv = driverRepo.findAll();
		if(!driv.isEmpty()) {
			for(Driver driver:driv ) {
				if(driver.getDriverAvailability()) {
					driv.add(driver);
				}
			}
			return driv;
		}
		else {
			return null;
		}
	}
	
	
}
