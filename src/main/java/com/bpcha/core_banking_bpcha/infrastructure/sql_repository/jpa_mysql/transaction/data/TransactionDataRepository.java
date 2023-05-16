package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data;

import org.springframework.data.repository.CrudRepository;

public interface TransactionDataRepository extends CrudRepository<TransactionData, Integer> {
}
