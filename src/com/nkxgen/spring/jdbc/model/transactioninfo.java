package com.nkxgen.spring.jdbc.model;

public class transactioninfo {
	private int accountNumber;
	private int amount;

	public transactioninfo() {

	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
