package com.sda.hibernate.crud;

public class DemoCrud {

    public static void main(String[] args) {
        PersonDao personDao = new PersonDao();

        Person person = new Person();
        person.setFirstName("jon");
        person.setLastName("snow");
        person.setEmail("jonsnow@gmail.com");
        person.setCountry("westeros");

        PersonAdvancedDao personAdvancedDao = new PersonAdvancedDao();
        personAdvancedDao.create(person);
        personAdvancedDao.findById(1L);

        // create
        personDao.create(person);

        // read
        Person newPerson = personDao.findById(1L);

        newPerson.setFirstName("jon1");
        newPerson.setLastName("snow1");
        newPerson.setEmail("jonsnow1@gmail.com");
        newPerson.setCountry("nights watch");

        // update
        personDao.update(newPerson);

        // delete
        Person updatedPerson = personDao.findById(1L);
        personDao.delete(updatedPerson);
    }
}
