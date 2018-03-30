package com.company.service.factory;

import com.company.service.impl.ServiceEmpImpl;
import com.company.service.iservice.IEmpService;

public class ServiceFactory {
	public static IEmpService getServiceEmpInstance() {
		return new ServiceEmpImpl();
	}
}
