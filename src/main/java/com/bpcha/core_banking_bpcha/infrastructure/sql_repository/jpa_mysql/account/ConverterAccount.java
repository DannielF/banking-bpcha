package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountData;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.ConverterClient;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.ConverterTransaction;
import org.springframework.stereotype.Component;

@Component
public class ConverterAccount {

    public static Account toEntity(AccountData accountData) {
        return new Account().toBuilder()
                .id(accountData.getId())
                .accountType(accountData.getAccountType())
                .accountNumber(accountData.getAccountNumber())
                .initialBalance(accountData.getInitialBalance())
                .state(accountData.getState())
                .transactions(accountData.getTransactions().stream().map(ConverterTransaction::toEntity).toList())
                .client(ConverterClient.toEntity(accountData.getClientData()))
                .build();
    }

    public static AccountData toData(Account account) {
        return new AccountData().toBuilder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .initialBalance(account.getInitialBalance())
                .transactions(account.getTransactions().stream().map(ConverterTransaction::toData).toList())
                .state(account.getState())
                .clientData(ConverterClient.toData(account.getClient()))
                .build();
    }
}
