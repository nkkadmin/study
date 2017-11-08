package com.xsx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.xsx.constant.Constants;
import com.xsx.domain.Employee;
import com.xsx.domain.Role;
import com.xsx.service.DepartmentService;
import com.xsx.service.EmployeeService;
import com.xsx.service.OrdersService;
import com.xsx.service.RoleService;
import com.xsx.util.Md5Utils;

public class BaseController {

	@Resource
	public EmployeeService employeeService;
	@Resource
	public RoleService roleService;
	@Resource
	public OrdersService ordersService;
	@Resource
	public DepartmentService departmentService;

	public HttpServletRequest getRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) (RequestContextHolder
				.getRequestAttributes())).getRequest();
		return request;
	}

	public HttpSession getSession() {
		return getRequest().getSession();
	}

	public void setSession(String name, Object value) {
		setSession(name, value, null);
	}

	public void setSession(String name, Object value, Integer maxInactive) {
		HttpSession session = getSession();
		if (maxInactive != null) {
			session.setMaxInactiveInterval(maxInactive);
		}
		session.setAttribute(name, value);
	}

	public Employee getCurrentEmpSession() {
		if (getSessionValue(Constants.CURRENTP_SESSION_EMP) != null) {
			return (Employee) getSessionValue(Constants.CURRENTP_SESSION_EMP);
		}
		return null;
	}

	public Object getSessionValue(String name) {
		return getSession().getAttribute(name);
	}

	public void removeSession(String name) {
		if (getSessionValue(name) != null) {
			getSession().removeAttribute(name);
		}
	}

	/**
	 * 登录实现逻辑
	 * 
	 * @param employee
	 * @return
	 */
	public String loginImp(Employee employee, String roleDescript,
			String sessionName) {
		if (employee == null || employee.getName() == null
				|| employee.getPassword() == null) {
			return "用户名和密码不能为空";
		}
		Employee dirEmployee = employeeService.selectByName(employee.getName());
		if (dirEmployee != null) {
			String inputPass = Md5Utils.EncoderByMd5(employee.getName()
					+ employee.getPassword());
			if (inputPass.equals(dirEmployee.getPassword())) {
				// 判断是权限
				Role role = roleService.selectByPrimaryKey(dirEmployee
						.getRoleid());
				if (role != null && role.getDescript().equals(roleDescript)) {
					setSession(sessionName, dirEmployee);
					return "登录成功";
				} else {
					return "不存在该账号信息";
				}
			}
		}
		return "用户名和密码不正确";
	}

	/**
	 * 退出实现逻辑
	 * @param empId
	 * @return
	 */
	public String logOutImp(Integer empId,String sessionName) {
		if (empId != null) {
			Employee employee = (Employee) getSessionValue(sessionName);
			if (employee != null && empId == employee.getId()) {
				removeSession(sessionName);
				return "退出成功";
			}
		}
		return "退出失败";
	}
}
