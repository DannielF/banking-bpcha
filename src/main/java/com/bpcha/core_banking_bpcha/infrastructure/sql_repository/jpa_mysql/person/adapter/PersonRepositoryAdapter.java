package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.person.adapter;

import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import com.bpcha.core_banking_bpcha.domain.model.person.gateway.PersonRepository;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.person.data.PersonDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryAdapter implements PersonRepository {

    private final PersonDataRepository repository;

    @Override
    public Person createPerson(Person person) {
        return null;
    }

    @Override
    public Person findPersonById(Integer id) {
        return null;
    }

    @Override
    public Person updatePerson(Person person) {
        return null;
    }
}
