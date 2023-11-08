package com.cabbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabbooking.entity.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver,Integer> {

}
