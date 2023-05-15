package com.bpcha.core_banking_bpcha.domain.model.person;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Person {
    private String name;
    private String genre;
    private String age;
    private String id;
    private String address;
    private String phoneNumber;
}
