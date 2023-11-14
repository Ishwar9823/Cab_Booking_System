package com.cabbooking.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cabbooking.entity.TripBooking;
import com.cabbooking.exception.TripBookingException;
import com.cabbooking.repository.TripBookingRepo;
import com.cabbooking.service.ITripBookingService;
import com.cabbooking.util.BookingStatus;

@Service
public class ITripBookingServiceImpl implements ITripBookingService {
	
	@Autowired
	TripBookingRepo tripBookingRepo;

	@Override
	public TripBooking addTripBooking(TripBooking tripBooking) {
		
			return tripBookingRepo.save(tripBooking);
		}
	@Override
	public TripBooking updateTripBooking(TripBooking tripBooking) throws TripBookingException{
		int id = tripBooking.getTripBookingId();
		Optional<TripBooking> check = tripBookingRepo.findById(id);
		if(check.isPresent()) {
			TripBooking updatetripBook = check.get();
			updatetripBook.setDropoffLocation(tripBooking.getDropoffLocation());
			updatetripBook.setCabType(tripBooking.getCabType());
			updatetripBook.setStartDateTime(tripBooking.getStartDateTime());
			updatetripBook.setBookingStatus(tripBooking.getBookingStatus());
			updatetripBook.setDistanceInKm(tripBooking.getDistanceInKm());
			updatetripBook.setCustomer(tripBooking.getCustomer());
			updatetripBook.setPickupLocation(tripBooking.getPickupLocation());
			updatetripBook.setBill(tripBooking.getBill());
			
			return tripBookingRepo.save(updatetripBook);
			
		}
		else {
			throw new TripBookingException("Trip not found");
		}
		
	}

	@Override
	public TripBooking cancleTripBooking(Integer tripBookingId) throws TripBookingException{
		// TODO Auto-generated method stub
		Optional<TripBooking> check = tripBookingRepo.findById(tripBookingId);
		if(check.isPresent()) {
			TripBooking deleteTripBooking = check.get();
			deleteTripBooking.setBookingStatus(BookingStatus.valueOf("CANCELED"));
			return deleteTripBooking;
		}
		else {
			throw new TripBookingException("Trip not found");
		}
		
	}

	@Override
	public List<TripBooking> viewAllBookings() throws TripBookingException{
		// TODO Auto-generated method stub
		List<TripBooking> check = tripBookingRepo.findAll();
		List<TripBooking> viewList = new ArrayList<>();
		for( TripBooking trip : check) {
			viewList.add(trip);
		}
		if(!viewList.isEmpty()) {
			return viewList;
		}
		else {
			throw new TripBookingException("Trips not found");
		}
	}

	@Override
	public TripBooking viewBookingByBookingId(Integer tripBookingId) throws TripBookingException{
		
		Optional<TripBooking> check = tripBookingRepo.findById(tripBookingId);
		if(check.isPresent()) {
			return check.get();
		}
		else {
			throw new TripBookingException("Trips not found by bookingId");
		}
		
	}

	@Override
	public List<TripBooking> viewBookingByCustomerId(Integer customerId) throws TripBookingException{
		
		List<TripBooking> list = tripBookingRepo.findAll().stream().filter(e->e.getCustomer().getUserId()==customerId).collect(Collectors.toList());
		if(!list.isEmpty()) {
			return list;
		}else {
			throw new TripBookingException("Trips not found by customerId");
		}
	}

	@Override
	public List<TripBooking> viewBookingByBookingStatus(String status) throws TripBookingException{
		
		List<TripBooking> list = tripBookingRepo.findAll().stream().filter(e->e.getBookingStatus().toString().equals(status)).collect(Collectors.toList());
		if(!list.isEmpty()) {
			return list;
		}else {
			throw new TripBookingException("Trips not found by bookingStatus");
		}
	}

	@Override
	public List<TripBooking> viewBookingByCabType(String cabType) throws TripBookingException{
		//TODO Auto-generated method stub
		
		List<TripBooking> list = tripBookingRepo.findAll().stream().filter(e->e.getCabType().toString().equals(cabType)).collect(Collectors.toList());
		if(!list.isEmpty()) {
			return list;
		}else {
			throw new TripBookingException("Trips not found by cabType "+cabType);
		}
	}

	@Override
	public List<TripBooking> viewBookingsByDatewiseSortingOrder() throws TripBookingException{

		List<TripBooking> list = tripBookingRepo.findAll()
	    .stream()
	    .filter(e -> e.getStartDateTime() != null)
	    .sorted(Comparator.comparing(TripBooking::getStartDateTime))
	    .collect(Collectors.toList());
		if(!list.isEmpty()) {
			return list;
		}
		else {
			throw new TripBookingException("Trips not found by Datewise");
		}

//		
		
	}

	
	
	public List<TripBooking> viewBookingsByCustomerBasedOnDates(Integer customerId, LocalDate fromDate,
	        LocalDate toDate) throws TripBookingException {

	    List<TripBooking> list = tripBookingRepo.findAll()
	            .stream()
	            .filter(e -> e.getCustomer().getUserId() == customerId &&
	                    e.getStartDateTime().toLocalDate().isEqual(fromDate) &&
	                    !e.getStartDateTime().toLocalDate().isAfter(toDate))
	            .toList();

	    if (!list.isEmpty()) {
	        return list;
	    } else {
	        throw new TripBookingException("Trips not found fromDate "+fromDate+" to "+toDate+" Customer");
	    }
	}


	






	
}
