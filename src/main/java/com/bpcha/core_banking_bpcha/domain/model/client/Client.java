package com.bpcha.core_banking_bpcha.domain.model.client;

import com.bpcha.core_banking_bpcha.domain.model.account.Account;
import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Client extends Person {
    @Schema(example = "test123")
    private String password;
    @Schema(example = "True/False")
    private String state;
    private List<Account> accounts;
}
