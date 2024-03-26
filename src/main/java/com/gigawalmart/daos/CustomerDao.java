package com.gigawalmart.daos;

import java.util.List;

import com.gigawalmart.models.Customer;

public interface CustomerDao {
	
	void addCustomer(Customer customer);
		
	void updateCustomer(Customer customer);
	
	void deleteCustomer(int c_id);
	
	Customer getCustomerById(int c_id);
	
	List<Customer> getAllCustomers();
	
}
