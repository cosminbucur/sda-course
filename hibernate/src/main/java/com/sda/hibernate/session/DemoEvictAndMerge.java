package com.sda.hibernate.session;

import com.sda.hibernate.config.HibernateUtil;
import com.sda.hibernate.crud.Person;
import com.sda.hibernate.crud.PersonDao;
import org.hibernate.Session;

// sometime we need to detach the session object because we need to change it
// and it may take some time. it's better to detach object from hibernate session
public class DemoEvictAndMerge {

    public static void main(String[] args) {
        PersonDao dao = new PersonDao();

        Person person = new Person();
        person.setFirstName("jon");
        person.setLastName("snow");
        person.setEmail("jonsnow@gmail.com");
        person.setCountry("westeros");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        dao.create(person);

        Person foundPerson = session.find(Person.class, 1L);
        System.out.println("persisted - first name = " + foundPerson.getFirstName());

        // evict the object
        session.evict(foundPerson);
        foundPerson.setFirstName("evicted");

        // flushing is the process of synchronizing the underlying persistent
        // store with persistable state held in memory.
        // Must be called at the end of a unit of work, before committing the
        // transaction and closing the session
        session.flush();

        foundPerson = session.find(Person.class, 1L);
        System.out.println("after evict - first name = " + foundPerson.getFirstName());

        // merge object

        session.merge(foundPerson);

        foundPerson.setFirstName("merged");

        session.flush();

        foundPerson = session.find(Person.class, 1L);
        System.out.println("after merge - first name = " + foundPerson.getFirstName());
        session.close();
    }
}
