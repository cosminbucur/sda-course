package com.sda.hibernate.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

    private static final EntityManagerFactory emf;

    // Static block for creating EntityManagerFactory.
    // The Persistence class looks for META-INF/persistence.xml in the classpath
    static {
        emf = Persistence.createEntityManagerFactory("com.sda.hibernate.jpa_tutorial");
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}
