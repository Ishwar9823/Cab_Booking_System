package com.cabbooking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.dto.CustomerDTO;
import com.cabbooking.entity.Customer;
import com.cabbooking.exception.CustomerBookingException;
import com.cabbooking.service.ICustomerService;
import com.cabbooking.serviceimpl.ICustomerServiceImpl;


@RestController
@RequestMapping("customer")
public class CustomerController  {
	
	@Autowired
	ICustomerServiceImpl iCustomerServiceimpl;
	
	@PostMapping("/register")
	public CustomerDTO registerCustomer( @Valid @RequestBody Customer customer) {
		return iCustomerServiceimpl.registerCustomer(customer);
	}
	
	@PutMapping("/update/{custId}")
	public CustomerDTO updateCustomer(@Valid @RequestBody Customer customer, @PathVariable("custId") int customerId) throws CustomerBookingException{
		return iCustomerServiceimpl.updateCustomer(customer,customerId);
	}
	
	@GetMapping("/viewlist")
	public List<CustomerDTO> viewCustomers() throws CustomerBookingException{
		return iCustomerServiceimpl.viewCustomers();
	}
	
	@GetMapping("/viewbyid/{custId}")
	public CustomerDTO viewCustomerById(@PathVariable("custId") Integer customerId ) throws CustomerBookingException{
		return iCustomerServiceimpl.viewCustomerById(customerId);
	}
	
}
