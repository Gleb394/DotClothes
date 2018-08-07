package com.DotClothes.connection;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Connection {

    private static SessionFactory sessionFactory;

    private static SessionFactory configurationSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static Session getSession() {
        return configurationSessionFactory().openSession();
    }
}
