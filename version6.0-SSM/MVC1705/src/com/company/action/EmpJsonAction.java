package com.company.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.commons.Response;
import com.company.commons.ResponseEntity;
import com.company.dao.pojo.Emp;
import com.company.service.iservice.IEmpService;

@Controller
@RequestMapping("empjson")
public class EmpJsonAction {
	@Autowired
	@Qualifier("empService")
	private IEmpService empService;

	@RequestMapping(value = "save.do", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Emp> save(@RequestBody Emp emp) {
		String msg = empService.save(emp);

		return Response.SUCCESS.equals(msg) ? new ResponseEntity<Emp>(200, "save success")
				: new ResponseEntity<Emp>(500, "save error!");

	}

	@RequestMapping(value = "delete.do", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Emp> delete(@RequestParam int empno) {
		Emp emp = new Emp();
		emp.setEmpno(empno);
		String msg = empService.delete(emp);

		return Response.SUCCESS.equals(msg) ? new ResponseEntity<Emp>(200, "delete success")
				: new ResponseEntity<Emp>(500, "delete error!");

	}

	@RequestMapping(value = "update.do", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Emp> update(@RequestBody Emp emp) {
		System.out.println(emp);
		String msg = empService.update(emp);

		return Response.SUCCESS.equals(msg) ? new ResponseEntity<Emp>(200, "update success")
				: new ResponseEntity<Emp>(500, "update error!");

	}

	@RequestMapping(value = "findall.do", method = RequestMethod.GET)

	public @ResponseBody ResponseEntity<List<Emp>> findAll() {
		List<Emp> empList = empService.findAll();

		return (empList != null && empList.size() > 0) ? new ResponseEntity<List<Emp>>(200, "success", empList)
				: new ResponseEntity<List<Emp>>(404, "findall error!", null);

	}

	@RequestMapping(value = "findbyname.do", method = RequestMethod.POST)

	public @ResponseBody ResponseEntity<List<Emp>> findByName(@RequestParam String ename) {
		List<Emp> empList = empService.findByName(ename);

		return (empList != null && empList.size() > 0)
				? new ResponseEntity<List<Emp>>(200, "findbyname success", empList)
				: new ResponseEntity<List<Emp>>(404, "findbyname error!", null);

	}

	// 如果是get请求风格执行findById，则执行update init初始化功能 回显要更新的数据
	@RequestMapping(value = "findbyid.do", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<Emp> updateInit(@RequestParam int empno) {
		Emp emp = empService.findById(empno);
		return emp != null ? new ResponseEntity<Emp>(200, "updateinit success", emp)
				: new ResponseEntity<Emp>(404, "updateinit error!", null);
	}

	// 如果是post请求风格执行findById，则执行精确查询功能
	@RequestMapping(value = "findbyid.do", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<Emp> findById(@RequestParam int empno) {
		Emp emp = empService.findById(empno);
		return emp != null ? new ResponseEntity<Emp>(200, "findbyid success", emp)
				: new ResponseEntity<Emp>(404, "findbyid error!", null);

	}

	@RequestMapping(value="show_emp.do",method=RequestMethod.POST)
	public @ResponseBody Emp showEmp(@RequestBody Emp emp){
		emp.setEmpno(emp.getEmpno()*100);
		emp.setEname(new StringBuffer(emp.getEname()).reverse().toString());
		return emp;
	}
	
}
