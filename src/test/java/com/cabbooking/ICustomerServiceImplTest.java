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

import com.cabbooking.dto.CustomerDTO;
import com.cabbooking.entity.Customer;
import com.cabbooking.exception.CustomerBookingException;
import com.cabbooking.repository.CustomerRepo;
import com.cabbooking.serviceimpl.ICustomerServiceImpl;

@SpringBootTest
class ICustomerServiceImplTest {

    @Mock
    private CustomerRepo customerRepo;

    @InjectMocks
    private ICustomerServiceImpl customerService;

    private Customer testCustomer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize a sample Customer object for testing
        testCustomer = new Customer();
        testCustomer.setUserId(1);
        testCustomer.setCustomerName("TestCustomer");
        testCustomer.setUserName("testuser");
        testCustomer.setAddress("TestAddress");
        testCustomer.setEmail("test@example.com");
        testCustomer.setRoles("Customer");
    }

    @Test
    void testRegisterCustomer() {
        when(customerRepo.save(any())).thenReturn(testCustomer);

        CustomerDTO registeredCustomer = customerService.registerCustomer(testCustomer);

        assertNotNull(registeredCustomer);
        assertEquals(testCustomer.getCustomerName(), registeredCustomer.getCustomerName());
        assertEquals(testCustomer.getUserName(), registeredCustomer.getUserName());
        // Add more assertions based on your Customer properties
    }

    @Test
    void testUpdateCustomer() throws CustomerBookingException {
        when(customerRepo.findById(anyInt())).thenReturn(Optional.of(testCustomer));
        when(customerRepo.save(any())).thenReturn(testCustomer);

        CustomerDTO updatedCustomer = customerService.updateCustomer(testCustomer, 1);

        assertNotNull(updatedCustomer);
        assertEquals(testCustomer.getCustomerName(), updatedCustomer.getCustomerName());
        assertEquals(testCustomer.getUserName(), updatedCustomer.getUserName());
        // Add more assertions based on your Customer properties
    }

    @Test
    void testViewCustomers() throws CustomerBookingException {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(testCustomer);

        when(customerRepo.findAll()).thenReturn(customerList);

        List<CustomerDTO> retrievedCustomers = customerService.viewCustomers();

        assertNotNull(retrievedCustomers);
        assertEquals(1, retrievedCustomers.size());
        assertEquals(testCustomer.getCustomerName(), retrievedCustomers.get(0).getCustomerName());
        // Add more assertions based on your Customer properties
    }

   
}

