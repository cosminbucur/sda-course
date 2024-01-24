package com.sda.spring.data.jpa.projections;

import com.sda.spring.data.jpa.projections.model.Address;
import com.sda.spring.data.jpa.projections.model.Person;
import com.sda.spring.data.jpa.projections.repository.AddressRepository;
import com.sda.spring.data.jpa.projections.repository.PersonRepository;
import com.sda.spring.data.jpa.projections.view.AddressView;
import com.sda.spring.data.jpa.projections.view.PersonDto;
import com.sda.spring.data.jpa.projections.view.PersonView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
//@Sql(scripts = "/projection-insert-data.sql")
//@Sql(scripts = "/projection-clean-up-data.sql", executionPhase = AFTER_TEST_METHOD)
class JpaProjectionIntegrationTest {
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void whenUsingClosedProjections_thenViewWithRequiredPropertiesIsReturned() {
        AddressView addressView = addressRepository.getAddressByState("CA").get(0);
        assertThat(addressView.getZipCode()).isEqualTo("90001");

        PersonView personView = addressView.getPerson();
        assertThat(personView.getFirstName()).isEqualTo("John");
        assertThat(personView.getLastName()).isEqualTo("Doe");
    }

    @Test
    void whenUsingOpenProjections_thenViewWithRequiredPropertiesIsReturned() {
        PersonView personView = personRepository.findByLastName("Doe");
        assertThat(personView.getFullName()).isEqualTo("John Doe");
    }

    @Test
    void whenUsingClassBasedProjections_thenDtoWithRequiredPropertiesIsReturned() {
        PersonDto personDto = personRepository.findByFirstName("John");
        assertThat(personDto.getFirstName()).isEqualTo("John");
        assertThat(personDto.getLastName()).isEqualTo("Doe");
    }

    @Test
    void whenUsingDynamicProjections_thenObjectWithRequiredPropertiesIsReturned() {
        Address address = new Address();
        address.setId(1L);
        address.setState("CA");
        address.setCity("Los Angeles");
        address.setStreet("Standford Ave");
        address.setZipCode("90001");

        Person newPerson = new Person();
        newPerson.setId(1L);
        newPerson.setFirstName("John");
        newPerson.setLastName("Doe");
        newPerson.setAddress(address);
        address.setPerson(newPerson);

        personRepository.save(newPerson);

        Person person = personRepository.findByLastName("Doe", Person.class);
        PersonView personView = personRepository.findByLastName("Doe", PersonView.class);
        PersonDto personDto = personRepository.findByLastName("Doe", PersonDto.class);

        assertThat(person.getFirstName()).isEqualTo("John");
        assertThat(personView.getFirstName()).isEqualTo("John");
        assertThat(personDto.getFirstName()).isEqualTo("John");
    }
}
