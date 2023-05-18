package com.bpcha.core_banking_bpcha.infrastructure.web.rest.account;

import com.bpcha.core_banking_bpcha.infrastructure.web.rest.client.ClientDTO;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
public class AccountDTO {
    private Integer id;
    private String accountNumber;
    private String accountType;
    private float initialBalance;
    private String state;
    private ClientDTO clientDTO;
}
