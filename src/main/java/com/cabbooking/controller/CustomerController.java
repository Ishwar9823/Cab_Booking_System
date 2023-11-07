package com.cabbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbooking.entity.Customer;
import com.cabbooking.service.ICustomerService;


@RestController
public class CustomerController  {
	
	@Autowired
	ICustomerService iCustomerService;
	
	@PostMapping("/customerregister")
	public Customer registerCustomer(@RequestBody Customer customer) {
		return iCustomerService.registerCustomer(customer);
	}
	
	@PutMapping("/customerupdate/{custId}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("custId") int customerId) {
		return iCustomerService.updateCustomer(customer,customerId);
	}
	
	@GetMapping("/viewlist")
	public List<Customer> viewCustomers(){
		return iCustomerService.viewCustomers();
	}
	
	@GetMapping("/viewbyid/{custId}")
	public Customer viewCustomerById(@PathVariable("custId") Integer customerId ) {
		return iCustomerService.viewCustomerById(customerId);
	}
	
}
