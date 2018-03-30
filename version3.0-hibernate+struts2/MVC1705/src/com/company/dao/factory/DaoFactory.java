package com.company.dao.factory;

import com.company.dao.idao.IDeptDao;
import com.company.dao.idao.IEmpDao;
import com.company.dao.impl.DaoDeptImpl;
import com.company.dao.impl.DaoEmpImpl;

public class DaoFactory {
	
	public static IEmpDao getDaoEmpInstance(){
		return new DaoEmpImpl();
	}
	
	public static IDeptDao getDaoDeptInstance(){
		return new DaoDeptImpl();
	}
	
}
