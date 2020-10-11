package com.bucur.crud;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class PersonAdvancedDao {

    private static final Logger logger = Logger.getLogger(PersonAdvancedDao.class.getName());

    private static final String PERSON_SAVED = "Person saved.";
    private static final String PERSON_FOUND = "Person found.";
    private static final String PERSON_UPDATED = "Person updated.";
    private static final String PERSON_DELETED = "Person deleted.";
    private static final String PERSONS_DELETED = "Persons deleted.";

    private static final String PERSON_SEARCH_FAILED = "Person search failed!";
    private static final String PERSONS_SEARCH_FAILED = "Persons search failed!";
    private static final String PERSON_NOT_SAVED = "Person not saved!";
    private static final String PERSON_NOT_FOUND = "Person not found!";
    private static final String PERSONS_NOT_FOUND = "Persons not found!";
    private static final String PERSON_NOT_UPDATED = "Person not updated!";
    private static final String PERSON_NOT_DELETED = "Person not deleted!";
    private static final String PERSONS_NOT_DELETED = "Persons not deleted!";

    /**
     * Insert a new Person into the database.
     *
     * @param person transient person to be persisted
     */
    public void create(Person person) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.save(person);
            transaction.commit();
            logger.info(PERSON_SAVED);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe(PERSON_NOT_SAVED);
        }
    }

    /**
     * Find an Person by its primary key.
     *
     * @param id of a Person
     * @return a person
     */
    public Person findById(Long id) {
        Person result = null;
        try (Session session = openSession()) {
            result = session.find(Person.class, id);
            if (result == null) {
                logger.info(PERSON_FOUND);
            }
        } catch (HibernateException e) {
            logger.severe(PERSON_SEARCH_FAILED);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Finds all Persons in the database.
     *
     * @return a list of Persons
     */
    public List<Person> findAll() {
        List<Person> result = null;
        try (Session session = openSession()) {
            Query<Person> query = session.createQuery("FROM Person", Person.class);
            result = query.getResultList();

            if (result.isEmpty()) {
                logger.warning(PERSONS_NOT_FOUND);
            }
        } catch (HibernateException e) {
            logger.severe(PERSONS_SEARCH_FAILED);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Finds a Person by email.
     *
     * @param email of the Person
     * @return a Person or null
     */
    public Person findByEmail(String email) {
        Person result = null;
        try (Session session = openSession()) {
            Query<Person> query = session.createQuery("FROM Person u WHERE u.email = :email", Person.class);
            query.setParameter("email", email);
            result = query.getSingleResult();

            if (result == null) {
                logger.warning(PERSON_NOT_FOUND + " by email: " + email);
            }
        } catch (HibernateException e) {
            logger.severe(PERSONS_SEARCH_FAILED);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Updates the state of a detached Person.
     *
     * @param person
     */
    public void update(Person person) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.update(person);
            transaction.commit();
            logger.info(PERSON_UPDATED);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe(PERSON_NOT_UPDATED);
            e.printStackTrace();
        }
    }

    /**
     * Delete a detached Person from the database.
     *
     * @param person
     */
    public void delete(Person person) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.delete(person);
            transaction.commit();
            logger.info(PERSON_DELETED);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe(PERSON_NOT_DELETED);
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            Query<Person> query = session.createQuery("FROM Person", Person.class);
            List<Person> persons = query.getResultList();
            for (Person person : persons) {
                session.delete(person);
            }
            transaction.commit();
            logger.info(PERSONS_DELETED);
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe(PERSONS_NOT_DELETED);
            e.printStackTrace();
        }
    }

    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }

}
