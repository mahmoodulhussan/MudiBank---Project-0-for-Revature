package com.bank.models;
import java.util.ArrayList;
import java.util.Objects;

public class Account {
	
	private int accountID;
	private double balance;
	private ArrayList<Customer> accountHolders;
	
	public Account() {
		super();
	}
	
	public Account(Customer accountHolder) {
		this.accountHolders = new ArrayList<>();
		this.balance = 0;
		this.addAccountHolder(accountHolder);
	}
	
	public Account(int accountID, double balance) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.accountHolders = new ArrayList<>();
	}

	public Account(int accountID, double balance, ArrayList<Customer> accountHolders) {
		super();
		this.accountID = accountID;
		this.balance = balance;
		this.accountHolders = accountHolders;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<Customer> getaccountHolders() {
		return accountHolders;
	}

	public void setAccountHolders(ArrayList<Customer> accountHolders) {
		this.accountHolders = accountHolders;
	}
	
	public boolean addAccountHolder(Customer c) {
		if(!accountHolders.contains(c)) {
			return accountHolders.add(c);
		}
		
		return false;
	}
	
	public boolean removeAccountHolder(Customer c) {
		if(accountHolders.contains(c)) {
			return accountHolders.remove(c);
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", balance=" + balance + ", accountHolders=" + accountHolders + "]";
	}
	
	
}