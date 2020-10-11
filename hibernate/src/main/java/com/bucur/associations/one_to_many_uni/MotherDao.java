package com.bucur.associations.one_to_many_uni;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MotherDao {

    public void create(Mother mother) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(mother);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Mother findById(Long id) {
        Mother result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            result = session.find(Mother.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
