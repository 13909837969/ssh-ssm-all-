package com.company.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.company.dao.mapper.EmpDao;
import com.company.dao.pojo.Emp;
import com.company.service.iservice.IEmpService;

@Service("empService")
public class ServiceEmpImpl implements IEmpService {

	@Autowired
	private EmpDao empDao;

	@Override
	@Transactional
	public String save(Emp t) {
		String msg = "error";
		try {
			empDao.insertSelective(t);
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
			empDao.deleteByPrimaryKey(t.getEmpno());
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
			empDao.updateByPrimaryKeySelective(t);
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
			emp = empDao.selectByPrimaryKey(k);
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
