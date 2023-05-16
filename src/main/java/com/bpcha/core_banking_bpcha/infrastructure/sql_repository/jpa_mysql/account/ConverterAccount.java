package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountData;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.ConverterClient;
import org.springframework.stereotype.Component;

@Component
public class ConverterAccount {

    public static Account toEntity(AccountData accountData) {
        Account account = new Account();
        account.setAccountType(accountData.getAccountType());
        account.setAccountNumber(accountData.getAccountNumber());
        account.setInitialBalance(accountData.getInitialBalance());
        account.setState(accountData.getState());
        account.setClient(ConverterClient.toEntity(accountData.getClientData()));
        return account;
    }

    public static AccountData toData(Account account) {
        AccountData accountData = new AccountData();
        accountData.setAccountNumber(account.getAccountNumber());
        accountData.setAccountType(account.getAccountType());
        accountData.setInitialBalance(account.getInitialBalance());
        accountData.setState(account.getState());
        accountData.setClientData(ConverterClient.toData(account.getClient()));
        return accountData;
    }
}
