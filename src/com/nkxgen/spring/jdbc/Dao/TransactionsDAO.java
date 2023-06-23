package com.nkxgen.spring.jdbc.Dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.EMIpay;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.Transaction;
import com.nkxgen.spring.jdbc.model.service;
import com.nkxgen.spring.jdbc.model.tempRepayment;
import com.nkxgen.spring.jdbc.model.transactioninfo;

@Repository
@Transactional
public class TransactionsDAO implements TransactionsInterface {

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private service s;

	@Autowired
	private CustomerDaoInterface cd;

	

	@Override
	public void moneyDeposit(transactioninfo trans) {
		Account account = entityManager.find(Account.class, (long) trans.getAccountNumber());
		long balance = (long) (account.getBalance() + (long) trans.getAmount());
		account.setBalance(balance);
	}

	@Override
	public void moneyWithdrawl(transactioninfo trans) {
		Account account = entityManager.find(Account.class, (long) trans.getAccountNumber());
		if (account.getBalance() >= (long) trans.getAmount()) {
			long balance = (long) (account.getBalance() - (long) trans.getAmount());
			account.setBal(balance);
		} else {
			System.out.println("no sufficient balance");
		}
	}

	public Account getAccountById(int id) {
		Account account = entityManager.find(Account.class, (long) id);
		return account;

	}

	@Override
	public Transaction transactionSave(transactioninfo tarn) {
		Transaction t = s.transactionSet(tarn);
		t.setTran_type("Withdrawl");
		return t;
	}

	@Override
	public void saveTransaction(Transaction transaction) {
		entityManager.persist(transaction);
	}

	@Override
	public Transaction transactionSave1(transactioninfo tarn) {
		Transaction t = s.transactionSet(tarn);
		t.setTran_type("deposit");
		return t;
	}

	// =================================================================
	public LoanAccount getLoanAccountById(long id) {
		LoanAccount account = entityManager.find(LoanAccount.class, id);
		return account;

	}

	@Override
	public void loanWithdrawl(long id) {
		LoanAccount account = entityManager.find(LoanAccount.class, id);
		if ((account.getLoanAmount()) != (account.getdeductionAmt())) {
			account.setdeductionAmt(account.getLoanAmount());
		} else {
			System.out.println("already withdrawl over");
		}
	}

	@Override
	public void loanRepayment(tempRepayment trans) {
		LoanAccount account = entityManager.find(LoanAccount.class, (long) trans.getLoanid());
		System.out.println("the value is nothing");
		int x = (int) Math.ceil(trans.getTotal());
		if (trans.getAmount() == x) { // update due balance
			account.setdeductionAmt(account.getdeductionAmt() - trans.getEMI());
		} else if (trans.getAmount() == account.getdeductionAmt()) {
			account.setdeductionAmt(0);
		}

	}
	
	@Override
	public Customertrail getCustomerByLoanID(Long loanId) {
		Customertrail t = cd.getCustomerById(loanId);
		return t;
	}
    
	@Override
	public EMIpay changeToEMI(LoanAccount account) {
		EMIpay obj=s.changeToEmiObj(account);
		return obj ;
	}
}
