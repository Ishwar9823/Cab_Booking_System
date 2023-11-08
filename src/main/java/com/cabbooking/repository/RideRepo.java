package com.cabbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cabbooking.entity.Ride;

public interface RideRepo extends JpaRepository<Ride,Integer> {

}
