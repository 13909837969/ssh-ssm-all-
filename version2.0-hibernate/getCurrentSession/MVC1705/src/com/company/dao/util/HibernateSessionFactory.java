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

	public static Session getSession() {
		if (sessionFactory == null) {
			rebuildSessionFactory();
		}
		return sessionFactory != null ? sessionFactory.getCurrentSession() : null;
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
