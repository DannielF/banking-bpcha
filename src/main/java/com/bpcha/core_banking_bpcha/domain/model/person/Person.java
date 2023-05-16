package com.bpcha.core_banking_bpcha.domain.model.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class Person {
    private Integer id;
    private String name;
    private String gender;
    private Integer age;
    private Integer documentId;
    private String address;
    private Integer phoneNumber;
}
