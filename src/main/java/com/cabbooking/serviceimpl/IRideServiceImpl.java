package com.cabbooking.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.dto.RideDTO;
import com.cabbooking.entity.Ride;
import com.cabbooking.exception.RideBookingException;
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
	public Ride updateRide(Ride ride,int rideId) throws RideBookingException{
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
			throw new RideBookingException("Ride not found");
		}
	}

	@Override
	public Ride cancleRide(Integer rideId) throws RideBookingException{
		Optional<Ride> checkRide = rideRepo.findById(rideId);
		if(checkRide.isPresent()) {
			Ride cancleRide = checkRide.get();
			rideRepo.delete(cancleRide);
			return cancleRide;
		}
		else {
			throw new RideBookingException("Ride not found");
		}
		
	}

	@Override
	public List<Ride> viewAllRides() throws RideBookingException{
		List<Ride> ridelist = rideRepo.findAll();
		
		if(!ridelist.isEmpty()) {
			return ridelist;
		}
		else {
			throw new RideBookingException("Rides not found");
		}
		
	}

	@Override
	public Ride viewRideByCustomerId(Integer customerId) throws RideBookingException{
//		Optional<Ride> viewRide = 
		Optional<Ride> check = rideRepo.findAll().stream().filter(e->e.getCustomer().getUserId()==customerId).findAny();
		if(check.isPresent()) {
			return check.get();
		}
		else {
			throw new RideBookingException("Ride not found By customerId");
		}
		
		
		
	}

	@Override
	public List<Ride> viewRideByDriverId(Integer driverId) throws RideBookingException{
		List<Ride> viewById = rideRepo.findAll().stream().filter(e->e.getRideId()==driverId).collect(Collectors.toList());
		if(!viewById.isEmpty()) {
			return viewById;
		}
		else {
			throw new RideBookingException("ride not found by driverId");
		}
	}

	@Override
	public List<Ride> viewRidesByCabId(Integer cabId) throws RideBookingException{
		
		List<Ride> listBycabID = rideRepo.findAll().stream().filter(e->e.getCab().getCabId()==cabId).collect(Collectors.toList());
		if(!listBycabID.isEmpty()) {
			return listBycabID;
		}
		else {
			throw new RideBookingException("rides not found by cabId");
		}
	}

	@Override
	public List<Ride> viewRidesByStatus(String status) throws RideBookingException{
		
		List<Ride> listByStatus = rideRepo.findAll().stream().filter(e->e.getRideStatus().toString().equals(status)).collect((Collectors.toList()));
		if(!listByStatus.isEmpty()) {
			return listByStatus;
		}
		else {
			throw new RideBookingException("rides not found");
		}
	}

	@Override
	public List<Ride> viewRidesByDate(LocalDate date) throws RideBookingException{
		
		List<Ride> listByDate =  rideRepo.findAll().stream().filter(e->e.getStartTime().toLocalDate().isEqual(date)).collect(Collectors.toList());
		if(!listByDate.isEmpty()) {
			return listByDate;
		}
		else {
			throw new RideBookingException("rides not found on "+date);
		}
	}

	
}
