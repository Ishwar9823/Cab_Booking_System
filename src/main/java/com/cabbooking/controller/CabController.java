package com.cabbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.entity.Cab;
import com.cabbooking.exception.CabBookingException;
import com.cabbooking.serviceimpl.ICabServiceImpl;

@RestController
@RequestMapping("cab")
public class CabController {

	@Autowired
	ICabServiceImpl iCabServiceImpl;
	
	@PostMapping("/register")
	public Cab addCab( @Valid @RequestBody Cab cab) throws CabBookingException {
		return iCabServiceImpl.addCab(cab);//201
	}
	
	
	@PutMapping("/update/{cabId}")
	public Cab updateCab(@Valid  @RequestBody Cab cab,@PathVariable("cabId") int cabId) throws CabBookingException{
		return iCabServiceImpl.updateCab(cab,cabId);//200
	}
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
	@GetMapping("/viewlist")
	public List<Cab> viewCabs()throws CabBookingException{
		return iCabServiceImpl.viewCabs();
	}
	
	@GetMapping("/viewlistbtype/{cabType}")
	public List<Cab> viewCabByType(@PathVariable("cabType") String cabType) throws CabBookingException{
		return iCabServiceImpl.viewCabByType(cabType);
	}
	
	@GetMapping("/viewlistbylocation/{curentLocation}")
	public  List<Cab> viewCabByCurrentLocation(@PathVariable("currentLocation") String currentLocation) throws CabBookingException{
		return iCabServiceImpl.viewCabByCurrentLocation(currentLocation);
	}
	
	@GetMapping("/viewbydriverid/{driverId}")
	public Cab viewCabByDriverId(@PathVariable("driverId") int driverId) throws CabBookingException{
		return iCabServiceImpl.viewCabByDriverId(driverId);
	}
	
	@GetMapping("/viewbycabid/{cabId}")
	public Cab viewCabById (@PathVariable("cabId") int cabId) throws CabBookingException{
		return iCabServiceImpl.viewCabById(cabId);
	}
	
	@GetMapping("/viewbytypeandloc/{cabType}/{currentLocation}")
	public List<Cab> viewCabByTypeAndLocation(@PathVariable("cabType") String cabType,@PathVariable("currentLocation") String currentLocation) throws CabBookingException{
		return iCabServiceImpl.viewCabByTypeAndLocation(cabType, currentLocation);
	}
	
	@GetMapping("/viewbyavailability")
	public List<Cab> viewCabByAvailability() throws CabBookingException{
		return iCabServiceImpl.viewCabByAvailability();
	}
	
	
	
	
	
	
}
