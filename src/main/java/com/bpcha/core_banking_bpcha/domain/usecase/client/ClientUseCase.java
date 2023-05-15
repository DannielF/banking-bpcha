package com.bpcha.core_banking_bpcha.domain.usecase.client;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.model.client.gateway.ClientRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.domain.model.shared.TypeExceptions;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public class ClientUseCase {
    private final ClientRepository clientRepository;
    public List<Client> getAllClients() {
        return clientRepository.clientList();
    }

    public Client getClientById(Integer id) {
        if (id == null) throw new BusinessException(TypeExceptions.ID_CANNOT_BE_NULL.toString());

        Client clientResponse = clientRepository.findClientById(id);
        if (Objects.isNull(clientResponse)) {
            throw new BusinessException(TypeExceptions.ENTITY_NOT_FOUND_CHECK_ID.toString());
        }
        return clientResponse;
    }

    public Client saveClient(Client clientRequest) {
        if (Objects.isNull(clientRequest)) throw new BusinessException(TypeExceptions.REQUEST_CANNOT_BE_NULL.toString());
        return clientRepository.saveClient(clientRequest);
    }

    public Client updateClient(Client clientRequest) {
        if (Objects.isNull(clientRequest)) throw new BusinessException(TypeExceptions.REQUEST_CANNOT_BE_NULL.toString());
        Client clientResponse = this.getClientById(clientRequest.getClientId());
        if (Objects.isNull(clientResponse)) {
            throw new BusinessException(TypeExceptions.ENTITY_DOESNT_EXIST_CANNOT_BE_UPDATED.toString());
        }
        return clientRepository.updateClient(clientRequest);
    }

    public Client deleteClient(Client clientRequest) {
        Client clientResponse = this.getClientById(clientRequest.getClientId());
        if (Objects.isNull(clientResponse)) {
            throw new BusinessException(TypeExceptions.ENTITY_DOESNT_EXIST_CANNOT_BE_DELETED.toString());
        }
        return clientRepository.deleteClient(clientRequest);
    }
}
