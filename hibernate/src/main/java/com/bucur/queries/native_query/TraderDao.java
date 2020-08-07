package com.bucur.queries.native_query;

import com.bucur.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TraderDao {

    private static final Logger logger = Logger.getLogger(TraderDao.class.getName());

    private Session session;
    private Transaction tx;

    public void create(Trader trader) {
        try {
            startOperation();
            session.save(trader);
            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error creating trader " + trader);
        }
    }

    public List findAllWithNativeQuery() {
        String sql = "SELECT * FROM trader";

        List result = new ArrayList();
        try {
            startOperation();

            // query using native SQL
            NativeQuery nativeQuery = session.createNativeQuery(sql, Trader.class);
            result = nativeQuery.list();

            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error executing sql: " + sql);
        }
        return result;
    }

    public List findAllByNameWithNamedNativeQuery(String name) {
        String nativeQueryName = "findTradersByNameNativeSQL";
        List result = new ArrayList();
        try {
            startOperation();

            // named query with parameters using native SQL
            Query<Trader> namedNativeQuery = session.createNamedQuery(nativeQueryName, Trader.class);
            // use query from org.hibernate.query
            namedNativeQuery.setParameter("name", name);
            result = namedNativeQuery.list();

            tx.commit();
            session.close();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("error executing named query: " + nativeQueryName);
        }
        return result;
    }

    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}
