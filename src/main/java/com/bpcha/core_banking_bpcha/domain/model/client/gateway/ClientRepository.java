package com.bpcha.core_banking_bpcha.domain.model.client.gateway;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;

import java.util.List;

public interface ClientRepository {
    Client saveClient(Client client);
    Client findClientById(Integer id);
    List<Client> clientList();
    Client deleteClient(Integer id);
    Client updateClient(Client client);
}
