package com.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.AjaxJson;
import com.base.model.User;
import com.base.service.BUservice;
import com.base.util.StringHelper;
import com.web.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserWebController {

	@Resource
	private IUserService userService;
	@Resource
	private BUservice bUservice;

	/**
	 * 鐢ㄤ簬瀛樺偍鐢ㄦ埛鏁版嵁
	 */
	private static Map<String, User> dataMap = new HashMap<>();

	@RequestMapping(value = "/loginUI", method = RequestMethod.GET)
	public ModelAndView loginUI() {
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/addUserUI", method = RequestMethod.GET)
	public ModelAndView addUserUI() {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/userListUI", method = RequestMethod.GET)
	public ModelAndView userListUI() {
		return new ModelAndView("userlist");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson login(String loginName, String password) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = "登录成功";
		try {
			if (StringHelper.isEmpty(loginName)
					|| StringHelper.isEmpty(password)) {
				isSuccess = false;
				message = "用户名、密码都不能为空";
			} else {
				User user = dataMap.get(loginName);
				if (user == null) {
					isSuccess = false;
					message = "不存在该用户";
				} else {
					if (!user.getLoginName().equals(loginName)
							|| !user.getPassword().equals(password)) {
						isSuccess = false;
						message = "用户名密码错误";
					}
				}
			}
			ajax.setSuccess(isSuccess);
			ajax.setMessage(message);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("服务异常!");
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
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson addUser(User user, String confirmPassword) {
		System.out.println("=====addUser=====");
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = "注册成功!";
		try {
			if (StringHelper.isEmpty(user.getLoginName())
					|| StringHelper.isEmpty(user.getPassword())
					|| StringHelper.isEmpty(user.getUserName())
					|| StringHelper.isEmpty(user.getSex())
					|| user.getAge() == null
					|| StringHelper.isEmpty(confirmPassword)) {
				isSuccess = false;
				message = "存在为空的数据，请确认后提交!";
			} else if (!user.getPassword().equals(confirmPassword) || confirmPassword == null || confirmPassword.equals("")) {
				isSuccess = false;
				message = "两次密码不一致!";
			} else {
				User dataUser = dataMap.get(user.getLoginName());
				if (dataUser != null) {
					isSuccess = false;
					message = "该用户名已经存在，请更换!";
				} else {
					//dataMap.put(user.getLoginName(), user);
					if(bUservice.insert(user) != 1){
						isSuccess = false;
						message = "注册失败!";
					}
				}
			}
			ajax.setSuccess(isSuccess);
			ajax.setMessage(message);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("服务异常");
			return ajax;
		}
		return ajax;
	}

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson userList() {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			/*Set set = dataMap.keySet();
			Iterator it = set.iterator();
			List<User> list = new ArrayList<>();
			while (it.hasNext()) {
				Object obj = it.next();
				System.out.println(obj);
				User user = dataMap.get(obj);
				list.add(user);
			}*/
			List<User> list = bUservice.getAllUser();
			ajax.setSuccess(isSuccess);
			ajax.setList(list);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("服务异常");
			return ajax;
		}
		return ajax;
	}
	
	/**
	 * 根据id获取用户信息
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoByUserId", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson getUserInfoByLoginName(Integer userId) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			if(userId == null){
				isSuccess = false;
				ajax.setMessage("参数不合理!");
			}else{
				//User user = dataMap.get(loginName);
				User user = bUservice.selectByPrimaryKey(userId);
				if(user == null){
					isSuccess = false;
					ajax.setMessage("该用户不存在!");
				}else{
					ajax.setData(user);
				}
			}
			ajax.setSuccess(isSuccess);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("服务异常");
			return ajax;
		}
		return ajax;
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUserByUserId", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson updateUserByLoginName(User user) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			if(user.getUserId() == null){
				isSuccess = false;
				ajax.setMessage("参数不合法");
			}else{
				/*User dataUser = dataMap.get(user.getLoginName());
				if(user == null){
					isSuccess = false;
					ajax.setMessage("璇ョ敤鎴蜂笉瀛樺湪!");
				}else{
					User updateUser = new User();
					updateUser.setLoginName(user.getLoginName());
					updateUser.setPassword(dataUser.getPassword());
					updateUser.setUsername(user.getUsername() == null ? dataUser.getUsername() : user.getUsername());
					updateUser.setSex(user.getSex() == null ? dataUser.getSex() : user.getSex());
					updateUser.setAge(user.getAge() == null ? Integer.parseInt(dataUser.getSex()) : user.getAge());
					dataMap.put(user.getLoginName(), updateUser);
					ajax.setMessage("淇敼鎴愬姛!");
				}*/
				if(bUservice.updateByPrimaryKeySelective(user) != 1){
					isSuccess = false;
					ajax.setMessage("修改失败!");
				}
			}
			ajax.setSuccess(isSuccess);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("服务异常");
			return ajax;
		}
		return ajax;
	}
	
	/**
	 * 删除用户
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "/deleteUserByUserId", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson deleteUserByUserId(Integer userId) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			if(userId == null){
				isSuccess = false;
				ajax.setMessage("参数不合理!");
			}else{
				/*User dataUser = dataMap.get(loginName);
				if(dataUser == null){
					isSuccess = false;
					ajax.setMessage("璇ョ敤鎴蜂笉瀛樺湪,涓嶈兘鍒犻櫎!");
				}else{
					dataMap.remove(loginName);
					ajax.setMessage("鍒犻櫎鎴愬姛!");
				}*/
				if(bUservice.deleteByPrimaryKey(userId) != 1){
					isSuccess = false;
					ajax.setMessage("删除失败!");
				}
			}
			ajax.setSuccess(isSuccess);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("服务异常");
			return ajax;
		}
		return ajax;
	}
	
}
