package com.company.dao.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateSessionFactory {

	private static Configuration config;
	private static SessionFactory sessionFactory;

	static {
		try {
			config = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
					.buildServiceRegistry();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	public static void closeSession() {
		Session session = threadLocal.get();
		if (session != null) {
			session.close();
		}
	}

	public static Session getSession() {
		Session session = threadLocal.get();
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = sessionFactory != null ? sessionFactory.openSession() : null;

		}
		return session;
	}

	public static void rebuildSessionFactory() {
		try {
			config = new Configuration().configure();
			ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties())
					.buildServiceRegistry();
			sessionFactory = config.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Configuration getConfig() {
		return config;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
