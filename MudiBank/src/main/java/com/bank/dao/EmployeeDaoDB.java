package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.models.PostDisplay;
//import com.bank.models.User;
import com.bank.utils.ConnectionUtil;

public class EmployeeDaoDB implements EmployeeDao{
	
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	
	//We use callable statements to call stored procedures and functions from java
	@Override
	public void createPost(Employee p) {
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			con.setAutoCommit(false);
			String sql = "call create_post(?,?,?)";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, p.getAuthorId());
			cs.setInt(2, p.getWallUserId());
			cs.setInt(3, p.getPostContent());
			
			cs.execute();
			
			con.setAutoCommit(true);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<PostDisplay> getAllPosts() {
		
		List<PostDisplay> pList = new ArrayList<PostDisplay>();
		
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			//Use this syntax to call a stored function
			String sql = "{?=call get_all_posts()}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				PostDisplay post = new PostDisplay(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				pList.add(post);
			}
			
			con.setAutoCommit(true);
			return pList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Customer getUsersPosts(Customer c) {
		List<Employee> posts = new ArrayList<Employee>();
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "{?=call get_user_posts(?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, c.getCustomerId());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Employee p = new Employee(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				posts.add(p);
			}
			
			c.setPosts(posts);
			
			con.setAutoCommit(true);
			return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}