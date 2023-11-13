package com.cabbooking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.cabbooking.entity.Cab;
import com.cabbooking.exception.CabBookingException;
import com.cabbooking.repository.CabRepo;
import com.cabbooking.util.CabType;
import com.cabbooking.serviceimpl.ICabServiceImpl;

@SpringBootTest
class ICabServiceImplTest {

    @Mock
    private CabRepo cabRepo;

    @InjectMocks
    private ICabServiceImpl cabService;

    private Cab testCab;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize a sample Cab object for testing
        testCab = new Cab();
        testCab.setCabId(1);
        testCab.setCabType(CabType.SEDAN);
        testCab.setRatePerKm(10.0);
        testCab.setRegistrationNo("ABC123");
        testCab.setCabAvailability(true);
        testCab.setCurrentLocation("TestLocation");
    }

    @Test
    void testAddCab() throws CabBookingException {
        when(cabRepo.save(any())).thenReturn(testCab);

        Cab addedCab = cabService.addCab(testCab);

        assertNotNull(addedCab);
        assertEquals(testCab.getCabId(), addedCab.getCabId());
        assertEquals(testCab.getCabType(), addedCab.getCabType());
        // Add more assertions based on your Cab properties
    }

    @Test
    void testUpdateCab() throws CabBookingException {
        when(cabRepo.findById(anyInt())).thenReturn(Optional.of(testCab));
        when(cabRepo.save(any())).thenReturn(testCab);

        Cab updatedCab = cabService.updateCab(testCab, 1);

        assertNotNull(updatedCab);
        assertEquals(testCab.getCabId(), updatedCab.getCabId());
        assertEquals(testCab.getCabType(), updatedCab.getCabType());
        // Add more assertions based on your Cab properties
    }

    @Test
    void testViewCabs() throws CabBookingException {
        List<Cab> cabList = new ArrayList<>();
        cabList.add(testCab);

        when(cabRepo.findAll()).thenReturn(cabList);

        List<Cab> retrievedCabs = cabService.viewCabs();

        assertNotNull(retrievedCabs);
        assertEquals(1, retrievedCabs.size());
        assertEquals(testCab.getCabId(), retrievedCabs.get(0).getCabId());
        // Add more assertions based on your Cab properties
    }

    // Add more test cases for other methods as needed

}

