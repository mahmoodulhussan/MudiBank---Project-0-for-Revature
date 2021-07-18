//package com.bank.services;
//
//import java.io.FileNotFoundException;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.bank.dao.FileIO;
//import com.bank.dao.UserDao;
//import com.bank.dao.UserDaoMock;
//import com.bank.exceptions.InvalidCredentialsException;
//import com.bank.exceptions.UserDoesNotExistException;
//import com.bank.exceptions.UserNameAlreadyExistException;
//import com.bank.logging.Logging;
//import com.bank.models.User;
//
//public class UserService {
//	
//	private UserDao uDao;
//	
//	public UserService(UserDao u) {
//		this.uDao = u;
//	}
//	
//	public User signUp(String first, String last, String username, String email, String password) throws UserNameAlreadyExistException{
//		User u = new User(first, last, username, email, password);
//		
//		try {
//			uDao.createUser(u);
//			Logging.logger.info("New user has registered");
//		} catch(SQLException e) {
//			Logging.logger.warn("Username created that already exists in the database");
//			throw new UserNameAlreadyExistException();
//		}
//		
//		return u;
//	}
//	
//	public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException{
//		User u = uDao.getUserByUsername(username);
//		
//		if(u.getId() == 0) {
//			Logging.logger.warn("User tried loggging in that does not exist");
//			throw new UserDoesNotExistException();
//		}
//		else if(!u.getPassword().equals(password)) {
//			Logging.logger.warn("User tried to login with invalid credentials");
//			throw new InvalidCredentialsException();
//		}
//		else {
//			Logging.logger.info("User was logged in");
//			return u;
//		}
//	}
//	
//	
//	
//	/*
//	private String file;
//	private FileIO<User> io;
//
//	public UserService(String file) {
//		this.file = file;
//		this.io = new FileIO<User>(file);
//	}
//	
//	public User signUp(String firstName, String lastName, String password) {
//		ArrayList<User> users;
//		
//		try {
//			users = io.readObject();
//			
//		}catch (FileNotFoundException e) {
//			System.out.println("Creating a blank users array");
//			users = new ArrayList<User>();
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//		User u = new User(firstName, lastName, password);
//		
//		//check to see if the user's username is already stored somewhere
//		for(int i=0; i < users.size();i++) {
//			if(users.get(i).getUsername().equals(u.getUsername())) {
//				throw new UserNameAlreadyExistException();
//			}
//		}
//		
//		users.add(u);
//		io.writeObject(users);
//		return u;
//		
//	}
//	public User login(String username, String password) {
//		
//		ArrayList<User> users;
//		
//		try {
//			users = io.readObject();
//			
//		}catch (FileNotFoundException e) {
//			users = new ArrayList<User>();
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//		
//		//We first want to loop through our users list 
//		//to see if we can match a username
//		for(int i=0; i<users.size(); i++) {
//			if(users.get(i).getUsername().equals(username)) {
//				if(users.get(i).getPassword().equals(password)) {
//					System.out.println("User was signed in");
//					return users.get(i);
//				}else {
//					throw new InvalidCredentialsException();
//				}
//			}
//		}
//		throw new InvalidCredentialsException();
//	}
//	
//	public List<User> getAllUsers(){
//		ArrayList<User> users;
//		
//		try {
//			users = io.readObject();
//			
//		}catch(Exception e) {
//			users = new ArrayList<User>();
//		}
//		return users;
//	}
//	
//*/
//
//
//
//}