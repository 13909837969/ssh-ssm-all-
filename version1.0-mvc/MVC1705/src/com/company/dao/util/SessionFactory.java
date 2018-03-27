package com.company.dao.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class SessionFactory {

	private static SessionFactory sessionFactory;
	private ComboPooledDataSource dataSource;

	public ComboPooledDataSource getDataSource() {
		return dataSource;
	}

	private SessionFactory() {
		dataSource = new ComboPooledDataSource();
	}

	public static SessionFactory getSessionFactoryInstance() {
		if (sessionFactory == null) {
			sessionFactory = new SessionFactory();
		}
		return sessionFactory;
	}


	public Connection getSession() throws Exception {
		Connection conn = null;
		conn = dataSource.getConnection();
		return conn;
	}

	public void close(Connection conn, Statement ps, ResultSet rs) throws Exception {
		if (rs != null) {
			rs.close();
		}
		if (ps != null) {
			ps.close();
		}
		if (conn != null) {
			conn.close();
		}

	}

}
