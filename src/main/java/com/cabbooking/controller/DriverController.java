package com.cabbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.dto.DriverDTO;
import com.cabbooking.entity.Driver;
import com.cabbooking.exception.DriverBookingException;
import com.cabbooking.service.ICustomerService;
import com.cabbooking.serviceimpl.IDriverServiceImpl;



@RestController
@RequestMapping("driver")
public class DriverController {
	
	@Autowired
	IDriverServiceImpl iDriverServiceImpl;
	
	@PostMapping("/register")
	public DriverDTO addDriver(@Valid @RequestBody Driver driver) throws DriverBookingException{
		return iDriverServiceImpl.addDriver(driver);
	}
	
	@PutMapping("/update/{driverId}")
	public DriverDTO updateDriver(@Valid @RequestBody Driver driver,@PathVariable("driverId") int driverId) throws DriverBookingException{
		return iDriverServiceImpl.updateDriver(driver, driverId);
	}
	
	@GetMapping("/viewdlist")
	List<DriverDTO> viewDrivers() throws DriverBookingException{
		return iDriverServiceImpl.viewDrivers();
	}
	
	@GetMapping("/viewbyid/{driverId}")
	public DriverDTO viewDriverById(@PathVariable("driverId") int driverId) throws DriverBookingException{
		return iDriverServiceImpl.viewDriverById(driverId);
	}
	
	@GetMapping("/viewbyavabilty")
	public List<DriverDTO> viewDriverByAvailability() throws DriverBookingException{
		return iDriverServiceImpl.viewDriverByAvailability();
	}
	
	
	
}
