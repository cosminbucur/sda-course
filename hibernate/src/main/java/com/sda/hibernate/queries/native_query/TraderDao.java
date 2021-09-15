package com.sda.hibernate.queries.native_query;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TraderDao {

    private static final Logger logger = Logger.getLogger(TraderDao.class.getName());

    public void create(Trader trader) {
        Transaction transaction = null;
        try (Session session = openSession()) {
            transaction = session.beginTransaction();
            session.save(trader);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            logger.severe("error creating trader " + trader);
        }
    }

    public List<Trader> findAllWithNativeQuery() {
        String sql = "SELECT * FROM trader";

        List<Trader> result = new ArrayList<>();
        try (Session session = openSession()) {

            // query using native SQL
            NativeQuery<Trader> nativeQuery = session.createNativeQuery(sql, Trader.class);
            result = nativeQuery.list();
        } catch (Exception e) {
            logger.severe("error executing sql: " + sql);
        }
        return result;
    }

    public List<Trader> findAllByNameWithNamedNativeQuery(String name) {
        String nativeQueryName = "Trader.findByName";
        List<Trader> result = new ArrayList<>();
        try (Session session = openSession()) {
            // named query with parameters using native SQL
            Query<Trader> namedNativeQuery = session.createNamedQuery(nativeQueryName, Trader.class);
            // use query from org.hibernate.query
            namedNativeQuery.setParameter("name", name);
            result = namedNativeQuery.list();
        } catch (Exception e) {
            logger.severe("error executing named query: " + nativeQueryName);
        }
        return result;
    }

    private Session openSession() {
        return HibernateUtil.getSessionFactory().openSession();
    }
}
