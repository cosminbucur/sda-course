package com.sda.spring.data.jpa.projections.repository;

import com.sda.spring.data.jpa.projections.model.Person;
import com.sda.spring.data.jpa.projections.view.PersonDto;
import com.sda.spring.data.jpa.projections.view.PersonView;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends Repository<Person, Long> {

    Person save(Person person);

    PersonView findByLastName(String lastName);

    PersonDto findByFirstName(String firstName);

    <T> T findByLastName(String lastName, Class<T> type);
}
