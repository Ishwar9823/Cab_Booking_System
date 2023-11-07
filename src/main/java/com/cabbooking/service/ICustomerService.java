package com.cabbooking.service;

import java.util.List;

import com.cabbooking.dto.CustomerDTO;
import com.cabbooking.entity.Customer;

public interface ICustomerService {

	public Customer registerCustomer(Customer customer);

	public Customer updateCustomer(Customer customer,int customerId);

	public List<Customer> viewCustomers();

	public Customer viewCustomerById(Integer customerId);
}
