package com.nkxgen.spring.jdbc.model;

import java.util.List;

public interface BankUserInterface {
    BankUser getBankUserById(int busr_id);
    boolean saveBankUser(BankUser bankUser);
    List<BankUser> getAllBankUsers();
    BankUser saveUser(BankUser bankUser);
    List<BankUser> getBankUsersByDesignation(String designation);
    List<BankUser> getBankUsersByDesignation(BankUser bankUser);
}
