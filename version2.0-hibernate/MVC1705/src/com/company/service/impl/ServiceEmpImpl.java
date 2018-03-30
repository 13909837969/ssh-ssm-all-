package com.company.service.impl;

import java.util.List;

import com.company.dao.factory.DaoFactory;
import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;
import com.company.service.iservice.IEmpService;

public class ServiceEmpImpl implements IEmpService {
	
	private IEmpDao empDao;
	
	public ServiceEmpImpl() {
		empDao = DaoFactory.getDaoEmpInstance();
	}

	@Override
	public String save(Emp t) {
		String msg = "error";
		try {
			empDao.save(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	//事实上，项目中的每一条数据都非常宝贵，可以修改状态，不要轻易删除
	@Override
	public String delete(Emp t) {
		String msg = "error";
		try {
			empDao.delete(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String update(Emp t) {
		String msg = "error";
		try {
			empDao.update(t);
			msg = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Emp> findAll() {
		
		List<Emp> empList = null;
		try {
			empList = empDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return empList;
	}

	@Override
	public Emp findById(Integer k) {
		Emp emp = null;
		try {
			emp = empDao.findById(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Emp> findByName(String ename) {
		List<Emp> empList = null;
		try {
			empList = empDao.findByName(ename);
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return empList;
	}

}
