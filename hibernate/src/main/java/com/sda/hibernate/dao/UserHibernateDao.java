package com.sda.hibernate.dao;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserHibernateDao implements UserDao {

    private static final Logger logger = Logger.getLogger(UserHibernateDao.class.getName());

    public void create(User user) {
        // create session
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // begin transaction
            transaction = session.beginTransaction();

            // execute operations
            // * if error -> rollback transaction
            session.save(user);

            // commit
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        // close session
    }

    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // similar to select * from user
            // hibernate query language HQL
            String hql = "from User";
            Query<User> query = session.createQuery(hql, User.class);
            result = query.getResultList();
        } catch (Exception e) {
            logger.severe("failed to find all");
        }

        return result;
    }

    public User findById(Long id) {
        User result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            result = session.find(User.class, id);
        } catch (Exception e) {
            logger.severe("failed to find");
        }
        return result;
    }

    public void update(Long id, User userData) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            User userToUpdate = findById(id);
            userToUpdate.setName(userData.getName());
            userToUpdate.setEmail(userData.getEmail());
            userToUpdate.setPassword(userData.getPassword());

            transaction = session.beginTransaction();

            session.update(userToUpdate);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void delete(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            User userToDelete = findById(id);
            transaction = session.beginTransaction();
            session.delete(userToDelete);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteAll() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "DELETE FROM User";
            Query<User> query = session.createQuery(hql, User.class);
            query.executeUpdate();

//            List<User> allUsers = findAll();
//            for (User user : allUsers) {
//                session.delete(user.getId());
//            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
}
