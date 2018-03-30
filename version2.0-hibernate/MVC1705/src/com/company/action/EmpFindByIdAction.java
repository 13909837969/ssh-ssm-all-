package com.company.action;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class EmpFindByIdAction
 */
@WebServlet("/EmpFindByIdAction")
public class EmpFindByIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1-取值
		int empno = Integer.parseInt(request.getParameter("empno"));
		String type = request.getParameter("type");

		// 2-处理
		IEmpService empService = ServiceFactory.getServiceEmpInstance();
		Emp emp = empService.findById(empno);

		// 3-反馈
		if (emp != null) {

			if ("update".equals(type)) {
				request.setAttribute("updateEmp", emp);
				request.getRequestDispatcher("/WEB-INF/views/emp_update.jsp").forward(request, response);
			} else {
				List<Emp> empList = new ArrayList<Emp>();
				empList.add(emp);
				request.setAttribute("empListFromServer", empList);
				request.getRequestDispatcher("/WEB-INF/views/emp_findAll.jsp").forward(request, response);
			}
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("errMsg", "无此empno的数据");
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
