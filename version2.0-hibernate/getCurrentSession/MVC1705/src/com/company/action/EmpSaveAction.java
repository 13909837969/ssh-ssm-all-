package com.company.action;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.commons.Response;
import com.company.dao.pojo.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;

@WebServlet("/EmpSaveAction")
public class EmpSaveAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1-取值
		String ename = request.getParameter("ename");
		double sal = Double.parseDouble(request.getParameter("sal"));
		Date hiredate = null;
		try {
			hiredate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("hiredate"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 2-处理
		Emp emp = new Emp(ename, sal, hiredate);
		IEmpService empService = ServiceFactory.getServiceEmpInstance();
		String msg = empService.save(emp);

		// 3-反馈
		if (Response.SUCCESS.equals(msg)) {
			response.sendRedirect(request.getContextPath() + "/EmpFindAllAction");
		} else if (Response.ERROR.equals(msg)) {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "保存失败");
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
