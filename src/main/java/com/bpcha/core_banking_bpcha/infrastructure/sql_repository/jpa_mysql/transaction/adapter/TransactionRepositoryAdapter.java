package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.adapter;

import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import com.bpcha.core_banking_bpcha.domain.model.transaction.gateway.TransactionRepository;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.ConverterTransaction;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data.TransactionDataRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class TransactionRepositoryAdapter implements TransactionRepository {

    private final TransactionDataRepository repository;

    @Override
    public Transaction makeTransaction(Transaction transaction) {
        var transactionData = ConverterTransaction.toData(transaction);
        return ConverterTransaction.toEntity(repository.save(transactionData));
    }

    @Override
    public Transaction findTransactionById(Integer id) {
        var transactionData = repository.findById(id);
        transactionData.ifPresent(ConverterTransaction::toEntity);
        throw new BusinessException("404 No such transaction");
    }

    @Override
    public List<Transaction> transactionsList() {
        var transactionList = StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .toList();
        return transactionList.stream().map(ConverterTransaction::toEntity).toList();
    }

    @Override
    public List<Transaction> transactionsListBetweenDate(DateTime from, DateTime to) {
        var transactionsData = repository.getTransactionsDataByDateBetween(from,to);
        return transactionsData.stream().map(ConverterTransaction::toEntity).toList();
    }
}
