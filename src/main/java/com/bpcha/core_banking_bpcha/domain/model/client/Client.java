package com.bpcha.core_banking_bpcha.domain.model.client;

import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Client extends Person {
    private Integer clientId;
    private String password;
    private String state;
}
