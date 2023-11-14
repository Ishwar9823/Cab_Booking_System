package com.cabbooking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cabbooking.entity.Cab;
import com.cabbooking.entity.Customer;
import com.cabbooking.entity.Ride;
import com.cabbooking.exception.RideBookingException;
import com.cabbooking.repository.RideRepo;
import com.cabbooking.serviceimpl.IRideServiceImpl;
import com.cabbooking.util.RideStatus;

@ExtendWith(MockitoExtension.class)
class IRideServiceImplTest {

    @Mock
    private RideRepo rideRepo;

    @InjectMocks
    private IRideServiceImpl rideService;

    private Ride testRide;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize a sample Ride object for testing
        testRide = new Ride();
        testRide.setRideId(1);
        testRide.setPickupLocation("PickupLocation");
        testRide.setDropoffLocation("DropoffLocation");
        testRide.setStartTime(LocalDateTime.now());
        testRide.setEndTime(LocalDateTime.now().plusHours(1));
        testRide.setRideStatus(RideStatus.SCHEDULED);
        testRide.setCab(new Cab());
        testRide.setCustomer(new Customer());
    }

    @Test
    void testAddRide() {
        when(rideRepo.save(any(Ride.class))).thenReturn(testRide);

        Ride addedRide = rideService.addRide(testRide);

        assertNotNull(addedRide);
        assertEquals(testRide.getPickupLocation(), addedRide.getPickupLocation());
        assertEquals(testRide.getDropoffLocation(), addedRide.getDropoffLocation());
    }

    @Test
    void testUpdateRide() throws RideBookingException {
        when(rideRepo.findById(anyInt())).thenReturn(Optional.of(testRide));
        when(rideRepo.save(any(Ride.class))).thenReturn(testRide);

        Ride updatedRide = rideService.updateRide(testRide, 1);

        assertNotNull(updatedRide);
        assertEquals(testRide.getPickupLocation(), updatedRide.getPickupLocation());
        assertEquals(testRide.getDropoffLocation(), updatedRide.getDropoffLocation());
    }

    

    @Test
    void testViewAllRides() throws RideBookingException {
        List<Ride> rideList = new ArrayList<>();
        rideList.add(testRide);

        when(rideRepo.findAll()).thenReturn(rideList);

        List<Ride> retrievedRides = rideService.viewAllRides();

        assertNotNull(retrievedRides);
        assertEquals(1, retrievedRides.size());
    }

   
}
