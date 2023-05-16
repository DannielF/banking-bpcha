package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.adapter;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.model.client.gateway.ClientRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.ConverterClient;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.data.ClientDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepository {

    private final ClientDataRepository repository;

    @Override
    public Client saveClient(Client client) {
        var clientData = ConverterClient.toData(client);
        return ConverterClient.toEntity(repository.save(clientData));
    }

    @Override
    public Client findClientById(Integer id) {

        var clientData = repository.findById(id);
        if (clientData.isPresent()) return ConverterClient.toEntity(clientData.get());
        throw new BusinessException("404");
    }

    @Override
    public List<Client> clientList() {
        var clientList = repository.getClients();
        return clientList.stream().map(ConverterClient::toEntity).toList();
    }

    @Override
    public Client deleteClient(Integer id) {
        var clientData = repository.findById(id);
        clientData.ifPresent(data -> repository.logicDeleteClient(data.getId()));
        throw new BusinessException("YOU HAS DELETED THE WHOLE DB");
    }

    @Override
    public Client updateClient(Client client) {
        var clientData = repository.findById(client.getId());
        clientData.ifPresent(repository::save);
        throw new BusinessException("It couldn't be updated");
    }
}
