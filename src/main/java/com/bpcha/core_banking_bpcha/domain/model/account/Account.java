package com.bpcha.core_banking_bpcha.domain.model.account;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Account {
    private String accountNumber;
    private String accountType;
    private float initialBalance;
    private String state;
}
