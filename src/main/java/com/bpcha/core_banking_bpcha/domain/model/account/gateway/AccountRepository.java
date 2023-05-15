package com.bpcha.core_banking_bpcha.domain.model.account.gateway;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;

import java.util.List;

public interface AccountRepository {
    Account createAccount(Account account);
    Account findAccountById(Integer id);
    List<Account> accountList();
    Account deleteAccount(Account account);
    Account updateAccount(Account account);
}
