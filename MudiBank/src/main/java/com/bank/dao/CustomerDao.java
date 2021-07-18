package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.Customer;
//import com.bank.models.User;

public interface CustomerDao {
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String username);
	
	
	
	void createCustomer(Customer c) throws SQLException;
	
	void updateCustomer(Customer c);
	
	void deleteCustomer(Customer c);
	

}
