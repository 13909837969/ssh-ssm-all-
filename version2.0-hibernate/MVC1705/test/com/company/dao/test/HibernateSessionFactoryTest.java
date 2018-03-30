package com.company.dao.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.util.HibernateSessionFactory;

public class HibernateSessionFactoryTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetSession() {
		System.out.println(HibernateSessionFactory.getSessionFactory().hashCode());
		System.out.println(HibernateSessionFactory.getSessionFactory().hashCode());
		System.out.println(HibernateSessionFactory.getSessionFactory());
		System.out.println(HibernateSessionFactory.getSession().hashCode());
		System.out.println(HibernateSessionFactory.getSession().hashCode());
		System.out.println(HibernateSessionFactory.getSession().hashCode());
	}

}
