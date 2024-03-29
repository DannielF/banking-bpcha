package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.client.data;


import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.account.data.AccountData;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.person.data.PersonData;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@Entity
@Table(name = "CLIENT")
public class ClientData extends PersonData implements Serializable {

    @NotEmpty
    @Column(name = "PASSWORD")
    private String password;

    @NotEmpty
    @Column(name = "STATE")
    private String state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
    private List<AccountData> accounts;
}


