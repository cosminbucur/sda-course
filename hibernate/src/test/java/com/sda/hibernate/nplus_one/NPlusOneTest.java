package com.sda.hibernate.nplus_one;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NPlusOneTest {

    @BeforeEach
    void setUp() {
        NPlusOneDao dao = new NPlusOneDao();
        dao.save();
        System.out.println("data populated");
    }

    @Test
    void nPlusOneProblem() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Department> departments = session.createQuery("From Department", Department.class).getResultList();
            print(departments);
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("end");
    }

    @Test
    void nPlusOneFix() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Department> departments = session.createQuery("From Department d LEFT JOIN fetch d.doctors", Department.class).getResultList();
            print(departments);
        } catch (Exception e) {
            System.out.println("error");
        }
    }

    @Test
    void nPlusOneProblemCriteria() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Department> query = builder.createQuery(Department.class);
            Root<Department> root = query.from(Department.class);
            query.select(root);

            List<Department> departments = session.createQuery(query).getResultList();
            print(departments);
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("end");
    }

    @Test
    void nPlusOneFixCriteria() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Department> query = builder.createQuery(Department.class);
            Root<Department> root = query.from(Department.class);
            root.fetch("doctors", JoinType.LEFT);
            query.select(root);

            List<Department> departments = session.createQuery(query).getResultList();
            print(departments);
        } catch (Exception e) {
            System.out.println("error");
        }
        System.out.println("end");
    }

    private static void print(List<Department> departments) {
        for (Department department : departments) {
            System.out.println("Department: " + department.getName());
            List<Doctor> doctors = department.getDoctors();
            for (Doctor doctor : doctors) {
                System.out.println("    " + doctor.getId() + " - " + doctor.getName());
            }
            System.out.println();
        }
    }
}