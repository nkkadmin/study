package com.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.AjaxJson;
import com.app.model.User;
import com.base.util.StringHelper;

@Controller
@RequestMapping("/user")
public class UserWebController {
	
	/**
	 * 用于存储用户数据
	 */
	private static Map<String, User> dataMap = new HashMap<>();

	
	@RequestMapping(value = "/loginUI", method = RequestMethod.GET)
	public ModelAndView loginUI(){
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/addUserUI", method = RequestMethod.GET)
	public ModelAndView addUserUI(){
		return new ModelAndView("register");
	}
	
	@RequestMapping(value = "/userListUI", method = RequestMethod.GET)
	public ModelAndView userListUI(){
		return new ModelAndView("userlist");
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson login(String loginName, String password) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = "登录成功!";
		try {
			if (StringHelper.isEmpty(loginName)
					|| StringHelper.isEmpty(password)) {
				isSuccess = false;
				message = "用户名或密码不能为空!";
			} else {
				User user = dataMap.get(loginName);
				if (user == null) {
					isSuccess = false;
					message = "该用户不存在!";
				} else {
					if (!user.getLoginName().equals(loginName)
							|| !user.getPassword().equals(password)) {
						isSuccess = false;
						message = "用户名密码错误!";
					}
				}
			}
			ajax.setSuccess(isSuccess);
			ajax.setMessage(message);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("登录服务异常!");
			return ajax;
		}
		return ajax;
	}

	/**
	 * 注册用户
	 * 
	 * @param user
	 * @param confirmPassword
	 *            确认密码
	 * @return
	 */
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson addUser(User user,String confirmPassword){
		System.out.println("=====addUser=====");
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = "注册成功!";
		try {
			if(StringHelper.isEmpty(user.getLoginName()) || StringHelper.isEmpty(user.getPassword()) 
					|| StringHelper.isEmpty(user.getUsername()) || StringHelper.isEmpty(user.getSex())
					|| user.getAge() == null || StringHelper.isEmpty(confirmPassword) ){
				isSuccess = false;
				message = "存在为空的数据，请确认后再提交!";
			}else if(!user.getPassword().equals(confirmPassword)){
				isSuccess = false;
				message = "两次密码不正确，请重新输入!";
			}else{
				User dataUser = dataMap.get(user.getLoginName());
				if(dataUser != null){
					isSuccess = false;
					message = "该用户名已经存在，请换个用户名!";
				}else{
					dataMap.put(user.getLoginName(), user);
				}
			}
			ajax.setSuccess(isSuccess);
			ajax.setMessage(message);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("注册服务异常");
			return ajax;
		}
		return ajax;
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping(value="/userList",method=RequestMethod.POST)
	@ResponseBody
	public AjaxJson userList(){
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			Set set = dataMap.keySet();
			Iterator it = set.iterator();
			List<User> list = new ArrayList<>();
			while(it.hasNext()){
				Object obj = it.next();
				 System.out.println(obj);
				User user = dataMap.get(obj);
				list.add(user);
			}
			ajax.setSuccess(isSuccess);
			ajax.setList(list);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("注册服务异常");
			return ajax;
		}
		return ajax;
	}
}
