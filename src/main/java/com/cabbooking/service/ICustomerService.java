package com.cabbooking.service;

import java.util.List;

import com.cabbooking.dto.CustomerDTO;
import com.cabbooking.entity.Customer;
import com.cabbooking.exception.CustomerBookingException;

public interface ICustomerService {

	public CustomerDTO registerCustomer(Customer customer);

	public CustomerDTO updateCustomer(Customer customer,int customerId) throws CustomerBookingException;

	public List<CustomerDTO> viewCustomers() throws CustomerBookingException;

	public CustomerDTO viewCustomerById(Integer customerId) throws CustomerBookingException;
}
