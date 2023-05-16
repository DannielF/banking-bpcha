package com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.person.adapter;

import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import com.bpcha.core_banking_bpcha.domain.model.person.gateway.PersonRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.BusinessException;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.person.ConverterPerson;
import com.bpcha.core_banking_bpcha.infrastructure.sql_repository.jpa_mysql.person.data.PersonDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PersonRepositoryAdapter implements PersonRepository {

    private final PersonDataRepository repository;

    @Override
    public Person createPerson(Person person) {
        var personData = ConverterPerson.toData(person);
        return ConverterPerson.toEntity(repository.save(personData));
    }

    @Override
    public Person findPersonById(Integer id) {
        var personData = repository.findById(id);
        personData.ifPresent(ConverterPerson::toEntity);
        throw new BusinessException("404 this is no the way");
    }

    @Override
    public Person updatePerson(Person person) {
        var personData = repository.findById(person.getId());
        personData.ifPresent(repository::save);
        throw new BusinessException("404 - No such person");
    }
}
