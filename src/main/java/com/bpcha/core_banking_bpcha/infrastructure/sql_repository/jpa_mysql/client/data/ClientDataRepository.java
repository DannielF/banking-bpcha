package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ClientDataRepository extends CrudRepository<ClientData, Integer> {

    @Transactional(readOnly = true)
    @Query("select c from ClientData c where c.state = 'TRUE'")
    public ClientData getClients();
}
