package com.sda.hibernate.config;

import com.sda.hibernate.associations.many_to_many.Tag;
import com.sda.hibernate.associations.many_to_many.Post;
import com.sda.hibernate.associations.one_to_many_bi.Child;
import com.sda.hibernate.associations.one_to_many_bi.Parent;
import com.sda.hibernate.associations.one_to_many_uni.Daughter;
import com.sda.hibernate.associations.one_to_many_uni.Mother;
import com.sda.hibernate.associations.one_to_many_uni_join.Father;
import com.sda.hibernate.associations.one_to_many_uni_join.Son;
import com.sda.hibernate.associations.one_to_one.Car;
import com.sda.hibernate.associations.one_to_one.Parking;
import com.sda.hibernate.associations.one_to_one_join.Account;
import com.sda.hibernate.associations.one_to_one_join.Employee;
import com.sda.hibernate.crud.Person;
import com.sda.hibernate.listeners.customer.Customer;
import com.sda.hibernate.listeners.history.CustomerHistory;
import com.sda.hibernate.nplus_one.Department;
import com.sda.hibernate.nplus_one.Doctor;
import com.sda.hibernate.queries.hql.Stock;
import com.sda.hibernate.queries.hql_join.Author;
import com.sda.hibernate.queries.hql_join.Book;
import com.sda.hibernate.queries.native_query.Trader;
import com.sda.hibernate.types.Player;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory buildSessionFactory() {
        // load up the configuration using the hibernate.cfg.xml
        Configuration configuration = createConfig();

        // build the registry using the properties in the configuration
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
            .applySettings(configuration.getProperties()).build();

        // build the session factory from the service registry
        return configuration.buildSessionFactory(serviceRegistry);
    }

    private static Configuration createConfig() {
        Configuration configuration = new Configuration();

        // hibernate settings equivalent to hibernate.cfg.xml's properties
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate_tutorial?serverTimezone=UTC");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "Rootpass3#");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        settings.put(Environment.HBM2DDL_AUTO, "create-drop");
        configuration.setProperties(settings);

        // add annotated classes

        // crud
        configuration.addAnnotatedClass(Person.class);

        // hibernate types
        configuration.addAnnotatedClass(Player.class);

        // one to one
        configuration.addAnnotatedClass(Parking.class);
        configuration.addAnnotatedClass(Car.class);

        // one to one join
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Employee.class);

        // one to many unidirectional
        configuration.addAnnotatedClass(Daughter.class);
        configuration.addAnnotatedClass(Mother.class);

        // one to many unidirectional join
        configuration.addAnnotatedClass(Father.class);
        configuration.addAnnotatedClass(Son.class);

        // one to many bidirectional
        configuration.addAnnotatedClass(Parent.class);
        configuration.addAnnotatedClass(Child.class);

        // many to many
        configuration.addAnnotatedClass(Post.class);
        configuration.addAnnotatedClass(Tag.class);

        // hql
        configuration.addAnnotatedClass(Stock.class);
        configuration.addAnnotatedClass(Trader.class);

        configuration.addAnnotatedClass(Author.class);
        configuration.addAnnotatedClass(Book.class);

        // listeners
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(CustomerHistory.class);

        // N+1 problem
        configuration.addAnnotatedClass(Doctor.class);
        configuration.addAnnotatedClass(Department.class);

        return configuration;
    }
}
