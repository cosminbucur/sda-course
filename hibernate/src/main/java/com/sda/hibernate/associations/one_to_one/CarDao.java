package com.bucur.associations.one_to_one;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarDao {

    public void create(Car car) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Car findById(Long id) {
        Car result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            result = session.find(Car.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
