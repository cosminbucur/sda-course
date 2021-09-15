package com.sda.hibernate.transactions;

import com.sda.hibernate.config.HibernateUtil;
import com.sda.hibernate.crud.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.logging.Logger;

public class DemoTransactionManagement {

    private static final Logger logger = Logger.getLogger(DemoTransactionManagement.class.getName());

    public static void main(String[] args) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            transaction.setTimeout(5);

            Person person = new Person();
            person.setFirstName("alex");
            session.save(person);

            transaction.commit();
        } catch (RuntimeException e) {
            // any exception thrown by hibernate are FATAL
            // you need to roll back the transaction and
            // close the current session immediately
            try {
                if (transaction != null) {
                    transaction.rollback();
                }
            } catch (RuntimeException rbe) {
                logger.severe("could not roll back transaction " + rbe);
            }
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
