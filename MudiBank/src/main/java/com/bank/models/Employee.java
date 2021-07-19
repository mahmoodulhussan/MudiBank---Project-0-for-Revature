package com.bank.models;



public class Employee {
	
	private int tranId;
	private int srcId;
	private int destId;
	private int tranAmount;
	
	public Employee() {
		
	}
	
	public Employee(int id, int srcId, int destId, int tranAmount) {
		this.tranId = id;
		this.srcId = srcId;
		this.destId = destId;
		this.tranAmount = tranAmount;
	}
	
	
	
	public Employee(int destId, int tranAmount) {
		super();
		this.destId = destId;
		this.tranAmount = tranAmount;
	}

	public Employee(int srcId, int destId, int tranAmount) {
		this.srcId = srcId;
		this.destId = destId;
		this.tranAmount = tranAmount;
	}

	public int getTranId() {
		return tranId;
	}

	public void setTranId(int tranId) {
		this.tranId = tranId;
	}

	public int getSrcId() {
		return srcId;
	}

	public void setSrcId(int srcId) {
		this.srcId = srcId;
	}

	public int getDestId() {
		return destId;
	}

	public void setDestId(int destId) {
		this.destId = destId;
	}

	public int getTranAmount() {
		return tranAmount;
	}

	public void setTranAmount(int tranAmount) {
		this.tranAmount = tranAmount;
	}

	@Override
	public String toString() {
		return "Employee [tranId=" + tranId + ", srcId=" + srcId + ", destId=" + destId + ", tranAmount=" + tranAmount
				+ "]";
	}

	


}
