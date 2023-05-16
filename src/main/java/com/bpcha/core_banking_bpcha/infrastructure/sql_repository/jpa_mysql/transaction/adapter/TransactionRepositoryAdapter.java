package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.adapter;

import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import com.bpcha.core_banking_bpcha.domain.model.transaction.gateway.TransactionRepository;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data.TransactionDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryAdapter implements TransactionRepository {

    private final TransactionDataRepository repository;

    @Override
    public Transaction makeTransaction(Transaction transaction) {
        return null;
    }

    @Override
    public Transaction findTransactionById(Integer id) {
        return null;
    }

    @Override
    public List<Transaction> transactionsList() {
        return null;
    }
}
