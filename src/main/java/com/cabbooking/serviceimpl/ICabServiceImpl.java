package com.cabbooking.serviceimpl;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.dto.CabDTO;
import com.cabbooking.entity.Cab;
import com.cabbooking.exception.CabBookingException;
import com.cabbooking.exception.CabException;
import com.cabbooking.repository.CabRepo;
import com.cabbooking.service.ICabService;
import com.cabbooking.util.CabType;

@Service
public class ICabServiceImpl implements ICabService{
	
	@Autowired
	CabRepo cabRepo;
	
	@Override
	public Cab addCab(Cab cab) {
//		Optional<Cab> cabfind = cabRepo.findById(cab.getCabId());
		
			
			cabRepo.save(cab);
			return cab;
		
				
		
	}

	@Override
	public Cab updateCab(Cab cab) {
		Optional<Cab> check = cabRepo.findById(cab.getCabId());
		Cab updateCab = check.get();
		if(check.isPresent()) {
			updateCab.setCabType(cab.getCabType());
			updateCab.setRatePerKm(cab.getRatePerKm());
			updateCab.setRegistrationNo(cab.getRegistrationNo());
			updateCab.setCabAvailability(cab.getCabAvailability());
			updateCab.setCurrentLocation(cab.getCurrentLocation());
			cabRepo.save(updateCab);
			return updateCab;
		}
		return null;
	}

	@Override
	public List<Cab> viewCabs() {
		List<Cab> viewList = new ArrayList<>();
		cabRepo.saveAll(viewList);
		return viewList;
	}

	@Override
	public List<Cab> viewCabByType(String cabType) {
		List<Cab> viewCabsOfTyp = new ArrayList<>();
		List<Cab> allCab = cabRepo.findAll();
		for(Cab cab:allCab) {
			if(cab.getCabType().equals(cabType)) {
			viewCabsOfTyp.add(cab);
			}
		}
		if(!viewCabsOfTyp.isEmpty()) {
			return viewCabsOfTyp;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Cab> viewCabByCurrentLocation(String currentLocation) {
		List<Cab> viewCabsOfLoc = new ArrayList<>();
		List<Cab> allCab = cabRepo.findAll();
		for(Cab cab:allCab) {
			if(cab.getCurrentLocation().equals(currentLocation)) {
			viewCabsOfLoc.add(cab);
			}
		}
		if(!viewCabsOfLoc.isEmpty()) {
			return viewCabsOfLoc;
		}
		else {
			return null;
		}

	}

	@Override
	public Cab viewCabByDriverId(int driverId) {
		Optional<Cab> check = cabRepo.findById(driverId);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
		
	}

	@Override
	public Cab viewCabById(int cabId) {
		Optional<Cab> check = cabRepo.findById(cabId);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			return null;
		}
	}

	@Override
	public List<Cab> viewCabByTypeAndLocation(String cabType, String currentLocation) {
		List<Cab> viewCabs = new ArrayList<>();
		List<Cab> allCab = cabRepo.findAll();
		for(Cab cab : allCab) {
			if(cab.getCurrentLocation().equals(currentLocation)&& cab.getCabType().equals(cabType)) {
				viewCabs.add(cab);
			}
		}
		if(!viewCabs.isEmpty()) {
			return viewCabs;
		}
		else {
			return null;
		}

	}

	@Override
	public List<Cab> viewCabByAvailability() {
		List<Cab> viewCabByAva = new ArrayList<>();
		List<Cab> allCab = cabRepo.findAll();
		for(Cab cab : allCab) {
			if(cab.getCabAvailability()) {
				viewCabByAva.add(cab);
			}
		}
		if(!viewCabByAva.isEmpty()) {
			return viewCabByAva;
		}
		else {
			return null;
		}
	}

}
