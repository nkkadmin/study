package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	/**
	 * 登录UI
	 * @return
	 */
	@RequestMapping(value = "/loginUI", method = RequestMethod.GET)
	public ModelAndView loginUI() {
		return new ModelAndView("manager/login");
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView toManager(){
		return new ModelAndView("manager/index");
	}
}
