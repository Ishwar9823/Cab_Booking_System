package com.cabbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.entity.Driver;
import com.cabbooking.service.ICustomerService;
import com.cabbooking.serviceimpl.IDriverServiceImpl;

import jakarta.persistence.Id;

@RestController
public class DriverController {
	
	@Autowired
	IDriverServiceImpl iDriverServiceImpl;
	
	@PostMapping("/driverregister")
	public Driver addDriver(@RequestBody Driver driver) {
		return iDriverServiceImpl.addDriver(driver);
	}
	
	@PutMapping("/updatedriver/{driverId}")
	public Driver updateDriver(@RequestBody Driver driver,@PathVariable("driverId") int driverId) {
		return iDriverServiceImpl.updateDriver(driver, driverId);
	}
	
	@GetMapping("/viewdriverlist")
	List<Driver> viewDrivers(){
		return iDriverServiceImpl.viewDrivers();
	}
	
	@GetMapping("/viewbyid/{driverId}")
	public Driver viewDriverById(@PathVariable("driverId") int driverId) {
		return iDriverServiceImpl.viewDriverById(driverId);
	}
	
	@GetMapping("/viewbyavabilty")
	public List<Driver> viewDriverByAvailability(){
		return iDriverServiceImpl.viewDriverByAvailability();
	}
	
	
	
}
