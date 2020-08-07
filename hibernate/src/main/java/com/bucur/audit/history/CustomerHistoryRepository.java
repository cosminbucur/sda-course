package com.bucur.audit.history;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerHistoryRepository {

    public void create(CustomerHistory customerHistory) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(customerHistory);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public CustomerHistory findById(Long id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            CustomerHistory customerHistory = session.find(CustomerHistory.class, id);
            return customerHistory;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(CustomerHistory customerHistory) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(customerHistory);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void delete(CustomerHistory customerHistory) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(customerHistory);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
