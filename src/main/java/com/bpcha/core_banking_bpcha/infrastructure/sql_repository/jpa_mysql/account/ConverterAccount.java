package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountData;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.data.ClientData;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.ConverterTransaction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterAccount {

    public static Account toEntity(AccountData accountData) {
        return new Account().toBuilder()
                .id(accountData.getId())
                .accountType(accountData.getAccountType())
                .accountNumber(accountData.getAccountNumber())
                .initialBalance(accountData.getInitialBalance())
                .state(accountData.getState())
                .transactions(ConverterTransaction.toTransactions(accountData.getTransactions()))
                .client(new Client().toBuilder()
                        .id(accountData.getClient().getId())
                        .name(accountData.getClient().getName())
                        .documentId(accountData.getClient().getDocumentId())
                        .age(accountData.getClient().getAge())
                        .gender(accountData.getClient().getGender())
                        .address(accountData.getClient().getAddress())
                        .state(accountData.getClient().getState())
                        .build()
                )
                .build();
    }

    public static AccountData toData(Account account) {
        return new AccountData().toBuilder()
                .id(account.getId())
                .accountNumber(account.getAccountNumber())
                .accountType(account.getAccountType())
                .initialBalance(account.getInitialBalance())
                .transactions(ConverterTransaction.toTransactionsData(account.getTransactions()))
                .state(account.getState())
                .client(new ClientData().toBuilder()
                        .id(account.getClient().getId())
                        .name(account.getClient().getName())
                        .documentId(account.getClient().getDocumentId())
                        .age(account.getClient().getAge())
                        .gender(account.getClient().getGender())
                        .address(account.getClient().getAddress())
                        .state(account.getClient().getState())
                        .build()
                )
                .build();
    }

    public static List<Account> toAccounts(List<AccountData> accountDataList) {
        return accountDataList.stream().map(a ->
                new Account().toBuilder()
                        .id(a.getId())
                        .accountNumber(a.getAccountNumber())
                        .accountType(a.getAccountType())
                        .initialBalance(a.getInitialBalance())
                        .state(a.getState())
                        .build()
        ).toList();
    }

    public static List<AccountData> toAccountsData(List<Account> accounts) {
        return accounts.stream().map(a ->
                new AccountData().toBuilder()
                        .id(a.getId())
                        .accountNumber(a.getAccountNumber())
                        .accountType(a.getAccountType())
                        .initialBalance(a.getInitialBalance())
                        .state(a.getState())
                        .build()
        ).toList();
    }
}
