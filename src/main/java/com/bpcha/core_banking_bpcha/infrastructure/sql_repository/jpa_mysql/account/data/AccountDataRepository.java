package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AccountDataRepository extends CrudRepository<AccountData, Integer> {

    @Transactional(readOnly = true)
    @Query("select a from AccountData a where a.state = 'TRUE'")
    AccountData[] getAccounts();

    @Transactional
    @Modifying
    @Query("update AccountData acd set acd.state = 'FALSE' where acd.id = :id")
    AccountData logicDeleteAccount(@Param(value = "id") Integer id);
}
