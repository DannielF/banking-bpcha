package com.bpcha.core_banking_bpcha.domain.model.person.gateway;

import com.bpcha.core_banking_bpcha.domain.model.person.Person;

public interface PersonRepository {
    Person createPerson(Person person);
    Person findPersonById(Integer id);
    Person updatePerson(Person person);
}
