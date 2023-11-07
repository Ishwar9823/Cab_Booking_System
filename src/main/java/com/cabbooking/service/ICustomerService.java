package com.cabbooking.service;

import java.util.List;

import com.cabbooking.dto.CustomerDTO;

public interface ICustomerService {

	public CustomerDTO registerCustomer(CustomerDTO customer);

	public CustomerDTO updateCustomer(CustomerDTO customer);

	public List<CustomerDTO> viewCustomers();

	public CustomerDTO viewCustomerById(Integer customerId);
}
