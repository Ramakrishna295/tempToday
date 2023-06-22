package com.nkxgen.spring.jdbc.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loanaccounts")
public class LoanAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "loan_id")
	private Long loanId;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "loan_amount")
	private Integer loanAmount;

	@Column(name = "interest_rate")
	private double interestRate;

	@Column(name = "loan_duration")
	private Integer loanDuration;

	@Column(name = "deduction_amt")
	private Integer deductionAmt;

	// Setters

	public void setdeductionAmt(int amt) {
		this.deductionAmt = amt;
	}

	public int getdeductionAmt() {
		return deductionAmt;
	}

	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setLoanAmount(Integer integer) {
		this.loanAmount = integer;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public void setLoanDuration(Integer loanDuration) {
		this.loanDuration = loanDuration;
	}

	// Getters
	public Long getLoanId() {
		return loanId;
	}

	public String getLoanType() {
		return loanType;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public Integer getLoanAmount() {
		return loanAmount;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public Integer getLoanDuration() {
		return loanDuration;
	}

}
