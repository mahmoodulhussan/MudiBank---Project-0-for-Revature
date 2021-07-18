package com.bank.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.EmployeeDao;
import com.bank.logging.Logging;
import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.models.PostDisplay;
//import com.bank.models.User;

public class EmployeeService {

private EmployeeDao eDao;
	
	public EmployeeService(EmployeeDao emp) {
		this.eDao = emp;
	}
	
	public void addPost(int userId, int wallId, int content) {
		Employee p = new Employee(userId, wallId, content);
		eDao.createPost(p);
	}
	
	public List<PostDisplay> getAllPosts(){
		return eDao.getAllPosts();
	}
	
	public Customer loadUserPosts(Customer c) {
		return eDao.getUsersPosts(c);
	}
	
}
