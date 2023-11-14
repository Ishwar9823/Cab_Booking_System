package com.cabbooking.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotBlank;

@PrimaryKeyJoinColumn
@Entity
public class Customer extends User {
	@NotBlank(message = "Customer name cannot be blank")
	private String customerName;
	
	public Customer() {}

	public Customer(String customerName,int customerId) {
		super();
		this.customerName = customerName;

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + "]";
	}

	
	
	
	
	
}
