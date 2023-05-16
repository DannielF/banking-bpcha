package com.bpcha.core_banking_bpcha.domain.model.client;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Client extends Person {
    private Integer id;
    private String password;
    private String state;
    private ArrayList<Account> accounts;
}
