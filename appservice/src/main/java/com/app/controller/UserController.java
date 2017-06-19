package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.AjaxJson;
import com.app.model.User;


@Controller
@RequestMapping("/userHttp")
public class UserController {

	
	@ResponseBody
	@RequestMapping("/login")
	public AjaxJson login(User user){
		System.out.println("=============login===============");
		AjaxJson ajaxJson = new AjaxJson();
		if(user != null && user.getUsername() != null && user.getPassword() != null){
			if(user.getUsername().equals("xsx") && user.getPassword().equals("123456")){
				ajaxJson.setSuccess(true);
				ajaxJson.setMessage("登录成功");
			}else{
				ajaxJson.setSuccess(false);
				ajaxJson.setMessage("用户名或者密码错误");
			}
		}else{
			ajaxJson.setSuccess(false);
			ajaxJson.setMessage("用户名或者密码不能为空");
		}
		System.out.println(ajaxJson.getMessage());
		return ajaxJson;
	}
	
	@RequestMapping("/test")
	public void test(){
		System.out.println("asdasdasd");
	}
}
