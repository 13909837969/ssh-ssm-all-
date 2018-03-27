package com.company.dao.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.util.SessionFactory;

public class SessionFactoryTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("begin junit");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("end junit");
	}

	@Test
	public void testGetSession() throws Exception {
			SessionFactory sf1 = SessionFactory.getSessionFactoryInstance();
			SessionFactory sf2 = SessionFactory.getSessionFactoryInstance();
			System.out.println(sf1.getSession());
			System.out.println(sf1.getSession());
			System.out.println(sf2.getSession());
			System.out.println(sf2.getSession());
	}

}
