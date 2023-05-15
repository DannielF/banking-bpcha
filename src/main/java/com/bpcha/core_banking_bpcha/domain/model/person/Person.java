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
    private Integer id;
    private String address;
    private String phoneNumber;
}
