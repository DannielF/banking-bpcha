package com.bpcha.core_banking_bpcha.infrastructure.web.rest.account;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class AccountDTO {
    private String accountNumber;
    private String accountType;
    private float initialBalance;
    private String state;
    private Integer clientId;
}
