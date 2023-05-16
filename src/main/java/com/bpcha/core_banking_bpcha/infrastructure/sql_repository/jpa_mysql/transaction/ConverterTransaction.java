package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction;

import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.ConverterAccount;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data.TransactionData;
import org.springframework.stereotype.Component;

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
}
