package com.bank.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.models.TranDisplay;
//import com.bank.models.User;
import com.bank.utils.ConnectionUtil;

public class EmployeeDaoDB implements EmployeeDao{
	
	private ConnectionUtil conUtil = ConnectionUtil.getConnectionUtil();
	
	
	//We use callable statements to call stored procedures and functions from java
	@Override
	public void depositWithdraw(Employee emp){
//			Employee emp = new Employee();
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			con.setAutoCommit(false);
			String sql = "call init_transfer(?,?,?)";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, emp.getSrcId());
			cs.setInt(2, emp.getDestId());
			cs.setInt(3, emp.getTranAmount());
			
			con.setAutoCommit(true);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	//We use callable statements to call stored procedures and functions from java
	@Override
	public void initTransfer(Employee emp){
//			Employee emp = new Employee();
		try {
			Connection con = conUtil.getConnection();
			//To use our functions/procedure we need to turn off autocommit
			con.setAutoCommit(false);
			String sql = "call init_transfer(?,?,?)";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.setInt(1, emp.getSrcId());
			cs.setInt(2, emp.getDestId());
			cs.setInt(3, emp.getTranAmount());
			
			cs.execute();
			
//			con.setAutoCommit(true);
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	
	}

//	@Override
//	public getTransferLog() {
//				
//		try {
//			Connection con = conUtil.getConnection();
//			//To create a simple statement we write our query as a string
//
//			String sql = "SELECT * FROM transfers";
//			
//			//We need to create a statement with this sql string
//			Statement s = con.createStatement();
//			ResultSet rs = s.executeQuery(sql);
//			
//			while(rs.next()) {
//				TranDisplay tran = new TranDisplay(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
//				transferLog.add(tran);
//			}
//			
//			return transferLog;
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}		return null;
//	}
	
	@Override
	public List<TranDisplay> getAllTransfers() {
		
		List<TranDisplay> tranList = new ArrayList<TranDisplay>();
		
		try {
			Connection con = conUtil.getConnection();
			//To create a simple statement we write our query as a string
			String sql = "SELECT * FROM transfers";
			
			//We need to create a statement with this sql string
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				tranList.add(new Employee(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
			}
			
			return tranList;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}		return null;
	}

	@Override
	public Customer getCustomerTransfers(Customer c) {
		List<Employee> transfers = new ArrayList<Employee>();
		try {
			Connection con = conUtil.getConnection();
			con.setAutoCommit(false);
			String sql = "{?=call get_customer_transfers(?,?,?)}";
			
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.OTHER);
			cs.setInt(2, c.getCustomerId());
			
			cs.execute();
			
			ResultSet rs = (ResultSet) cs.getObject(1);
			
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				transfers.add(emp);
			}
			
			c.setPosts(transfers);
			
			con.setAutoCommit(true);
			return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Employee checkBalance(int srcId) {
		Employee transfers = new Employee();
		try {
			Connection con = conUtil.getConnection();

			String sql = "SELECT SUM (tran_amount) AS total\r\n"
					+ "FROM transfers\r\n"
					+ "WHERE src_id ='" + srcId + "'";		
			
			PreparedStatement stmt = con.prepareStatement(sql);

			
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				transfers.setTranAmount(rs.getInt(1));
			}
			return transfers;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}