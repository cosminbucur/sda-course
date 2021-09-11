package com.bucur.states;

import com.bucur.config.HibernateUtil;
import com.bucur.crud.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DemoHibernateStates {

    public static void main(String[] args) {

        Person person = new Person();
        person.setFirstName("jon");
        person.setLastName("snow");
        person.setEmail("jonsnow@gmail.com");
        person.setCountry("westeros");
        // Transient object state

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        // Persistent object state

        session.close();
        // Detached object state
    }
}
