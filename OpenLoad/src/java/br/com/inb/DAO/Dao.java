/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inb.DAO;

import java.util.logging.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author manoel
 */
public class Dao {

    private static final Logger log = Logger.getAnonymousLogger();
    private static final ThreadLocal session = new ThreadLocal();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public static Session getSession() {
        Session session = (Session) Dao.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            Dao.session.set(session);
        }
        return session;
    }

    public static void begin() {
        getSession().beginTransaction();
    }

    public static void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        Dao.session.set(null);
    }

    public static void close() {
        getSession().close();
        Dao.session.set(null);
    }
}
