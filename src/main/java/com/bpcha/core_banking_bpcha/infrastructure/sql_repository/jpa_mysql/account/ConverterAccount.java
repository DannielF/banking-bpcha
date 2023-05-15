package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountData;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.ConverterClient;
import org.springframework.stereotype.Component;

@Component
public class ConverterAccount {

    private final ConverterClient converterClient;

    public ConverterAccount(ConverterClient converterClient) {
        this.converterClient = converterClient;
    }

    public Account toEntity(AccountData accountData) {
        Account account = new Account();
        account.setAccountType(accountData.getAccountType());
        account.setAccountNumber(accountData.getAccountNumber());
        account.setInitialBalance(accountData.getInitialBalance());
        account.setState(accountData.getState());
        account.setClient(converterClient.toEntity(accountData.getClientData()));
        return account;
    }

    public AccountData toData(Account account) {
        AccountData accountData = new AccountData();
        accountData.setAccountNumber(account.getAccountNumber());
        accountData.setAccountType(account.getAccountType());
        accountData.setInitialBalance(account.getInitialBalance());
        accountData.setState(account.getState());
        accountData.setClientData(converterClient.toData(account.getClient()));
        return accountData;
    }
}
