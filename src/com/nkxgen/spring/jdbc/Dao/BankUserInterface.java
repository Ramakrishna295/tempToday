package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import com.nkxgen.spring.jdbc.model.BankUser;

public interface BankUserInterface {
	BankUser getBankUserById(int busr_id);

	boolean saveBankUser(BankUser bankUser);

	List<BankUser> getAllBankUsers();

	BankUser saveUser(BankUser bankUser);

	List<BankUser> getBankUsersByDesignation(String designation);

	List<BankUser> getBankUsersByDesignation(BankUser bankUser);
}
