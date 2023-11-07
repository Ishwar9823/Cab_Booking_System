package com.cabbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.entity.Cab;
import com.cabbooking.exception.CabException;
import com.cabbooking.serviceimpl.ICabServiceImpl;

@RestController
public class CabController {

	@Autowired
	ICabServiceImpl iCabServiceImpl;
	
	@PostMapping("/register")
	public Cab addCab(@RequestBody Cab cab)  {
		return iCabServiceImpl.addCab(cab);
	}
	
	@PutMapping("/update/{cabId}")
	public Cab updateCab(@RequestBody Cab cab,@PathVariable("cabId") int cabId) {
		return iCabServiceImpl.updateCab(cab,cabId);
	}
	
	@GetMapping("/viewcabs")
	public List<Cab> viewCabs(){
		return iCabServiceImpl.viewCabs();
	}
	
	@GetMapping("/viewlistbtype/{cabType}")
	public List<Cab> viewCabByType(@PathVariable("cabType") String cabType){
		return iCabServiceImpl.viewCabByType(cabType);
	}
	
	@GetMapping("/viewlistbylocation/{curentLocation}")
	public List<Cab> viewCabByCurrentLocation(@PathVariable("currentLocation") String currentLocation){
		return iCabServiceImpl.viewCabByCurrentLocation(currentLocation);
	}
	
	@GetMapping("/viewbydriverid/{driverId}")
	public Cab viewCabByDriverId(@PathVariable("driverId") int driverId) {
		return iCabServiceImpl.viewCabByDriverId(driverId);
	}
	
	@GetMapping("/viewbycabid/{cabId}")
	public Cab viewCabById (@PathVariable("cabId") int cabId) {
		return iCabServiceImpl.viewCabById(cabId);
	}
	
	@GetMapping("/viewbytypeandloc/{cabType}/{currentLocation}")
	public List<Cab> viewCabByTypeAndLocation(@PathVariable("cabType") String cabType,@PathVariable("currentLocation") String currentLocation){
		return iCabServiceImpl.viewCabByTypeAndLocation(cabType, currentLocation);
	}
	
	@GetMapping("/viewbyavailability")
	public List<Cab> viewCabByAvailability(){
		return iCabServiceImpl.viewCabByAvailability();
	}
	
	
	
	
	
	
}
