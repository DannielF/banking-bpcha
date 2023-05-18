package com.bpcha.core_banking_bpcha.infrastructure.web.rest.client;

import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import com.bpcha.core_banking_bpcha.infrastructure.web.rest.account.AccountDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@SuperBuilder(toBuilder = true)
public class ClientDTO extends Person {
    private Integer id;
    private String password;
    private String state;
    private List<AccountDTO> accounts;
}
