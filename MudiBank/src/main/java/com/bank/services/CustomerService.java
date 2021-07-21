package com.bank.services;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bank.dao.CustomerDao;
//import com.bank.dao.FileIO;
//import com.bank.dao.UserDao;
//import com.bank.dao.CustomerDaoML;
import com.bank.exceptions.InvalidCredentialsException;
import com.bank.exceptions.UserDoesNotExistException;
import com.bank.exceptions.UserNameAlreadyExistException;
import com.bank.logging.Logging;
import com.bank.models.Customer;
//import com.bank.models.User;

public class CustomerService {
	
	private CustomerDao cDao;
	
	public CustomerService(CustomerDao c) {
		this.cDao = c;
	}
	
	public CustomerService() {
	}

	public Customer signUp(String first, String last, String username, String email, String password, int startingBalance) throws UserNameAlreadyExistException{
		Customer c = new Customer(first, last, username, email, password, startingBalance);
		
		try {
			cDao.createCustomer(c);
			Logging.logger.info("New user has registered");
		} catch(SQLException e) {
			Logging.logger.warn("Username created that already exists in the database");
			throw new UserNameAlreadyExistException();
		}
		
		return c;
	}
	
	
	
	
	public Customer signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
		Customer c = cDao.getCustomerByUsername(username);
		
		if(c.getCustomerId() == 0) {
			Logging.logger.warn("User tried loggging in that does not exist");
			throw new UserDoesNotExistException();
		}
		else if(!c.getPassword().equals(password)) {
			Logging.logger.warn("User tried to login with invalid credentials");
			throw new InvalidCredentialsException();
		}
		else {
			Logging.logger.info("User was logged in");
			return c;
		}
	}
	
	
	
	/*
	private String file;
	private FileIO<User> io;

	public UserService(String file) {
		this.file = file;
		this.io = new FileIO<User>(file);
	}
	
	public User signUp(String firstName, String lastName, String password) {
		ArrayList<User> users;
		
		try {
			users = io.readObject();
			
		}catch (FileNotFoundException e) {
			System.out.println("Creating a blank users array");
			users = new ArrayList<User>();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		User u = new User(firstName, lastName, password);
		
		//check to see if the user's username is already stored somewhere
		for(int i=0; i < users.size();i++) {
			if(users.get(i).getUsername().equals(u.getUsername())) {
				throw new UserNameAlreadyExistException();
			}
		}
		
		users.add(u);
		io.writeObject(users);
		return u;
		
	}
	public User login(String username, String password) {
		
		ArrayList<User> users;
		
		try {
			users = io.readObject();
			
		}catch (FileNotFoundException e) {
			users = new ArrayList<User>();
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
		//We first want to loop through our users list 
		//to see if we can match a username
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getUsername().equals(username)) {
				if(users.get(i).getPassword().equals(password)) {
					System.out.println("User was signed in");
					return users.get(i);
				}else {
					throw new InvalidCredentialsException();
				}
			}
		}
		throw new InvalidCredentialsException();
	}
	
	public List<User> getAllUsers(){
		ArrayList<User> users;
		
		try {
			users = io.readObject();
			
		}catch(Exception e) {
			users = new ArrayList<User>();
		}
		return users;
	}
	
*/



}