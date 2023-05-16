package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.ConverterAccount;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.data.ClientData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class ConverterClient {

    public static Client toEntity(ClientData clientData) {
        return new Client().toBuilder()
                .id(clientData.getId())
                .password(clientData.getPassword())
                .state(clientData.getState())
                .accounts(clientData.getAccountsData()
                        .stream().map(ConverterAccount::toEntity)
                        .collect(Collectors.toCollection(ArrayList::new))
                ).build();
    }

    public static ClientData toData(Client client) {
        return new ClientData().toBuilder()
                .id(client.getId())
                .password(client.getPassword())
                .state(client.getState())
                .accountsData(client.getAccounts()
                        .stream().map(ConverterAccount::toData)
                        .collect(Collectors.toCollection(ArrayList::new))
                ).build();
    }
}
