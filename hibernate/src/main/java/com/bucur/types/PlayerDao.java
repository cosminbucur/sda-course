package com.bucur.types;

import com.bucur.config.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.logging.Logger;

public class PlayerDao {

    private static final Logger logger = Logger.getLogger(PlayerDao.class.getName());

    private Session session;
    private Transaction tx;

    public void create(Player player) {
        try {
            startOperation();
            session.save(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not save entity " + player);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Player findById(Long id) {
        Player player = null;
        try {
            startOperation();
            player = session.find(Player.class, id);
            return player;
        } catch (HibernateException e) {
            logger.severe("could not find entity by id " + id);
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return player;
    }

    public List findAll() {
        List players = null;
        try {
            startOperation();
            Query query = session.createQuery("FROM Player");
            players = query.list();
            tx.commit();
        } catch (HibernateException e) {
            logger.severe("could not find all");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return players;
    }

    public void update(Player player) {
        try {
            startOperation();
            session.update(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not update entity " + player);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Player player) {
        try {
            startOperation();
            session.delete(player);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            logger.severe("could not delete entity " + player);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }

}
