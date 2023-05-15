package com.bpcha.core_banking_bpcha.domain.model.transaction;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import lombok.*;
import org.joda.time.DateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Transaction {
    private Integer id;
    private DateTime date;
    private String transactionType;
    private float transactionValue;
    private float transactionBalance;
    private Account account;
}
