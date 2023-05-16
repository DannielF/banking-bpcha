package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data;

import org.joda.time.DateTime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TransactionDataRepository extends CrudRepository<TransactionData, Integer> {

    @Transactional(readOnly = true)
    List<TransactionData> getTransactionsDataByDateBetween(DateTime from, DateTime to);
}
