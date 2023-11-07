package com.cabbooking.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.entity.Customer;
import com.cabbooking.repository.CustomerRepo;
import com.cabbooking.service.ICustomerService;
@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepo customerRepo;
	@Override
	public Customer registerCustomer(Customer customer) {
		if(customer.getRoles().equals("Customer")) {
			return customerRepo.save(customer);
		}
		return null;
	}

	@Override
	public Customer updateCustomer(Customer customer,int customerId) {
		Optional<Customer> cust = customerRepo.findById(customerId);
		if(cust.isPresent()) {
			Customer updatingCustomer = cust.get();
			updatingCustomer.setCustomerName(customer.getCustomerName());
			updatingCustomer.setUserName(customer.getUserName());
			updatingCustomer.setPassword(customer.getPassword());
			updatingCustomer.setAddress(customer.getAddress());
			updatingCustomer.setMobileNumber(customer.getMobileNumber());
			updatingCustomer.setEmail(customer.getEmail());
			updatingCustomer.setRoles(customer.getRoles());
			
			return customerRepo.save(updatingCustomer);
		}
		else {
			return null;
		}
		
	}

	@Override
	public List<Customer> viewCustomers() {
		
		return customerRepo.findAll();
	}

	@Override
	public Customer viewCustomerById(Integer customerId) {
		Optional<Customer> cust = customerRepo.findById(customerId);
		
		if(cust.isPresent()) {
			return cust.get();
		}
		else {
			return null;
		}
		
	}

}
