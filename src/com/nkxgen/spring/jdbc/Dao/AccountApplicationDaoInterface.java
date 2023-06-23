package com.nkxgen.spring.jdbc.Dao;

import java.util.List;

import com.nkxgen.spring.jdbc.model.Account;
import com.nkxgen.spring.jdbc.model.AccountApplication;
import com.nkxgen.spring.jdbc.model.Accountdocument;

public interface AccountApplicationDaoInterface {
	void save(AccountApplication accountApplication);

	List<AccountApplication> getAccountsappByType(String value);

	List<Account> getAccountsByType(String acnt_acty_id);

	void save1(Account account);

	void save2(Accountdocument accountdocument);

	List<Account> getall();

	List<Account> getAccountssByType(String acnt_acty_id);

	public Account mergeAccount(Account account);
}
