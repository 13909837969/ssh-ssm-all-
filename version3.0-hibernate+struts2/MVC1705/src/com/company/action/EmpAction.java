package com.company.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.company.commons.Response;
import com.company.dao.pojo.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;

public class EmpAction {
	private IEmpService empService;
	public EmpAction() {
		empService = ServiceFactory.getServiceEmpInstance();
	}
	
	//1-取值（自动）
	private int empno;
	private String ename;
	private double sal;
	private Date hiredate;
	private String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	
	
	//2-处理
	public String save(){
		Emp emp = new Emp(ename,sal,hiredate);
		return empService.save(emp);
	}
	public String update(){
		Emp emp = new Emp(ename,sal,hiredate);
		emp.setEmpno(empno);
		return empService.update(emp);
		
	}
	public String delete(){
		Emp emp = new Emp();
		emp.setEmpno(empno);
		return empService.delete(emp);
		
	}
	public String findAll(){
		String msg = Response.ERROR;
		List<Emp> empList = empService.findAll();
		if(empList != null && empList.size() > 0){
			ServletActionContext.getRequest().setAttribute("empListFromServer", empList);
			msg = Response.SUCCESS;
		}
		return msg;
		
	}
	public String findById(){
		String msg = Response.ERROR;
		Emp emp = empService.findById(empno);
		if(emp != null){
			if("update".equals(type)){
				ServletActionContext.getRequest().setAttribute("updateEmp", emp);
				msg = Response.UPDATE;
			}else{
				List<Emp> empList = new ArrayList<Emp>();
				empList.add(emp);
				ServletActionContext.getRequest().setAttribute("empListFromServer", empList);
				msg = Response.SUCCESS;
			}
		}
		
		return msg;		
	}
	public String findByName(){
		String msg = Response.ERROR;
		List<Emp> empList = empService.findByName(ename);
		if(empList != null && empList.size() > 0){
			ServletActionContext.getRequest().setAttribute("empListFromServer", empList);
			msg = Response.SUCCESS;
		}
		return msg;
	}
	
	
	
	//3-反馈 -- struts.xml中，代码不涉及
}
