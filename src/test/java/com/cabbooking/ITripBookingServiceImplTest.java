package com.cabbooking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
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

import com.cabbooking.entity.Customer;
import com.cabbooking.entity.TripBooking;
import com.cabbooking.exception.TripBookingException;
import com.cabbooking.repository.TripBookingRepo;
import com.cabbooking.serviceimpl.ITripBookingServiceImpl;
import com.cabbooking.util.BookingStatus;

@ExtendWith(MockitoExtension.class)
class ITripBookingServiceImplTest {

    @Mock
    private TripBookingRepo tripBookingRepo;

    @InjectMocks
    private ITripBookingServiceImpl tripBookingService;

    private TripBooking testTripBooking;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize a sample TripBooking object for testing
        testTripBooking = new TripBooking();
        testTripBooking.setTripBookingId(1);
        testTripBooking.setDropoffLocation("DropoffLocation");
//        testTripBooking.setCabType.(CabType.valueOf("SUV"));
        testTripBooking.setStartDateTime(LocalDateTime.now());
        testTripBooking.setBookingStatus(BookingStatus.CONFIRMED);
        testTripBooking.setDistanceInKm(15.5);
        testTripBooking.setCustomer(new Customer());
        testTripBooking.setPickupLocation("PickupLocation");
        testTripBooking.setBill(52.0);
    }

    @Test
    void testAddTripBooking() {
        when(tripBookingRepo.save(any(TripBooking.class))).thenReturn(testTripBooking);

        TripBooking addedTripBooking = tripBookingService.addTripBooking(testTripBooking);

        assertNotNull(addedTripBooking);
        assertEquals(testTripBooking.getDropoffLocation(), addedTripBooking.getDropoffLocation());
        assertEquals(testTripBooking.getCabType(), addedTripBooking.getCabType());
        // Add more assertions based on your TripBooking properties
    }

    @Test
    void testUpdateTripBooking() throws TripBookingException {
        when(tripBookingRepo.findById(anyInt())).thenReturn(Optional.of(testTripBooking));
        when(tripBookingRepo.save(any(TripBooking.class))).thenReturn(testTripBooking);

        TripBooking updatedTripBooking = tripBookingService.updateTripBooking(testTripBooking);

        assertNotNull(updatedTripBooking);
        assertEquals(testTripBooking.getDropoffLocation(), updatedTripBooking.getDropoffLocation());
        assertEquals(testTripBooking.getCabType(), updatedTripBooking.getCabType());
        // Add more assertions based on your TripBooking properties
    }

   
    @Test
    void testViewAllBookings() throws TripBookingException {
        List<TripBooking> tripBookingList = new ArrayList<>();
        tripBookingList.add(testTripBooking);

        when(tripBookingRepo.findAll()).thenReturn(tripBookingList);

        List<TripBooking> retrievedTripBookings = tripBookingService.viewAllBookings();

        assertNotNull(retrievedTripBookings);
        assertEquals(1, retrievedTripBookings.size());
        // Add more assertions based on your TripBooking properties
    }
}

   