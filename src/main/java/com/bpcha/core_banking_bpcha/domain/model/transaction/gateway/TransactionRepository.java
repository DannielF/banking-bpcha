package com.bpcha.core_banking_bpcha.domain.model.transaction.gateway;

import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import org.joda.time.DateTime;

import java.util.List;

public interface TransactionRepository {
    Transaction makeTransaction(Transaction transaction);
    Transaction findTransactionById(Integer id);
    List<Transaction> transactionsList();
    List<Transaction> transactionsListBetweenDate(DateTime from, DateTime to);
}
