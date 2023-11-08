package com.cabbooking.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.dto.RideDTO;
import com.cabbooking.entity.Ride;
import com.cabbooking.repository.CustomerRepo;
import com.cabbooking.repository.RideRepo;
import com.cabbooking.service.IRideService;

@Service
public class IRideServiceImpl implements IRideService {

	@Autowired
	RideRepo rideRepo;
	
	@Override
	public Ride addRide(Ride ride) {
		return rideRepo.save(ride);
	}

	@Override
	public Ride updateRide(Ride ride,int rideId) {
		Optional<Ride> checkRide = rideRepo.findById(rideId);
		if(checkRide.isPresent()) {
			Ride updateRide = checkRide.get();
			updateRide.setPickupLocation(ride.getPickupLocation());
			updateRide.setDropoffLocation(ride.getDropoffLocation());
			updateRide.setStartTime(ride.getStartTime());
			updateRide.setEndTime(ride.getEndTime());
			updateRide.setRideStatus(ride.getRideStatus());
			updateRide.setCab(ride.getCab());
			updateRide.setCustomer(ride.getCustomer());
			
			return rideRepo.save(updateRide);
			
		}
		else {
			return null;
		}
	}

	@Override
	public Ride cancleRide(Integer rideId) {
		Optional<Ride> checkRide = rideRepo.findById(rideId);
		if(checkRide.isPresent()) {
			Ride cancleRide = checkRide.get();
			rideRepo.delete(cancleRide);
			return cancleRide;
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<Ride> viewAllRides() {
		List<Ride> ridelist = rideRepo.findAll();
		
		if(!ridelist.isEmpty()) {
			return ridelist;
		}
		else {
			return null;
		}
		
	}

	@Override
	public Ride viewRideByCustomerId(Integer customerId) {
//		Optional<Ride> viewRide = 
				return rideRepo.findAll().stream().filter(e->e.getCustomer().getUserId()==customerId).findAny().get();
		
		
		
	}

	@Override
	public List<Ride> viewRideByDriverId(Integer driverId) {
		List<Ride> viewById = rideRepo.findAll();
		if(!viewById.isEmpty()) {
			return viewById;
		}
		else {
			return null;
		}
	}

	@Override
	public List<Ride> viewRidesByCabId(Integer cabId) {
		
		return rideRepo.findAll().stream().filter(e->e.getCab().getCabId()==cabId).collect(Collectors.toList());
	}

	@Override
	public List<Ride> viewRidesByStatus(String status) {
		
		return rideRepo.findAll().stream().filter(e->e.getRideStatus().toString().equals(status)).collect((Collectors.toList()));
	}

	@Override
	public List<Ride> viewRidesByDate(LocalDate date) {
		// TODO Auto-generated method stu
		return rideRepo.findAll().stream().filter(e->e.getStartTime().toLocalDate().isEqual(date)).collect(Collectors.toList());
	}

	
}
