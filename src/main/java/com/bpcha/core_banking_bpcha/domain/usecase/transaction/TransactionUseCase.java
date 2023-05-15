package com.bpcha.core_banking_bpcha.domain.usecase.transaction;

import com.bpcha.core_banking_bpcha.domain.model.shared.ValidationTool;
import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import com.bpcha.core_banking_bpcha.domain.model.transaction.gateway.TransactionRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class TransactionUseCase {
    private final TransactionRepository transactionRepository;

    public List<Transaction> transactionList() {
        return transactionRepository.transactionsList();
    }

    public Transaction makeTransaction(Transaction transactionRequest) {
        ValidationTool.validEntity(transactionRequest);
        return transactionRepository.makeTransaction(transactionRequest);
    }

    public Transaction getTransactionById(Integer id) {
        ValidationTool.idNotNull(id);
        Transaction transactionResponse = transactionRepository.findTransactionById(id);
        ValidationTool.entityNotNull(transactionResponse);
        return transactionResponse;
    }
}
