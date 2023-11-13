package com.cabbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabbooking.entity.TripBooking;


@Repository
public interface TripBookingRepo extends JpaRepository<TripBooking,Integer> {
  
}
