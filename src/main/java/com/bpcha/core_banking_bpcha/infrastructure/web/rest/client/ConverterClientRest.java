package com.bpcha.core_banking_bpcha.infrastructure.web.rest.client;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;

public class ConverterClientRest {

    public static Client toEntity(ClientDTO clientDTO) {
        return new Client().toBuilder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .age(clientDTO.getAge())
                .documentId(clientDTO.getDocumentId())
                .gender(clientDTO.getGender())
                .state(clientDTO.getState())
                .address(clientDTO.getAddress())
                .password(clientDTO.getPassword())
                .phoneNumber(clientDTO.getPhoneNumber())
                .build();
    }

    public static ClientDTO toDTO(Client client) {
        return new ClientDTO().toBuilder()
                .id(client.getId())
                .name(client.getName())
                .age(client.getAge())
                .documentId(client.getDocumentId())
                .gender(client.getGender())
                .state(client.getState())
                .address(client.getAddress())
                .password(client.getPassword())
                .phoneNumber(client.getPhoneNumber())
                .build();
    }
}
