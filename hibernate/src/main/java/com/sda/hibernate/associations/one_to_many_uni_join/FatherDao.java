package com.sda.hibernate.associations.one_to_many_uni_join;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FatherDao {

    public void create(Father father) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(father);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Father findById(Long id) {
        Father result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            result = session.find(Father.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
