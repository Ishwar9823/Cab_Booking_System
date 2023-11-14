package com.cabbooking;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

import com.cabbooking.dto.DriverDTO;
import com.cabbooking.entity.Driver;
import com.cabbooking.exception.DriverBookingException;
import com.cabbooking.repository.DriverRepo;
import com.cabbooking.serviceimpl.IDriverServiceImpl;


@ExtendWith(MockitoExtension.class)
class IDriverServiceImplTest {

    @Mock
    private DriverRepo driverRepo;

    @InjectMocks
    private IDriverServiceImpl driverService;

    private Driver testDriver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize a sample Driver object for testing
        testDriver = new Driver();
        testDriver.setUserId(1);
        testDriver.setDriverName("TestDriver");
        testDriver.setLicenseNo("ABC123");
        testDriver.setDriverAvailability(true);
        testDriver.setUserName("testuser");
        testDriver.setAddress("TestAddress");
        testDriver.setEmail("test@example.com");
        testDriver.setRoles("Driver");
    }

    @Test
    void testAddDriver() throws DriverBookingException {
        when(driverRepo.save(any())).thenReturn(testDriver);

        DriverDTO addedDriver = driverService.addDriver(testDriver);

        assertNotNull(addedDriver);
        assertEquals(testDriver.getDriverName(), addedDriver.getDriverName());
        assertEquals(testDriver.getUserName(), addedDriver.getUserName());
        // Add more assertions based on your Driver properties
    }

    @Test
    void testUpdateDriver() throws DriverBookingException {
        when(driverRepo.findById(anyInt())).thenReturn(Optional.of(testDriver));
        when(driverRepo.save(any())).thenReturn(testDriver);

        DriverDTO updatedDriver = driverService.updateDriver(testDriver, 1);

        assertNotNull(updatedDriver);
        assertEquals(testDriver.getDriverName(), updatedDriver.getDriverName());
        assertEquals(testDriver.getUserName(), updatedDriver.getUserName());
        // Add more assertions based on your Driver properties
    }

    @Test
    void testViewDrivers() throws DriverBookingException {
        List<Driver> driverList = new ArrayList<>();
        driverList.add(testDriver);

        when(driverRepo.findAll()).thenReturn(driverList);

        List<DriverDTO> retrievedDrivers = driverService.viewDrivers();

        assertNotNull(retrievedDrivers);
        assertEquals(1, retrievedDrivers.size());
        assertEquals(testDriver.getDriverName(), retrievedDrivers.get(0).getDriverName());
    }


}

