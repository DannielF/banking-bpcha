package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction;

import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.ConverterAccount;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data.TransactionData;
import org.springframework.stereotype.Component;

@Component
public class ConverterTransaction {

    public static Transaction toEntity(TransactionData transactionData) {
        Transaction transaction = new Transaction();
        transaction.setId(transactionData.getId());
        transaction.setTransactionBalance(transactionData.getTransactionBalance());
        transaction.setTransactionType(transactionData.getTransactionType());
        transaction.setDate(transactionData.getDate());
        transaction.setAccount(ConverterAccount.toEntity(transactionData.getAccountData()));
        return transaction;
    }

    public static TransactionData toData(Transaction transaction) {
        TransactionData transactionData = new TransactionData();
        transactionData.setId(transaction.getId());
        transactionData.setTransactionBalance(transaction.getTransactionBalance());
        transactionData.setTransactionType(transaction.getTransactionType());
        transactionData.setDate(transaction.getDate());
        transactionData.setAccountData(ConverterAccount.toData(transaction.getAccount()));
        return transactionData;
    }
}
