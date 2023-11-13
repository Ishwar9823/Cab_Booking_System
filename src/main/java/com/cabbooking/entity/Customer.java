package com.cabbooking.entity;

import javax.persistence.Entity;

@Entity
public class Customer extends User {
	
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
