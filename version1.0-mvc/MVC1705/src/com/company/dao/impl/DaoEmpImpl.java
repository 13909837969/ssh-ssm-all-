package com.company.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;
import com.company.dao.util.SessionFactory;

public class DaoEmpImpl implements IEmpDao {

	private SessionFactory sessionFactory;

	public DaoEmpImpl() {
		sessionFactory = SessionFactory.getSessionFactoryInstance();
	}

	@Override
	public void save(Emp t) throws Exception {
		Connection con = sessionFactory.getSession();
		String sql = "insert into t_emp(empno,ename,sal,hiredate) values(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getEmpno());
		ps.setString(2, t.getEname());
		ps.setDouble(3, t.getSal());
		ps.setDate(4, new java.sql.Date(t.getHiredate().getTime()));
		ps.executeUpdate();
		sessionFactory.close(con, ps, null);
	}

	@Override
	public void delete(Emp t) throws Exception {
		Connection con = sessionFactory.getSession();
		String sql = "delete from t_emp where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, t.getEmpno());
		ps.executeUpdate();
		sessionFactory.close(con, ps, null);

	}

	@Override
	public void update(Emp t) throws Exception {
		Connection con = sessionFactory.getSession();
		String sql = "update t_emp set ename=?,sal=?,hiredate=? where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, t.getEname());
		ps.setDouble(2, t.getSal());
		ps.setDate(3, new java.sql.Date(t.getHiredate().getTime()));
		ps.setInt(4, t.getEmpno());
		ps.executeUpdate();
		sessionFactory.close(con, ps, null);

	}

	@Override
	public List<Emp> findAll() throws Exception {
		Connection con = sessionFactory.getSession();
		String sql = "select empno,ename,sal,hiredate from t_emp";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Emp> empList = new ArrayList<Emp>();
		Emp emp = null;
		while (rs.next()) {
			emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setSal(rs.getDouble(3));
			emp.setHiredate(rs.getDate(4));
			empList.add(emp);
		}
		sessionFactory.close(con, ps, rs);
		return empList;
	}

	@Override
	public Emp findById(Integer k) throws Exception {
		Connection con = sessionFactory.getSession();
		String sql = "select empno,ename,sal,hiredate from t_emp where empno=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, k);
		ResultSet rs = ps.executeQuery();
		Emp emp = null;
		if (rs.next()) {
			emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setSal(rs.getDouble(3));
			emp.setHiredate(rs.getDate(4));
		}
		sessionFactory.close(con, ps, rs);
		return emp;
	}

	@Override
	public List<Emp> findByName(String ename) throws Exception {
		Connection con = sessionFactory.getSession();
		String sql = "select empno,ename,sal,hiredate from t_emp where ename like ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, "%" + ename + "%");
		ResultSet rs = ps.executeQuery();
		List<Emp> empList = new ArrayList<Emp>();
		Emp emp = null;
		while (rs.next()) {
			emp = new Emp();
			emp.setEmpno(rs.getInt(1));
			emp.setEname(rs.getString(2));
			emp.setSal(rs.getDouble(3));
			emp.setHiredate(rs.getDate(4));
			empList.add(emp);
		}
		sessionFactory.close(con, ps, rs);
		return empList;
	}

}
