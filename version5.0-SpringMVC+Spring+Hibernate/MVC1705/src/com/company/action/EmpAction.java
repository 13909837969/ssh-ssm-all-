package com.company.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.commons.Response;
import com.company.dao.pojo.Emp;
import com.company.service.iservice.IEmpService;

@Controller
@RequestMapping("emp")
public class EmpAction {
	@Autowired
	@Qualifier("empService")
	private IEmpService empService;

	@RequestMapping(value = "save.do", method = RequestMethod.POST)
	public String save(Emp emp) {
		System.out.println("save init");
		String msg = empService.save(emp);
		return Response.SUCCESS.equals(msg) ? "redirect:/emp/findall.do" : "redirect:/error.jsp";

	}

	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public String delete(Emp emp) {
		String msg = empService.delete(emp);
		return Response.SUCCESS.equals(msg) ? "redirect:/emp/findall.do" : "redirect:/error.jsp";

	}

	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public String update(Emp emp) {
		String msg = empService.update(emp);
		return Response.SUCCESS.equals(msg) ? "redirect:/emp/findall.do" : "redirect:/error.jsp";

	}

	@RequestMapping(value = "findall.do", method = RequestMethod.GET)
	public String findAll(Map<String, Object> map) {
		List<Emp> empList = empService.findAll();
		if (empList != null && empList.size() > 0) {
			map.put("empListFromServer", empList);
		}
		return map.size() > 0 ? "emp_findAll" : "redirect:/error.jsp";

	}

	@RequestMapping(value = "findbyname.do", method = RequestMethod.POST)
	public String findByName(@RequestParam String ename, Map<String, Object> map) {
		List<Emp> empList = empService.findByName(ename);
		if (empList != null && empList.size() > 0) {
			map.put("empListFromServer", empList);
		}
		return map.size() > 0 ? "emp_findAll" : "redirect:/error.jsp";

	}

	// 如果是get请求风格执行findById，则执行update init初始化功能 回显要更新的数据
	@RequestMapping(value = "findbyid.do", method = RequestMethod.GET)
	public String updateInit(@RequestParam int empno, Map<String, Object> map) {
		Emp emp = empService.findById(empno);
		map.put("updateEmp", emp);
		return "emp_update";
	}

	// 如果是post请求风格执行findById，则执行精确查询功能
	@RequestMapping(value = "findbyid.do", method = RequestMethod.POST)
	public String findById(int empno, Map<String, Object> map, HttpSession session) {
		Emp emp = empService.findById(empno);
		if (emp == null) {
			session.setAttribute("errMsg", "查无此人");
			return "redirect:/error.jsp";
		} else {
			List<Emp> emps = new ArrayList<Emp>();
			emps.add(emp);
			map.put("empListFromServer", emps);
			return "emp_findAll";
		}

	}

}
