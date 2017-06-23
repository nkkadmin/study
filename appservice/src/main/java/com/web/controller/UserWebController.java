package com.web.controller;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.AjaxJson;
import com.base.model.User;
import com.base.service.BUservice;
import com.base.util.DateHelper;
import com.base.util.StringHelper;
import com.web.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserWebController {

	@Resource
	private IUserService userService;
	@Resource
	private BUservice bUservice;

	private static final String TABLENAME = "user";

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
				User user = userService.getUserByLoginName(loginName);
				if (user == null) {
					isSuccess = false;
					message = "不存在该用户";
				} else {
					if (!user.getLoginname().equals(loginName)
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
			e.printStackTrace();
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
			if (StringHelper.isEmpty(user.getLoginname())
					|| StringHelper.isEmpty(user.getPassword())
					|| StringHelper.isEmpty(user.getUsername())
					|| StringHelper.isEmpty(user.getSex())
					|| user.getAge() == null
					|| StringHelper.isEmpty(confirmPassword)) {
				isSuccess = false;
				message = "存在为空的数据，请确认后提交!";
			} else if (!user.getPassword().equals(confirmPassword)
					|| confirmPassword == null || confirmPassword.equals("")) {
				isSuccess = false;
				message = "两次密码不一致!";
			} else {
				User userByLogin = bUservice.quertByLoginName(user
						.getLoginname());
				if (userByLogin != null) {
					isSuccess = false;
					message = "该用户名已经存在，请更换!";
				} else {
					Map<String, Object> map = new HashMap<String, Object>();
					user.setStatu("1");
					user.setCreatetime(DateHelper.nowDate());
					Field[] fields = user.getClass().getDeclaredFields();
					for (Field field : fields) {
						field.setAccessible(true);
						if (field.get(user) != null) {
							map.put(field.getName(), field.get(user));
						}
					}
					if (bUservice.insertData(map, TABLENAME) != 1) {
						isSuccess = false;
						message = "修改失败!";
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
			List<User> list = bUservice.queryForListAll(new User(), TABLENAME);
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
	 * 
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoByUserId", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson getUserInfoByUserId(Integer userId) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			if (userId == null) {
				isSuccess = false;
				ajax.setMessage("参数不合理!");
			} else {
				User user = new User();
				user = bUservice.queryByPK(user, TABLENAME, userId);
				if (user == null) {
					isSuccess = false;
					ajax.setMessage("该用户不存在!");
				} else {
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
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUserByUserId", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson updateUserByUserId(User user) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = "修改成功";
		try {
			if (user.getId() == null) {
				isSuccess = false;
				message = "参数不合法";
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				Field[] fields = user.getClass().getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);
					if (field.get(user) != null) {
						map.put(field.getName(), field.get(user));
					}
				}
				if (bUservice.updateByPK(map, TABLENAME) != 1) {
					isSuccess = false;
					message = "修改失败";
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
	 * 删除用户
	 * 
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "/deleteUserByUserId", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson deleteUserByUserId(Integer userId) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			if (userId == null) {
				isSuccess = false;
				ajax.setMessage("参数不合理!");
			} else {
				if (bUservice.deleteDataByPK(userId) != 1) {
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
