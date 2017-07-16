package com.ssh.lose.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.ssh.lose.comman.Constant;
import com.ssh.lose.po.User;
import com.ssh.lose.service.ShopService;
import com.ssh.lose.service.UserService;

public class BaseAction extends ActionSupport {
	
	@Autowired
	public ShopService shopService;
	@Autowired
	public UserService userService;

	
	public ActionContext getActionContext(){
		return ServletActionContext.getActionContext(getRequest());
	}
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	
	public HttpSession getSession(){
		return getRequest().getSession();
	}
	
	public User getCurrentUser(){
		return (User) getSession().getAttribute(Constant.USER_SESSION_INFO);
	}
	
	public int getCurrentUserId(){
		return getCurrentUser().getId();
	}
}
