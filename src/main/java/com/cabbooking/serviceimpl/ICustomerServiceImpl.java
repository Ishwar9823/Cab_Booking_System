package com.cabbooking.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbooking.dto.CustomerDTO;
import com.cabbooking.entity.Customer;
import com.cabbooking.exception.CustomerBookingException;
import com.cabbooking.repository.CustomerRepo;
import com.cabbooking.service.ICustomerService;
@Service
public class ICustomerServiceImpl implements ICustomerService {

	@Autowired
	CustomerRepo customerRepo;
	@Override
	public CustomerDTO registerCustomer(Customer customer){
		if(customer.getRoles().equals("Customer")) {
			customerRepo.save(customer);
			return toCustomerDTO(customer) ;
		}
		return null;
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer,int customerId) throws CustomerBookingException{
		Optional<Customer> cust = customerRepo.findById(customerId);
		if(cust.isPresent()) {
			customerRepo.save(customer);
			return toCustomerDTO(customer) ;
		}
		else {
			throw new CustomerBookingException("Customer not found");
		}
		
	}

	@Override
	public List<CustomerDTO> viewCustomers() throws CustomerBookingException{
		List<CustomerDTO> custDTO = customerRepo.findAll().stream().map(e->toCustomerDTO(e)).collect(Collectors.toList());
		if(!custDTO.isEmpty()) {
			return custDTO;
		}
		else {
			throw new CustomerBookingException("No Customers found");
		}
	}

	@Override
	public CustomerDTO viewCustomerById(Integer customerId) throws CustomerBookingException{
		Optional<Customer> cust = customerRepo.findById(customerId);
		
		if(cust.isPresent()) {
			return toCustomerDTO(cust.get()) ;
		}
		else {
			throw new CustomerBookingException("Customer not found");
		}
	}
	
	private CustomerDTO toCustomerDTO(Customer customer) {
		CustomerDTO custDTO = new CustomerDTO();
		custDTO.setCustomerName(customer.getCustomerName());
		custDTO.setUserName(customer.getUserName());
		custDTO.setAddress(customer.getAddress());
		custDTO.setEmail(customer.getEmail());
		custDTO.setRoles(customer.getRoles());
		return custDTO;
		
	}

}
