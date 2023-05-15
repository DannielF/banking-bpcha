package com.bpcha.core_banking_bpcha.domain.model.transaction;

import lombok.*;
import org.joda.time.DateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Transaction {
    private DateTime date;
    private String transactionType;
    private float transactionValue;
    private float transactionBalance;
}
