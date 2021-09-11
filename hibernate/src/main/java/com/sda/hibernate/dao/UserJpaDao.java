package com.bucur.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.bucur.config.JpaUtil.getEntityManager;

// https://www.baeldung.com/hibernate-entitymanager
// https://juliuskrah.com/tutorial/2017/02/15/crud-operations-with-hibernate-and-jpa/
// https://github.com/eugenp/tutorials/blob/master/persistence-modules/hibernate5/src/main/java/com/baeldung/hibernate/operations/HibernateOperations.java
public class UserJpaDao implements UserDao {

    // TODO: finish crud from example
    private static final Logger logger = Logger.getLogger(UserJpaDao.class.getName());

    public void create(User user) {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe("error creating user " + user);
        }
    }

    public List<User> findAll() {
        List<User> result = new ArrayList<>();
        String jpql = "SELECT u FROM User u";
        try {
            EntityManager entityManager = getEntityManager();
            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            result = query.getResultList();
        } catch (Exception e) {
            logger.severe("failed to find all");
        }

        return result;
    }

    public User findById(Long id) {
        User result = null;
        try {
            EntityManager entityManager = getEntityManager();
            result = entityManager.find(User.class, id);
        } catch (Exception e) {
            logger.severe("failed to find");
        }
        return result;
    }

    public void update(Long id, User userData) {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            User userToUpdate = entityManager.find(User.class, id);
            userToUpdate.setName(userData.getName());
            userToUpdate.setEmail(userData.getEmail());
            userToUpdate.setPassword(userData.getPassword());

            entityManager.merge(userToUpdate);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe("failed to update");
        }
    }

    public void delete(Long id) {
        EntityTransaction transaction = null;
        try {
            EntityManager entityManager = getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();
            User userToDelete = entityManager.find(User.class, id);

            entityManager.remove(userToDelete);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe("failed to delete");
        }
    }

    public void deleteAll() {
        EntityTransaction transaction = null;
        String jpql = "DELETE FROM User";
        try {
            EntityManager entityManager = getEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
            query.executeUpdate();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
