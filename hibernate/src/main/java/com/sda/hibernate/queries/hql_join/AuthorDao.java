package com.bucur.queries.hql_join;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class AuthorDao {

    public void create(Author author) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(author);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    // works with lazy collections
    public List<Author> findAuthorsWithBookPriceJoinFetch(int price) {
        String hql = "SELECT a FROM Author a " +
            "JOIN FETCH a.books b " +
            "WHERE b.price = :price";
        List<Author> result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Author> query = session.createQuery(hql, Author.class);
            query.setParameter("price", price);
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // works with eager collections
    public List<Author> findAuthorsWithBookPriceInnerJoin(int price) {
        String hql = "SELECT a FROM Author a " +
            "INNER JOIN a.books b " +
            "WHERE b.price = :price";
        List<Author> result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Author> query = session.createQuery(hql, Author.class);
            query.setParameter("price", price);
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<Author> findUsingLikeQuery(String prefix) {
        String hql = "SELECT a FROM Author a " +
            "INNER JOIN a.books b " +
            "WHERE b.title LIKE :prefix";
        List<Author> result = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Author> query = session.createQuery(hql, Author.class);
            query.setParameter("prefix", "%" + prefix + "%");
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
