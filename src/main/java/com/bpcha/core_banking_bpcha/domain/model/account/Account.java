package com.bpcha.core_banking_bpcha.domain.model.account;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Account {
    private Integer id;
    private String accountNumber;
    private String accountType;
    private float initialBalance;
    private String state;
    private ArrayList<Transaction> transactions;
    private Client client;
}
