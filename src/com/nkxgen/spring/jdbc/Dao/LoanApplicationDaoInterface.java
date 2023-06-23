package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import com.nkxgen.spring.jdbc.model.LoanAccount;
import com.nkxgen.spring.jdbc.model.LoanApplication;

public interface LoanApplicationDaoInterface {
	void saveLoanApplication(LoanApplication loanApplication);

	void updateLoanApplication(LoanApplication loanApplication);

	List<LoanApplication> findByValue(String value);

	List<LoanApplication> getLoanApplicationsByStatus(String status);

	List<LoanAccount> getLoanAccountsByLoanType(String loanType);

	void delete_Application(int id);

	void approve_Application(int loanId, long custId);
}
