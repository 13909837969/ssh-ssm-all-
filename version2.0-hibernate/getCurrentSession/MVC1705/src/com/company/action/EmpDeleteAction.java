package com.company.action;

import java.io.IOException;

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

/**
 * Servlet implementation class EmpDeleteAction
 */
@WebServlet("/EmpDeleteAction")
public class EmpDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1-取值
		int empno = Integer.parseInt(request.getParameter("empno"));
		// 2-处理
		Emp emp = new Emp();
		emp.setEmpno(empno);
		IEmpService empService = ServiceFactory.getServiceEmpInstance();
		String msg = empService.delete(emp);

		// 3-反馈
		if (Response.SUCCESS.equals(msg)) {
			response.sendRedirect(request.getContextPath() + "/EmpFindAllAction");
		} else if (Response.ERROR.equals(msg)) {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "删除失败");
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
