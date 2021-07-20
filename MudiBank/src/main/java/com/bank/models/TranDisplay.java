package com.bank.models;

public class TranDisplay {

	private String username;
	private int tranId;
	private int srcId;
	private int destId;
	private int tranAmount;
	
	public TranDisplay() {
		super();
	}

	public TranDisplay(int tranId, int srcId, int destId, int tranAmount) {
		super();
		this.tranId = tranId;
		this.srcId = srcId;
		this.destId = destId;
		this.tranAmount = tranAmount;
	}


	public TranDisplay(String username, int tranId, int srcId, int destId, int tranAmount) {
		super();
		this.username = username;
		this.tranId = tranId;
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
		return "TranDisplay [tranId=" + tranId + ", srcId=" + srcId + ", destId=" + destId + ", tranAmount="
				+ tranAmount + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
	

	
}
