package com.company.dao.pojo;

import java.io.Serializable;
import java.util.Date;

public class Emp implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int empno;
	private String ename;
	private double sal;
	private Date hiredate;

	public Emp() {
		// TODO Auto-generated constructor stub
	}

	public Emp(String ename, double sal, Date hiredate) {
		super();
		this.ename = ename;
		this.sal = sal;
		this.hiredate = hiredate;
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

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sal=" + sal + ", hiredate=" + hiredate + "]";
	}

}
