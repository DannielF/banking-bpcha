package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction;

import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.ConverterAccount;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data.TransactionData;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConverterTransaction {

    public static Transaction toEntity(TransactionData transactionData) {
        return new Transaction().toBuilder()
                .id(transactionData.getId())
                .transactionBalance(transactionData.getTransactionBalance())
                .transactionType(transactionData.getTransactionType())
                .date(transactionData.getDate())
                .account(ConverterAccount.toEntity(transactionData.getAccountData()))
                .build();
    }

    public static TransactionData toData(Transaction transaction) {
        return new TransactionData().toBuilder()
                .id(transaction.getId())
                .transactionBalance(transaction.getTransactionBalance())
                .transactionType(transaction.getTransactionType())
                .date(transaction.getDate())
                .accountData(ConverterAccount.toData(transaction.getAccount()))
                .build();
    }

    public static List<Transaction> toTransactions(List<TransactionData> transactionsData) {
        return transactionsData.stream().map(t ->
                new Transaction().toBuilder()
                        .id(t.getId())
                        .transactionBalance(t.getTransactionBalance())
                        .transactionType(t.getTransactionType())
                        .date(t.getDate())
                        .build()
        ).toList();
    }

    public static List<TransactionData> toTransactionsData(List<Transaction> transactions) {
        return transactions.stream().map(t ->
                new TransactionData().toBuilder()
                        .id(t.getId())
                        .transactionBalance(t.getTransactionBalance())
                        .transactionType(t.getTransactionType())
                        .date(t.getDate())
                        .build()
        ).toList();
    }
}
