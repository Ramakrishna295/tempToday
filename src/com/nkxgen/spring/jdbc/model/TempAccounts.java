package com.nkxgen.spring.jdbc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountsss")
public class TempAccounts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acnt_id")
	private int acnt_id;

	@Column(name = "acnt_acty_id")
	private int acnt_acty_id;

	@Column(name = "acnt_acap_id")
	private int acnt_acap_id;

	@Column(name = "acnt_cust_id")
	private int acnt_cust_id;

	@Column(name = "acnt_date")
	private String acnt_date;

	@Column(name = "acnt_processedy")
	private int acnt_processedy;

	@Column(name = "balance")
	private int balance;

	public int getAcnt_id() {
		return acnt_id;
	}

	@Override
	public String toString() {
		return "TempAccounts [acnt_id=" + acnt_id + ", acnt_acty_id=" + acnt_acty_id + ", acnt_acap_id=" + acnt_acap_id
				+ ", acnt_cust_id=" + acnt_cust_id + ", acnt_date=" + acnt_date + ", acnt_processedy=" + acnt_processedy
				+ ", balance=" + balance + "]";
	}

	public void setAcnt_id(int acnt_id) {
		this.acnt_id = acnt_id;
	}

	public int getAcnt_acty_id() {
		return acnt_acty_id;
	}

	public void setAcnt_acty_id(int acnt_acty_id) {
		this.acnt_acty_id = acnt_acty_id;
	}

	public int getAcnt_acap_id() {
		return acnt_acap_id;
	}

	public void setAcnt_acap_id(int acnt_acap_id) {
		this.acnt_acap_id = acnt_acap_id;
	}

	public int getAcnt_cust_id() {
		return acnt_cust_id;
	}

	public void setAcnt_cust_id(int acnt_cust_id) {
		this.acnt_cust_id = acnt_cust_id;
	}

	public String getAcnt_date() {
		return acnt_date;
	}

	public void setAcnt_date(String acnt_date) {
		this.acnt_date = acnt_date;
	}

	public int getAcnt_processedy() {
		return acnt_processedy;
	}

	public void setAcnt_processedy(int acnt_processedy) {
		this.acnt_processedy = acnt_processedy;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}