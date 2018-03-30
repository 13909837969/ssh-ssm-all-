package com.company.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;
import com.company.dao.util.HibernateSessionFactory;

public class DaoEmpImpl implements IEmpDao {


	@Override
	public void save(Emp t) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.save(t);		
		trans.commit();
		HibernateSessionFactory.closeSession();
	}

	@Override
	public void delete(Emp t) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		Emp emp = (Emp) session.get(Emp.class, t.getEmpno());
		session.delete(emp);		
		trans.commit();
		HibernateSessionFactory.closeSession();

	}

	@Override
	public void update(Emp t) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		session.update(t);		
		trans.commit();
		HibernateSessionFactory.closeSession();

	}

	@Override
	public List<Emp> findAll() throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Emp");
		@SuppressWarnings("unchecked")
		List<Emp> empList = query.list();		
		trans.commit();
		HibernateSessionFactory.closeSession();
		return empList;
	}

	@Override
	public Emp findById(Integer k) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Emp e where e.empno=?").setParameter(0,k);
		Emp emp = (Emp) query.uniqueResult();		
		trans.commit();
		HibernateSessionFactory.closeSession();
		return emp;
	}

	@Override
	public List<Emp> findByName(String ename) throws Exception {
		Session session = HibernateSessionFactory.getSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from Emp e where e.ename like ?").setParameter(0, "%"+ename+"%");
		@SuppressWarnings("unchecked")
		List<Emp> empList = query.list();		
		trans.commit();
		HibernateSessionFactory.closeSession();
		return empList;
	}

}
