package com.bpcha.core_banking_bpcha.domain.model.person;

import lombok.*;
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
    private String age;
    private Integer documentId;
    private String address;
    private String phoneNumber;
}
