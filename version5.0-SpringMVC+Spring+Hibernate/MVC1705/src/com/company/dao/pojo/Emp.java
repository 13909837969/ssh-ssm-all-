package com.company.dao.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Emp implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer empno;
	private String ename;
	private Double sal;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hiredate;
	
	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer empno, String ename, Double sal, Date hiredate) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sal = sal;
		this.hiredate = hiredate;
	}

	public Emp(String ename, Double sal, Date hiredate) {
		super();
		this.ename = ename;
		this.sal = sal;
		this.hiredate = hiredate;
	}

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", hiredate=" + hiredate + "]";
	}
	
	
}
