package com.company.dao.test;

import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;

public class DaoEmpImplTest {
	
	private IEmpDao empDao;

	@Before
	public void setUp() throws Exception {
		empDao = DaoFactory.getDaoEmpInstance();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("test junit end!");
	}

	@Test
	public void testSave() throws Exception {
		Emp emp = new Emp("SCOTT",4500,new Date());
		empDao.save(emp);
		System.out.println("save success!");
	}

	@Test
	public void testDelete() throws Exception {
		Emp emp = new Emp();
		emp.setEmpno(6);
		empDao.delete(emp);
		System.out.println("delete success!");
	}

	@Test
	public void testUpdate() throws Exception {
		Emp emp = new Emp("zheng",5000,new Date());
		emp.setEmpno(7);
		empDao.update(emp);
		System.out.println("update success!");
	}

	@Test
	public void testFindAll() throws Exception {
		List<Emp> empList = empDao.findAll();
		for(Emp emp:empList){
			System.out.println(emp);
		}
	}

	@Test
	public void testFindById() throws Exception {
		Emp emp = empDao.findById(8);
		System.out.println(emp);
	}

	@Test
	public void testFindByName() throws Exception {
		List<Emp> empList = empDao.findByName("S");
		for(Emp emp:empList){
			System.out.println(emp);
		}

	}

}