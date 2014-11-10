/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inb.dao;

import java.util.logging.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author manoel
 */
 public class Dao {

    private static final Logger log = Logger.getAnonymousLogger();
    @SuppressWarnings("rawtypes")
	private static final ThreadLocal session = new ThreadLocal();
    @SuppressWarnings("deprecation")
	private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    @SuppressWarnings("unchecked")
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

    @SuppressWarnings("unchecked")
	protected static void rollback() {
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

    @SuppressWarnings("unchecked")
	public static void close() {
        getSession().close();
        Dao.session.set(null);
    }
}
