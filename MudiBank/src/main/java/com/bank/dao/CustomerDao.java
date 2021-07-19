package com.bank.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Customer;
//import com.bank.models.User;
import com.bank.models.Account;

public interface CustomerDao {
	
	List<Customer> getAllCustomers();
	
	Customer getCustomerByUsername(String username);
	
	public ArrayList<Customer> getByAccount(Account account);
	
	void createCustomer(Customer c) throws SQLException;
	
	void updateCustomer(Customer c);
	
	void deleteCustomer(Customer c);
	

}
