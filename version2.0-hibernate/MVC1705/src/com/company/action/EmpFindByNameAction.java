package com.company.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.company.dao.pojo.Emp;
import com.company.service.factory.ServiceFactory;
import com.company.service.iservice.IEmpService;

/**
 * Servlet implementation class EmpFindByNameAction
 */
@WebServlet("/EmpFindByNameAction")
public class EmpFindByNameAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1-取值
		String ename = request.getParameter("ename");

		// 2-处理
		IEmpService empService = ServiceFactory.getServiceEmpInstance();
		List<Emp> empList= empService.findByName(ename);

		// 3-反馈
		if (empList != null && empList.size() > 0) {
			request.setAttribute("empListFromServer", empList);
			request.getRequestDispatcher("/WEB-INF/views/emp_findAll.jsp").forward(request, response);
			
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "无符合条件的数据");
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
