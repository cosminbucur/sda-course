package com.bucur.queries.hql;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class StockDao {

    private static final Logger logger = Logger.getLogger(StockDao.class.getName());

    private Session session;
    private Transaction tx;

    public void create(Stock stock) {
        try {
            startOperation();
            session.save(stock);
            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error creating stock " + stock);
        }
    }

    public List findAllWithHqlQuery() {
        String hql = "from com.bucur.hql.Stock";

        List result = new ArrayList();
        try {
            startOperation();

            // query using HQL
            Query query = session.createQuery(hql, Stock.class);
            result = query.getResultList();

            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error executing hql: " + hql);
        }
        return result;
    }

    public List findAllByStockCodeWithNamedQuery(String stockCode) {
        List result = new ArrayList();
        try {
            startOperation();

            // named query with parameters using HQL
            Query query = session.createNamedQuery("findStockByStockCode", Stock.class);
            // use query from javax.persistence
            query.setParameter("stockCode", stockCode);
            result = query.getResultList();

            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error executing named query: findStockByStockCode");
        }
        return result;
    }

    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}
