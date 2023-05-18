package com.bpcha.core_banking_bpcha.domain.model.account;

import com.bpcha.core_banking_bpcha.domain.model.client.Client;
import com.bpcha.core_banking_bpcha.domain.model.transaction.Transaction;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Account {
    private Integer id;
    @Schema(example = "ABC123")
    private String accountNumber;
    @Schema(example = "SAVINGS/LOAN")
    private String accountType;
    @Schema(example = "1000.0")
    private float initialBalance;
    @Schema(example = "True/False")
    private String state;
    private List<Transaction> transactions;
    private Client client;
}
