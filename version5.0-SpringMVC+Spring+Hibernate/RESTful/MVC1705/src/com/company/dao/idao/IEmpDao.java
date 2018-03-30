package com.company.dao.idao;

import java.util.List;

import com.company.dao.pojo.Emp;

public interface IEmpDao extends IBaseDao<Emp, Integer> {

	public List<Emp> findByName(String ename) throws Exception;
}
