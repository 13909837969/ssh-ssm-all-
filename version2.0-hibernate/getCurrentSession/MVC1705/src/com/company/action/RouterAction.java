package com.company.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RouterAction
 */
@WebServlet("/RouterAction")
public class RouterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		String type = request.getParameter("type");
		//2--业务逻辑要求：判断用户是否已经成功登陆，或者判断用户是否具有访问权限
		//3
		if("emp_save".equals(type)){
			request.getRequestDispatcher("/WEB-INF/views/emp_save.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
