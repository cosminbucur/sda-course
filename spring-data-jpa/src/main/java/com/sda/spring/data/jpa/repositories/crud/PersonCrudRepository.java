package com.sda.spring.data.jpa.repositories.crud;

import com.sda.spring.data.jpa.repositories.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonCrudRepository extends CrudRepository<Person, Long> {

    // derived query
    Optional<Person> findByName(String name);   // select * from person where name = :name

}
