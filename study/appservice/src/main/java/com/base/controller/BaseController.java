package com.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.base.model.AjaxJson;
import com.base.model.User;

public class BaseController {
	
	private HttpServletRequest request;
	private HttpServletResponse response;

	public AjaxJson responseInfo(boolean success){
		return responseInfo(null, success, null, null);
	}
	
	
	public AjaxJson responseInfo(String message,boolean success){
		return responseInfo(message, success, null, null);
	}
	
	public AjaxJson responseInfo(String message,boolean success,Object data){
		return responseInfo(message, success, data, null);
	}
	
	/**
	 * 输出数据
	 * @param message
	 * @param success
	 * @param data
	 * @param list
	 * @return
	 */
	public AjaxJson responseInfo(String message,boolean success,Object data,List list){
		AjaxJson ajax = new AjaxJson(message, success, list, data);
		return ajax;
	}
	
	/**
	 * 获取session
	 * @return
	 */
	public HttpSession getSession(){
		return request.getSession();
	}
	
	/**
	 * 当前登陆的用户
	 * @return
	 */
	public User getCurrentUser(){
		User user = new User();
		user.setId(4);
		return user;
	}
}
