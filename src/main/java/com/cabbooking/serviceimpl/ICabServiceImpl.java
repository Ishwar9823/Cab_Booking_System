package com.cabbooking.serviceimpl;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.dto.CabDTO;
import com.cabbooking.entity.Cab;
import com.cabbooking.exception.CabBookingException;
import com.cabbooking.repository.CabRepo;
import com.cabbooking.service.ICabService;
import com.cabbooking.util.CabType;

@Service
public class ICabServiceImpl implements ICabService{
	
	@Autowired
	CabRepo cabRepo;
	
	@Override
	public Cab addCab(Cab cab) throws CabBookingException {
			cabRepo.save(cab);
			return cab;
	}

	@Override
	public Cab updateCab(Cab cab,int cabId) throws CabBookingException{
		Optional<Cab> check = cabRepo.findById(cab.getCabId());
		Cab updateCab = check.get();
		if(check.isPresent()) {
			if(Objects.nonNull(cab.getCabType()))
		     {
				updateCab.setCabType(cab.getCabType());
			}
			if(Objects.nonNull(cab.getRatePerKm())) {
				updateCab.setRatePerKm(cab.getRatePerKm());
			}
			if(Objects.nonNull(cab.getRegistrationNo())) {
				updateCab.setRegistrationNo(cab.getRegistrationNo());
			}
			if(Objects.nonNull(cab.getCabAvailability())) {
				updateCab.setCabAvailability(cab.getCabAvailability());
			}
			if(Objects.nonNull(cab.getCurrentLocation())) {
				updateCab.setCurrentLocation(cab.getCurrentLocation());
			}
			cabRepo.save(updateCab);
			return updateCab;
		}
		else {
			throw new CabBookingException("Cab details not found");
		}
		
	}

	@Override
	public List<Cab> viewCabs() throws CabBookingException{
		List<Cab> allCab = cabRepo.findAll();
		if(!allCab.isEmpty()) {
			return allCab;
		}
		else {
			throw new CabBookingException("No Cabs Found");
		}
	}

	@Override
	public List<Cab> viewCabByType(String cabType) throws CabBookingException{
		List<Cab> viewCabsOfTyp = new ArrayList<>();
		viewCabsOfTyp = cabRepo.findAll().stream().filter(e->e.getCabType().toString().equals(cabType)).collect(Collectors.toList());
		if(!viewCabsOfTyp.isEmpty()) {
			return viewCabsOfTyp;
		}
		else {
			throw new CabBookingException(cabType.toString()+"Cab Not Found");
		}

	}

	@Override
	public List<Cab> viewCabByCurrentLocation(String currentLocation) throws CabBookingException{
		List<Cab> viewCabsByLoc = new ArrayList<>();
		viewCabsByLoc = cabRepo.findAll().stream().filter(e->e.getCurrentLocation().equals(currentLocation)).collect(Collectors.toList());
		if(!viewCabsByLoc.isEmpty()) {
			return viewCabsByLoc;
		}
		else {
			throw new CabBookingException("Cab not found at this location");
		}
	}

	@Override
	public Cab viewCabByDriverId(int driverId) throws CabBookingException{
		Optional<Cab> check = cabRepo.findById(driverId);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			throw new CabBookingException("Cab not found by driverID");
		}
		
	}

	@Override
	public Cab viewCabById(int cabId) throws CabBookingException{
		Optional<Cab> check = cabRepo.findById(cabId);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			throw new CabBookingException("Cab not found by CabID");
		}
	}

	@Override
	public List<Cab> viewCabByTypeAndLocation(String cabType, String currentLocation) throws CabBookingException{
		List<Cab> viewCabs = cabRepo.findAll().stream().filter(e->e.getCabType().toString().equals(cabType)&&e.getCurrentLocation().equals(currentLocation)).collect(Collectors.toList());
		if(!viewCabs.isEmpty()) {
			return viewCabs;
		}
		else {
			throw new CabBookingException(cabType+" Type Cab not found at "+currentLocation);
		}
	}

	@Override
	public List<Cab> viewCabByAvailability() throws CabBookingException{
		List<Cab> viewCabByAva = new ArrayList<>();
		List<Cab> allCab = cabRepo.findAll();
		for(Cab cab : allCab) {
			if(cab.getCabAvailability()==true) {
				viewCabByAva.add(cab);
			}
		}
		if(!viewCabByAva.isEmpty()) {
			return viewCabByAva;
		}
		else {
			throw new CabBookingException("Cab not found by cabID");
		}
	}

}
