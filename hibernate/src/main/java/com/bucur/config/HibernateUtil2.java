package com.bucur.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class HibernateUtil2 {

    private static final Logger log = Logger.getLogger(HibernateUtil2.class.getName());

    /*
     * Since we will be using annotated classes, it is best to maintain a list
     * of such classes so we add them up easily
     */
    @SuppressWarnings({"unchecked", "rawtypes", "serial"})
    private static final List<Class<?>> classList = new ArrayList();

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        /*
         * Load up the configuration using the hibernate.cfg.xml
         */
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        /*
         * Build the registry using the properties in the configuration
         */
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
            configuration.getProperties()).build();

        /*
         * Now load the classes
         */
        for (Class<?> pojoClass : classList) {
            log.info("Adding annotated class : " + pojoClass.getCanonicalName());
            configuration.addAnnotatedClass(pojoClass);
        }

        /*
         * and finally builds the session factory
         */
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    /**
     * The main utility method to be used to retrieve the transaction.
     *
     * @return {@link Transaction} The transaction of the current session
     */
    public static Transaction getTransaction() throws Exception {
        Session session = getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        tx.setTimeout(10);
        return tx;
        //return getSessionFactory().getCurrentSession().beginTransaction();;
    }
}
