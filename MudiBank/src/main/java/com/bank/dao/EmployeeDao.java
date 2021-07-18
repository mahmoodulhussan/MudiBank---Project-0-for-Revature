package com.bank.dao;

import java.util.List;

import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.models.PostDisplay;
//import com.bank.models.User;

public interface EmployeeDao {
	public void createPost(Employee p);
	
	public List<PostDisplay> getAllPosts();
	
	public Customer getUsersPosts(Customer c);
}
