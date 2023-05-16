package com.bpcha.core_banking_bpcha.domain.usecase.client;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.model.client.gateway.ClientRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.domain.model.shared.TypeExceptions;
import com.bpcha.core_banking_bpcha.domain.model.shared.ValidationTool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Component
public class ClientUseCase {
    private final ClientRepository clientRepository;
    public List<Client> getAllClients() {
        return clientRepository.clientList();
    }

    public Client getClientById(Integer id) {
        ValidationTool.idNotNull(id);
        Client clientResponse = clientRepository.findClientById(id);
        ValidationTool.entityNotNull(clientResponse);
        return clientResponse;
    }

    public Client saveClient(Client clientRequest) {
        ValidationTool.validEntity(clientRequest);
        return clientRepository.saveClient(clientRequest);
    }

    public Client updateClient(Client clientRequest) {
        if (Objects.isNull(clientRequest)) throw new BusinessException(TypeExceptions.REQUEST_CANNOT_BE_NULL_CHECK_REQUEST.toString());
        Client clientResponse = this.getClientById(clientRequest.getId());
        if (Objects.isNull(clientResponse)) {
            throw new BusinessException(TypeExceptions.ENTITY_DOESNT_EXIST_CANNOT_BE_UPDATED.toString());
        }
        return clientRepository.updateClient(clientRequest);
    }

    public Client deleteClient(Integer id) {
        Client clientResponse = this.getClientById(id);
        if (Objects.isNull(clientResponse)) {
            throw new BusinessException(TypeExceptions.ENTITY_DOESNT_EXIST_CANNOT_BE_DELETED.toString());
        }
        return clientRepository.deleteClient(id);
    }
}
