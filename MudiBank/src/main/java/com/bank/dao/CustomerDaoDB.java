package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Account;
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
				customerList.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(4), rs.getString(6), rs.getInt(7)));			}
			
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

		String sql = "INSERT INTO users(first_name, last_name, email, username, password, starting_balance) values"
				+ "(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1, c.getFirstName());
		ps.setString(2, c.getLastName());
		ps.setString(3, c.getEmail());
		ps.setString(4, c.getUsername());
		ps.setString(5, c.getPassword());
		ps.setInt(6, c.getStartingBalance());

		ps.execute();
		
		con.commit();
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

	@Override
	public ArrayList<Customer> getByAccount(Account account) {
	
		ArrayList<Customer> cList = new ArrayList<>();
		
		try(Connection con = conUtil.getConnection();) {
			
			String sql = "SELECT * "
					+ "FROM accounts "
					+ "INNER JOIN customer_accounts USING(account_id) "
					+ "INNER JOIN bank_customer USING (customer_id) "
					+ "WHERE account_id = ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, account.getAccountID());
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String phoneNumber = rs.getString("phone_number");
				String username = rs.getString("username");
				String password = rs.getString("password");
				int customerID = rs.getInt("customer_id");
				
				Customer c = new Customer(firstName, lastName, phoneNumber, username, password, customerID);
				c.addAccount(account);
				cList.add(c);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return cList;

	}
	
	
	
	@Override
	public void acceptTransfer() {
		Connection con = conUtil.getConnection();
		
		try {
			con.setAutoCommit(false);

			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		@Override
		public void rejectTransfer() {
			Connection con = conUtil.getConnection();
			
			try {
				con.setAutoCommit(false);

				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
				
	}

}
