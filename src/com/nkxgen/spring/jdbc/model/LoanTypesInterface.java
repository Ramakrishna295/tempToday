package com.nkxgen.spring.jdbc.model;

import java.util.List;

public interface LoanTypesInterface {
    List<LoansTypes> getAllLoans();

    List<LoansTypes> getAllLoanDetails();

    LoansTypes getSelectedLoanDetails(int loanType);

    void save(LoansTypes loanType);
}
