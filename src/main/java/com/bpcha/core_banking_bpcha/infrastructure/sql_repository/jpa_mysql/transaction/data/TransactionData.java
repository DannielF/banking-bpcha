package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.transaction.data;

import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;
import org.joda.time.DateTime;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "TRANSACTION")
public class TransactionData implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Column(name = "DATE")
    private DateTime date;

    @NotNull
    @Pattern(regexp = "DEPOSIT|WITHDRAWAL")
    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @NotNull
    @PositiveOrZero
    @Column(name = "TRANSACTION_VALUE")
    private float transactionValue;

    @NotNull
    @Column(name = "TRANSACTION_BALANCE")
    private float transactionBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID")
    private AccountData accountData;
}
