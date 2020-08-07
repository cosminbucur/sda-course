package com.bucur.transactions;

import com.bucur.config.HibernateUtil;
import com.bucur.crud.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.logging.Logger;

public class DemoTransactionManagement {

    private static final Logger logger = Logger.getLogger(DemoTransactionManagement.class.getName());

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tx.setTimeout(5);

            // doSomething(session)
            Person person = new Person();
            person.setFirstName("alex");
            session.save(person);

            tx.commit();
        } catch (RuntimeException e) {
            // any exception thrown by hibernate are FATAL
            // you need to roll back the transaction and
            // close the current session immediately
            try {
                tx.rollback();
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
