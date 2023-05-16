package com.bpcha.core_banking_bpcha.domain.usecase.transaction;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.domain.model.account.gateway.AccountRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.domain.model.shared.TypeExceptions;
import com.bpcha.core_banking_bpcha.domain.model.shared.ValidationTool;
import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import com.bpcha.core_banking_bpcha.domain.model.transaction.gateway.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.DateTime;

import java.util.List;

@RequiredArgsConstructor
public class TransactionUseCase {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    public List<Transaction> transactionList() {
        return transactionRepository.transactionsList();
    }

    public Transaction makeDepositTransaction(Integer accountId, Transaction transactionRequest) {
        ValidationTool.validEntity(transactionRequest);
        Account accountResponse = accountRepository.findAccountById(accountId);
        if (transactionRequest.getTransactionType().equalsIgnoreCase("DEPOSIT")) {
             float previousBalance = accountResponse.getInitialBalance();
             transactionRequest.setTransactionBalance(previousBalance);
             accountResponse.setInitialBalance(previousBalance + transactionRequest.getTransactionValue());
             accountRepository.updateAccount(accountResponse);
            return transactionRepository.makeTransaction(transactionRequest);
        }
        throw new BusinessException(TypeExceptions.INVALID_TYPE_TRANSACTION.toString());
    }

    public Transaction makeWithdrawalTransaction(Integer accountId, Transaction transactionRequest) {
        ValidationTool.validEntity(transactionRequest);
        Account accountResponse = accountRepository.findAccountById(accountId);
        if (transactionRequest.getTransactionType().equalsIgnoreCase("WITHDRAWAL")) {
            float previousBalance = accountResponse.getInitialBalance();
            transactionRequest.setTransactionBalance(previousBalance);
            accountResponse.setInitialBalance(previousBalance - transactionRequest.getTransactionValue());
            accountRepository.updateAccount(accountResponse);
            return transactionRepository.makeTransaction(transactionRequest);
        }
        throw new BusinessException(TypeExceptions.INVALID_TYPE_TRANSACTION.toString());
    }

    public Transaction getTransactionById(Integer id) {
        ValidationTool.idNotNull(id);
        Transaction transactionResponse = transactionRepository.findTransactionById(id);
        ValidationTool.entityNotNull(transactionResponse);
        return transactionResponse;
    }

    public List<Transaction> getTransactionsByDateBetween(DateTime from, DateTime to) {
        var transactionResponse = transactionRepository.transactionsListBetweenDate(from, to);
        ValidationTool.entityNotNull(transactionResponse);
        return transactionResponse;
    }
}
