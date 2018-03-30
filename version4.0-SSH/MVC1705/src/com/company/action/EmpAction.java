package com.company.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.company.commons.Response;
import com.company.dao.pojo.Emp;
import com.company.service.iservice.IEmpService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope(value="prototype")
public class EmpAction implements ModelDriven<Emp>, RequestAware,SessionAware {
	@Autowired
	@Qualifier("empService")
	private IEmpService empService;

	// ModelDriven接口的定义
	private Emp emp = new Emp();

	@Override
	public Emp getModel() {
		return emp;
	}

	// RequestAware接口的定义
	private Map<String, Object> requestMap;

	@Override
	public void setRequest(Map<String, Object> requestFromStruts2) {
		this.requestMap = requestFromStruts2;
	}

	//SessionAware接口的定义
	private Map<String, Object> sessionMap;
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
		
	}
	
	// 1-取值（自动）

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	// 2-处理
	public String save() {
		return empService.save(emp);
	}

	public String update() {
		return empService.update(emp);

	}

	public String delete() {
		return empService.delete(emp);

	}

	public String findAll() {
		String msg = Response.ERROR;
		List<Emp> empList = empService.findAll();
		if (empList != null && empList.size() > 0) {
			requestMap.put("empListFromServer", empList);
			msg = Response.SUCCESS;
		}
		return msg;

	}

	public String findById() {
		String msg = Response.ERROR;
		Emp empObj = empService.findById(emp.getEmpno());
		if (empObj != null) {
			if ("update".equals(type)) {
				requestMap.put("updateEmp", empObj);
				msg = Response.UPDATE;
			} else {
				List<Emp> empList = new ArrayList<Emp>();
				empList.add(empObj);
				requestMap.put("empListFromServer", empList);
				msg = Response.SUCCESS;
			}
		}else{
			sessionMap.put("errMsg", "查无此人！");
		}

		return msg;
	}

	public String findByName() {
		String msg = Response.ERROR;
		List<Emp> empList = empService.findByName(emp.getEname());
		if (empList != null && empList.size() > 0) {
			requestMap.put("empListFromServer", empList);
			msg = Response.SUCCESS;
		}
		return msg;
	}



}
