package com.bucur.associations.one_to_many_bi;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ChildDao {

    public void create(Child child) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(child);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Child findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Child child = session.find(Child.class, id);
            return child;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
