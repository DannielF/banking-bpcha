package com.bpcha.core_banking_bpcha.domain.usecase.person;

import com.bpcha.core_banking_bpcha.domain.model.person.Person;
import com.bpcha.core_banking_bpcha.domain.model.person.gateway.PersonRepository;
import com.bpcha.core_banking_bpcha.domain.model.shared.ValidationTool;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PersonUseCase {
    private final PersonRepository personRepository;

    public Person createPerson(Person personRequest) {
        ValidationTool.validEntity(personRequest);
        return personRepository.createPerson(personRequest);
    }

    public Person getPersonById(Integer id) {
        ValidationTool.idNotNull(id);
        Person personResponse = personRepository.findPersonById(id);
        ValidationTool.entityNotNull(personResponse);
        return personResponse;
    }

    public Person updatePerson(Integer id, Person personRequest) {
        ValidationTool.idNotNull(id);
        Person personResponse = this.getPersonById(id);
        ValidationTool.entityNotNull(personResponse);
        return personRepository.updatePerson(personRequest);
    }
}
