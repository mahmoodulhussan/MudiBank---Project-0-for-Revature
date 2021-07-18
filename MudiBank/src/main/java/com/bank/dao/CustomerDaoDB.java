package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Customer;
//import com.bank.models.User;
import com.bank.utils.ConnectionUtil;

public class CustomerDaoDB implements CustomerDao {
	
	ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();


	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> customerList = new ArrayList<Customer>();
		
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statement we write our query as a string

			String sql = "SELECT * FROM users";
			
			//We need to create a statement with this sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				customerList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4), rs.getString(6)));			}
			
			return customerList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		return null;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		
		Customer c = new Customer();
		
		
		try {
			Connection con = conUtil.getConnection();
			
			String sql = "SELECT * FROM users WHERE users.username = '" + username + "'";
			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				c.setCustomerId(rs.getInt(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setEmail(rs.getString(4));
				c.setUsername(rs.getString(5));
				c.setPassword(rs.getString(6));
			}
			return c;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void createCustomer(Customer c) throws SQLException{
		
		Connection con = conUtil.getConnection();
		
		con.setAutoCommit(false);

		String sql = "INSERT INTO users(first_name, last_name, email, username, password) values"
				+ "(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, c.getFirstName());
		ps.setString(2, c.getLastName());
		ps.setString(3, c.getEmail());
		ps.setString(4, c.getUsername());
		ps.setString(5, c.getPassword());
		
		ps.execute();
		
		
	}

	@Override
	public void updateCustomer(Customer c) {
		try {
			Connection con = conUtil.getConnection();
			String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, username = ?, password = ? "
					+ " WHERE users.id = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getUsername());
			ps.setString(5, c.getPassword());
			ps.setInt(6, c.getCustomerId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteCustomer(Customer c) {
			try {
			
			Connection con = conUtil.getConnection();
			String sql = "DELETE FROM users WHERE users.id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, c.getCustomerId());
			
			ps.execute();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}

}
