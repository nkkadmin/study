package com.ssh.lose.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssh.lose.comman.Constant;
import com.ssh.lose.po.User;
import com.ssh.lose.service.UserService;
import com.ssh.lose.util.StringHelper;

@Controller
public class UserAction extends BaseAction {

	@Autowired
	private UserService userService;

	private String name;
	private String password;

	public String login() {
		System.out.println("login......");
		password = StringHelper.MD5(password);
		User user = userService.login(name, password);
		if (user != null) {
			getSession().setAttribute(Constant.USER_SESSION_INFO, user);
		}else{
			getRequest().setAttribute("loginMsg", "’ÀªßªÚ’ﬂ√‹¬Î¥ÌŒÛ");
		}
		return "home";
	}
}
