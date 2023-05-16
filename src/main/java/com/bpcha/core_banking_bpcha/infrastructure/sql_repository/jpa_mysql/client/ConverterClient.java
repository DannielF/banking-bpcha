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
        Client client = new Client();
        client.setClientId(clientData.getId());
        client.setPassword(clientData.getPassword());
        client.setState(clientData.getState());
        client.setAccounts(clientData.getAccountsData()
                .stream().map(ConverterAccount::toEntity)
                .collect(Collectors.toCollection(ArrayList::new))
        );
        return client;
    }

    public static ClientData toData(Client client) {
        ClientData clientData = new ClientData();
        clientData.setId(client.getClientId());
        clientData.setPassword(client.getPassword());
        clientData.setState(client.getState());
        clientData.setAccountsData(client.getAccounts()
                .stream().map(ConverterAccount::toData)
                .collect(Collectors.toCollection(ArrayList::new))
        );
        return clientData;
    }
}
