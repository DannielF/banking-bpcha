package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data;

import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.data.ClientData;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data.TransactionData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "ACCOUNT")
public class AccountData implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @NotNull
    @Column(name = "ACCOUNT_TYPE")
    private String accountType;

    @NotNull
    @PositiveOrZero
    @Column(name = "INITIAL_BALANCE")
    private float initialBalance;

    @NotNull
    @Column(name = "STATE")
    private String state;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLIENT", referencedColumnName = "ID")
    private ClientData clientData;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountData")
    private ArrayList<TransactionData> transactions;
}