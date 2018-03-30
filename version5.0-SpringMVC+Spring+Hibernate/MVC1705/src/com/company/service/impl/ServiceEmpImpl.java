package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.idao.IEmpDao;
import com.company.dao.pojo.Emp;
import com.company.service.iservice.IEmpService;

@Service("empService")
public class ServiceEmpImpl implements IEmpService {

	@Autowired
	@Qualifier("empDao")
	private IEmpDao empDao;

	@Override
	@Transactional
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

	// 事实上，项目中的每一条数据都非常宝贵，可以修改状态，不要轻易删除
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
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
	@Transactional
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
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
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
