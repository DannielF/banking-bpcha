package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.adapter;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.model.client.gateway.ClientRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.ConverterClient;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.data.ClientDataRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ClientRepositoryAdapter implements ClientRepository {

    private final ClientDataRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(ClientRepositoryAdapter.class);

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
    public void deleteClient(Integer id) {
        repository.logicDeleteClient(id);
    }

    @Override
    public Client updateClient(Client client) {
        return ConverterClient.toEntity(repository.save(ConverterClient.toData(client)));
    }
}
