package com.company.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;

@Repository("empDao")
public class DaoEmpImpl implements IEmpDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Emp t) throws Exception {
		sessionFactory.getCurrentSession().save(t);
	}

	@Override
	public void delete(Emp t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Emp emp = (Emp) session.get(Emp.class, t.getEmpno());
		session.delete(emp);

	}

	@Override
	public void update(Emp t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(t);

	}

	@Override
	public List<Emp> findAll() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Emp");
		@SuppressWarnings("unchecked")
		List<Emp> empList = query.list();
		return empList;
	}

	@Override
	public Emp findById(Integer k) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Emp e where e.empno=?").setParameter(0, k);
		Emp emp = (Emp) query.uniqueResult();
		return emp;
	}

	@Override
	public List<Emp> findByName(String ename) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Emp e where e.ename like ?").setParameter(0, "%" + ename + "%");
		@SuppressWarnings("unchecked")
		List<Emp> empList = query.list();
		return empList;
	}

}
