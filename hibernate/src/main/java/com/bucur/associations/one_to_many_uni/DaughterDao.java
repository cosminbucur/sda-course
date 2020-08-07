package com.bucur.associations.one_to_many_uni;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DaughterDao {

    public void create(Daughter daughter) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(daughter);
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

    public Daughter findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Daughter daughter = session.find(Daughter.class, id);
            return daughter;
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
