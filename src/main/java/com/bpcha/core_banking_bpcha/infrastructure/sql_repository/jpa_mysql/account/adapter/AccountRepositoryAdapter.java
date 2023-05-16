package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.adapter;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.domain.model.account.gateway.AccountRepository;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {

    private final AccountDataRepository repository;

    @Override
    public Account createAccount(Account account) {
        return null;
    }

    @Override
    public Account findAccountById(Integer id) {
        return null;
    }

    @Override
    public List<Account> accountList() {
        return null;
    }

    @Override
    public Account deleteAccount(Integer id) {
        return null;
    }

    @Override
    public Account updateAccount(Account account) {
        return null;
    }
}
