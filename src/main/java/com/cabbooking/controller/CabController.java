package com.cabbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PutMapping("/update")
	public Cab updateCab(@RequestBody Cab cab) {
		return iCabServiceImpl.updateCab(cab);
	}
	
	
	
	
}
