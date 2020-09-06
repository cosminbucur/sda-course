package com.bucur.crud;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.logging.Logger;

public class PersonAdvancedDao {

    private static final Logger logger = Logger.getLogger(PersonAdvancedDao.class.getName());

    private Session session;
    private Transaction tx;

    /**
     * Insert a new Person into the database.
     *
     * @param person
     */
    public void create(Person person) {
        try {
            startOperation();
            session.save(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save person");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Find an Person by its primary key.
     *
     * @param id
     * @return a person
     */
    public Person findById(Long id) {
        Person person = null;
        try {
            startOperation();
            person = session.find(Person.class, id);
            return person;
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return person;
    }

    /**
     * Finds all Persons in the database.
     *
     * @return a list of Persons
     */
    public List findAll() {
        List<Person> persons = null;
        try {
            startOperation();
            Query query = session.createQuery("FROM Person");
            persons = query.list();
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return persons;
    }

    /**
     * Updates the state of a detached Person.
     *
     * @param person
     */
    public void update(Person person) {
        try {
            startOperation();
            session.update(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     * Delete a detached Person from the database.
     *
     * @param person
     */
    public void delete(Person person) {
        Session session = null;
        try {
            startOperation();
            session.delete(person);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private void startOperation() throws HibernateException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

}
