package com.bank.dao;

import java.sql.SQLException;
import java.util.List;

import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.models.TransferLog;

public interface EmployeeDao {
	
	public void depositWithdraw(Employee emp);

	public void initTransfer(Employee emp);
	
	List<TransferLog> getAllTransfers();
	
	void acceptTransfer();

	void rejectTransfer();
	
	
	public Customer getCustomerTransfers(Customer c);
	
	public Employee checkBalance(int src_id);

//	List<Employee> getAllTransfers(Employee emp);

}
