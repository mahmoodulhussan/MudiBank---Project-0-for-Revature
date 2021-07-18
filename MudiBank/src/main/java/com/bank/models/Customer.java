package com.bank.models;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer{
	
	private int customerId;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private List<Employee> posts;
	
	public Customer() {
		posts = new ArrayList<Employee>();
	}
	
	public Customer(int customerId, String firstName, String lastName, String email, String password) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = firstName + lastName + (new Random().nextInt(9000) + 1000);
		this.email = email;
		this.password = password;
		this.posts = new ArrayList<Employee>();
	}
	
	//Used to send user info to the database because the db auto generates the id
	public Customer(String firstName, String lastName, String username, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.posts = new ArrayList<Employee>();
	}
	
	//User to get user info from the database
	public Customer(int customerId, String firstName, String lastName, String username, String email, String password) {
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.posts = new ArrayList<Employee>();
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Employee> getPosts() {
		return posts;
	}

	public void setPosts(List<Employee> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "User [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", username=" + username
				+ ", email=" + email + ", password=" + password + ", posts=" + posts + "]";
	}
	
	
	
}