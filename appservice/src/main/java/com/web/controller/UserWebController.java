package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.AjaxJson;
import com.base.commons.constant.MessageConstant;
import com.base.controller.BaseController;
import com.base.model.Page;
import com.base.model.User;
import com.base.service.BUserService;
import com.base.util.BeanHelper;
import com.base.util.DateHelper;
import com.base.util.StringHelper;

@Controller
@RequestMapping("/user")
public class UserWebController extends BaseController {

	final String UI_URL = "manager/User";

	@Resource
	private BUserService bUservice;

	private static final String TABLENAME = "user";

	

	@RequestMapping(value = "/addUserUI", method = RequestMethod.GET)
	public ModelAndView addUserUI() {
		return new ModelAndView(UI_URL + "/edit");
	}
	
	
	@RequestMapping(value = "/editUserUI", method = RequestMethod.GET)
	public ModelAndView editUserUI(Integer id) {
		ModelAndView mv = new ModelAndView(UI_URL + "/edit");
		try {
			User user = bUservice.queryByPK(new User(), TABLENAME, id);
			mv.addObject("user", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	@RequestMapping(value = "/userListUI", method = RequestMethod.GET)
	public ModelAndView userListUI() {
		return new ModelAndView(UI_URL + "/index");
	}

	/**
	 * 登录
	 * @param loginName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson login(String loginName, String password,HttpServletRequest request) {
		boolean isSuccess = true;
		String message = "登录成功";
		try {
			if (StringHelper.isEmpty(loginName)
					|| StringHelper.isEmpty(password)) {
				isSuccess = false;
				message = "用户名、密码都不能为空";
			} else {
				User user = bUservice.getUserByLoginName(loginName);
				if (user == null) {
					isSuccess = false;
					message = "不存在该用户";
				} else {
					if (!user.getLoginname().equals(loginName)
							|| !user.getPassword().equals(password)) {
						isSuccess = false;
						message = "用户名密码错误";
					} else {
						request.getSession().setAttribute("userInfo", user);
					}
				}
			}
			return responseInfo(message, isSuccess);
		} catch (Exception e) {
			e.printStackTrace();
			return responseInfo("服务异常!", false);
		}
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
		boolean isSuccess = true;
		String message = MessageConstant.ADD_SUCCESS;
		try {
			if (StringHelper.isEmpty(user.getLoginname())
					|| StringHelper.isEmpty(user.getPassword())
					|| StringHelper.isEmpty(user.getUsername())
					|| StringHelper.isEmpty(user.getSex())
					|| user.getAge() == null
					|| StringHelper.isEmpty(confirmPassword)) {
				isSuccess = false;
				message = MessageConstant.INPUT_HAS_NULL;
			} else if (!user.getPassword().equals(confirmPassword)
					|| confirmPassword == null || confirmPassword.equals("")) {
				isSuccess = false;
				message = "两次密码不一致!";
			} else {
				User userByLogin = bUservice.getUserByLoginName(user
						.getLoginname());
				if (userByLogin != null) {
					isSuccess = false;
					message = "该用户名已经存在，请更换!";
				} else {
					user.setStatu("1");
					user.setCreatetime(DateHelper.nowDate());
					Map<String, Object> map = BeanHelper.objectToMap(user);
					if (bUservice.insertData(map, TABLENAME) != 1) {
						isSuccess = false;
						message = MessageConstant.ADD_FALIL;
					}
				}
			}
			return responseInfo(message, isSuccess);
		} catch (Exception e) {
			e.printStackTrace();
			return responseInfo("服务异常", false);
		}
	}

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.POST)
	@ResponseBody
	public Page<User> userList(Page<User> page) {
		page.setPageNo(page.getPageNo() == 0 ? 1 : page.getPageNo());
		try {
			page = bUservice.queryForListAllPage(new User(), TABLENAME, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
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
		boolean isSuccess = true;
		String message = "请求成功!";
		User user = new User();
		try {
			if (userId == null) {
				isSuccess = false;
				message = "参数不合理!";
			} else {

				user = bUservice.queryByPK(user, TABLENAME, userId);
				if (user == null) {
					isSuccess = false;
					message = "该用户不存在!";
				}
			}
			return responseInfo(message, isSuccess, user);
		} catch (Exception e) {
			e.printStackTrace();
			return responseInfo("服务异常", false);
		}
	}

	/**
	 * 修改用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateUserByUserId", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson updateUserByUserId(User user) {
		boolean isSuccess = true;
		String message = "修改成功";
		try {
			if (user.getId() == null) {
				isSuccess = false;
				message = "参数不合法";
			} else {
				Map<String, Object> map = BeanHelper.objectToMap(user);
				if (bUservice.updateByPK(map, TABLENAME) != 1) {
					isSuccess = false;
					message = "修改失败";
				}
			}
			return responseInfo(message, isSuccess);
		} catch (Exception e) {
			e.printStackTrace();
			return responseInfo("服务异常", false);
		}
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
		boolean isSuccess = true;
		String message = "删除成功";
		try {
			if (userId == null) {
				isSuccess = false;
				message = "参数不合理!";
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", userId);
				map.put("statu", "0"); // 不做物理删除，做标记删除
				bUservice.updateByPK(map, TABLENAME);
			}
			return responseInfo(message, isSuccess);
		} catch (Exception e) {
			e.printStackTrace();
			return responseInfo("服务异常", false);
		}
	}

}
