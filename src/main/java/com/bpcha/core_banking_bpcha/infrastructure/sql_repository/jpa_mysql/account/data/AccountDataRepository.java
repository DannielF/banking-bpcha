package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountDataRepository extends CrudRepository<AccountData, Integer> {

    @Query("select a from AccountData a where a.state = 'TRUE'")
    List<AccountData> getAccounts();

    @Modifying
    @Query("update AccountData acd set acd.state = 'FALSE' where acd.id = :id")
    AccountData logicDeleteAccount(@Param(value = "id") Integer id);
}
