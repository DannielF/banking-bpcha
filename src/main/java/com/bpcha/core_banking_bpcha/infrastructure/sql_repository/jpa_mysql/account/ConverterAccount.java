package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountData;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.ConverterClient;
import org.springframework.stereotype.Component;

@Component
public class ConverterAccount {

    public static Account toEntity(AccountData accountData) {
        return new Account().toBuilder()
                .accountType(accountData.getAccountType())
                .accountNumber(accountData.getAccountNumber())
                .initialBalance(accountData.getInitialBalance())
                .state(accountData.getState())
                .client(ConverterClient.toEntity(accountData.getClientData()))
                .build();
    }

    public static AccountData toData(Account account) {
        return new AccountData().toBuilder()
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .initialBalance(account.getInitialBalance())
                .state(account.getState())
                .clientData(ConverterClient.toData(account.getClient()))
                .build();
    }
}
