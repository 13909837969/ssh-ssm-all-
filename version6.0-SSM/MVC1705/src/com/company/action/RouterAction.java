package com.company.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("router")
public class RouterAction {

	@RequestMapping(value = "emp_save.do", method = RequestMethod.GET)
	public String empSaveInitPage() {
		return "emp_save";
	}

}
