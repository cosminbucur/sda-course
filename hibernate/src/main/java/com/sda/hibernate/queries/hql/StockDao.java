package com.sda.hibernate.queries.hql;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StockDao {

    private static final Logger logger = Logger.getLogger(StockDao.class.getName());

    public void create(Stock stock) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.save(stock);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe("error creating stock " + stock);
        }
    }

    public List<Stock> findAllWithHqlQuery() {
        String hql = "FROM com.sda.hibernate.queries.hql.Stock";
        List<Stock> result = new ArrayList<>();
        try (Session session = openSession()) {

            // query using HQL
            Query<Stock> query = session.createQuery(hql, Stock.class);
            result = query.getResultList();
        } catch (Exception e) {
            logger.severe("error executing hql: " + hql);
        }
        return result;
    }

    public List<Stock> findAllByStockCodeWithNamedQuery(String stockCode) {
        List<Stock> result = new ArrayList<>();
        String queryName = "Stock.findAllByStockCode";
        try (Session session = openSession()) {

            // named query with parameters using HQL
            Query<Stock> query = session.createNamedQuery(queryName, Stock.class);
            query.setParameter("stockCode", stockCode);
            result = query.getResultList();
        } catch (Exception e) {
            logger.severe("error executing named query: " + queryName);
        }
        return result;
    }

    public List<Stock> findAllOrderedByName() {
        List<Stock> result = new ArrayList<>();
        String queryName = "Stock.findAllOrderedByName";
        try (Session session = openSession()) {

            Query<Stock> query = session.createNamedQuery(queryName, Stock.class);
            result = query.getResultList();
        } catch (Exception e) {
            logger.severe("error executing named query: " + queryName);
        }
        return result;
    }

    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
