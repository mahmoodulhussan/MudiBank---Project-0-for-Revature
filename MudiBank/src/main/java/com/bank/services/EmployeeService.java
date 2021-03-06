package com.bank.services;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.bank.dao.EmployeeDao;
import com.bank.logging.Logging;
import com.bank.models.Customer;
import com.bank.models.Employee;
import com.bank.models.TransferLog;
//import com.bank.models.User;

public class EmployeeService {

private EmployeeDao eDao;
	
	public EmployeeService(EmployeeDao emp) {
		this.eDao = emp;
	}
	
	public Employee initTransfer(int srcId, int destId, int tranAmount) {
		Employee emp = new Employee(srcId, destId, tranAmount);
		eDao.initTransfer(emp);
		return emp;
	}
	
	public Employee depositWithdraw(int srcId, int destId, int tranAmount) {
		Employee emp = new Employee(srcId, destId, tranAmount);
		eDao.depositWithdraw(emp);
		return emp;
	}
	
//	public List<TranDisplay> getTransferLog(){
//		return eDao.getTransferLog();
//	}
	
	public List<TransferLog> getAllTransfers(){
		return eDao.getAllTransfers();
	}
	
	public Customer loadUserPosts(Customer c) {
		return eDao.getCustomerTransfers(c);
	}
	
}
