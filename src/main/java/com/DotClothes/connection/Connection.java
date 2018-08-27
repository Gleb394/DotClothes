package com.DotClothes.connection;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Connection {

    private static SessionFactory sessionFactory;

    private static SessionFactory configurationSessionFactory() {
        if(sessionFactory == null) {
            return new Configuration().configure().buildSessionFactory();
        }
        return null;
    }

    public static Session getSession() {
        return configurationSessionFactory().openSession();
    }
}
