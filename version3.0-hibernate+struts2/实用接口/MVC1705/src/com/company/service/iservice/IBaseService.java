package com.company.service.iservice;

import java.util.List;

public interface IBaseService<T, K> {
	
	String save(T t);

    String delete(T t);

	String update(T t);

	List<T> findAll();

	T findById(K k);

}
