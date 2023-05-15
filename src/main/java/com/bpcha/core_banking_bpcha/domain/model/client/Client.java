package com.bpcha.core_banking_bpcha.domain.model.client;

import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Client extends Person {
    private Integer clientId;
    private String password;
    private String state;
}
