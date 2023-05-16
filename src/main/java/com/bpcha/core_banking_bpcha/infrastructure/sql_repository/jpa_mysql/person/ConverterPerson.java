package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.person;

import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.person.data.PersonData;
import org.springframework.stereotype.Component;

@Component
public class ConverterPerson {

    public static Person toEntity(PersonData personData) {
        return new Person().toBuilder()
                .id(personData.getId())
                .name(personData.getName())
                .age(personData.getAge())
                .gender(personData.getGender())
                .address(personData.getAddress())
                .documentId(personData.getDocumentId())
                .phoneNumber(personData.getPhoneNumber())
                .build();
    }

    public static PersonData toData(Person person) {
        return new PersonData().toBuilder()
                .id(person.getId())
                .name(person.getName())
                .age(person.getAge())
                .gender(person.getGender())
                .address(person.getAddress())
                .documentId(person.getDocumentId())
                .phoneNumber(person.getPhoneNumber())
                .build();
    }
}
