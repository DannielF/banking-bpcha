package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.adapter;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.domain.model.account.gateway.AccountRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.ConverterAccount;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepository {

    private final AccountDataRepository repository;

    @Override
    public Account createAccount(Account account) {
        var accountData = ConverterAccount.toData(account);
        return ConverterAccount.toEntity(repository.save(accountData));
    }

    @Override
    public Account findAccountById(Integer id) {
        var accountData = repository.findById(id);
        if (accountData.isPresent()) return ConverterAccount.toEntity(accountData.get());
        throw new BusinessException("404 Not found, Why? we dont know");
    }

    @Override
    public List<Account> accountList() {

        var accountList = repository.getAccounts();
        return Arrays.stream(accountList).map(ConverterAccount::toEntity).collect(Collectors.toList());
    }

    @Override
    public Account deleteAccount(Integer id) {
        return ConverterAccount.toEntity(repository.logicDeleteAccount(id));
    }

    @Override
    public Account updateAccount(Account account) {
        var accountData = repository.findById(account.getId());
        if (accountData.isPresent()) return ConverterAccount.toEntity(repository.save(accountData.get()));
        throw new BusinessException("400 MAD REQUEST");
    }
}
