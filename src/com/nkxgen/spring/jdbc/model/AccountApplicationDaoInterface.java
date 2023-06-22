package com.nkxgen.spring.jdbc.model;

import java.util.List;

public interface AccountApplicationDaoInterface {
    void save(AccountApplication accountApplication);
    List<AccountApplication> getAccountsappByType(String value);
    List<Account> getAccountsByType(String acnt_acty_id);
    void save1(Account account);
    void save2(Accountdocument accountdocument);
}
