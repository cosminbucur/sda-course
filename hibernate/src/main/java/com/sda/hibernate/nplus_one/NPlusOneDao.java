package com.sda.hibernate.nplus_one;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NPlusOneDao {

    public void save() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Doctor doctor1 = new Doctor("doctor1");
            Doctor doctor2 = new Doctor("doctor2");
            Doctor doctor3 = new Doctor("doctor3");

            Department department1 = new Department("department1");
            Department department2 = new Department("department2");

            department1.getDoctors().add(doctor1);
            doctor1.setDepartment(department1);

            department1.getDoctors().add(doctor2);
            doctor2.setDepartment(department1);

            department2.getDoctors().add(doctor3);
            doctor3.setDepartment(department2);

            session.persist(department1);
            session.persist(department2);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
