package com.bucur.associations.one_to_many_uni;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MotherDao {

    public void create(Mother owner) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(owner);
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

    public Mother findById(Long id) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Mother owner = session.find(Mother.class, id);
            return owner;
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
