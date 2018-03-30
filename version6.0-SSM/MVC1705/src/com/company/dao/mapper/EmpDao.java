package com.company.dao.mapper;

import java.util.List;

import com.company.dao.pojo.Emp;

public interface EmpDao {
	int deleteByPrimaryKey(Integer empno);

	int insert(Emp record);

	int insertSelective(Emp record);

	Emp selectByPrimaryKey(Integer empno);

	int updateByPrimaryKeySelective(Emp record);

	int updateByPrimaryKey(Emp record);

	List<Emp> findAll();

	List<Emp> findByName(String ename);
}