package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.adapter;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.model.client.gateway.ClientRepository;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.data.ClientDataRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryAdapter implements ClientRepository {

    private final ClientDataRepository repository;

    public ClientRepositoryAdapter(ClientDataRepository repository) {
        this.repository = repository;
    }

    @Override
    public Client saveClient(Client client) {
        return null;
    }

    @Override
    public Client findClientById(Integer id) {
        return null;
    }

    @Override
    public List<Client> clientList() {
        return null;
    }

    @Override
    public Client deleteClient(Integer id) {
        return null;
    }

    @Override
    public Client updateClient(Client client) {
        return null;
    }
}
