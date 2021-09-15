package com.sda.hibernate.listeners.history;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CustomerHistoryRepository {

    public void create(CustomerHistory customerHistory) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

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

    public List<CustomerHistory> findAll() {
        List<CustomerHistory> result = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            Query<CustomerHistory> query = session.createQuery("FROM CustomerHistory", CustomerHistory.class);
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
