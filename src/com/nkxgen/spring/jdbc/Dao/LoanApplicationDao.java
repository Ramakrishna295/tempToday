package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.jdbc.model.Customer;
import com.nkxgen.spring.jdbc.model.Customertrail;
import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;
import com.nkxgen.spring.jdbc.model.service;

@Repository
@Transactional
public class LoanApplicationDao implements LoanApplicationDaoInterface {

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	service s;

	@Override
	public List<LoanApplication> findByValue(String value) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.loanTypeId = :value and la.status=: val";
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class);
		query.setParameter("value", value);
		query.setParameter("val", "waiting");

		return query.getResultList();
	}

	@Override
	public void saveLoanApplication(LoanApplication loanApplication) {
		entityManager.persist(loanApplication);
	}

	@Override
	public void updateLoanApplication(LoanApplication loanApplication) {
		System.out.println("this is customer id" + loanApplication.getCustId());
		entityManager.merge(loanApplication);
	}

	@Override
	public List<LoanApplication> getLoanApplicationsByStatus(String status) {
		String jpql = "SELECT la FROM LoanApplication la WHERE la.status = :status";
		TypedQuery<LoanApplication> query = entityManager.createQuery(jpql, LoanApplication.class);
		query.setParameter("status", status);
		return query.getResultList();
	}

	@Override
	public List<LoanAccount> getLoanAccountsByLoanType(String loanType) {
		String queryStr = "SELECT la FROM LoanAccount la WHERE la.loanType = :loanType";
		TypedQuery<LoanAccount> query = entityManager.createQuery(queryStr, LoanAccount.class);
		query.setParameter("loanType", loanType);
		return query.getResultList();
	}

	@Override
	public void delete_Application(int loanId) {
		LoanApplication loanApplication = entityManager.find(LoanApplication.class, loanId);
		if (loanApplication != null) {
			entityManager.remove(loanApplication);
		}

	}

	@Override
	public void approve_Application(int loanId, long custId) {
		LoanApplication loanApplication = entityManager.find(LoanApplication.class, loanId);
		Customertrail customer = entityManager.find(Customertrail.class, custId);
		Customer customer1 = s.dotheservice(customer);
		LoanAccount l = new LoanAccount();
		entityManager.persist(customer1);
		l.setValuesFromLoanAccount(loanApplication);
		entityManager.persist(l);
		entityManager.remove(loanApplication);
	}
}
