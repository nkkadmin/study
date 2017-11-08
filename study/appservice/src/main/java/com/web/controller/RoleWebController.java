package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.base.commons.constant.MessageConstant;
import com.base.model.AjaxJson;
import com.base.model.Page;
import com.base.model.Role;
import com.base.service.BRoleService;
import com.base.util.BeanHelper;
import com.base.util.DateHelper;
import com.base.util.StringHelper;

/**
 * 角色管理
 * @author xsx
 *
 */
@Controller
@RequestMapping("/role")
public class RoleWebController {

	@Resource
	private BRoleService bRoleService;
	
	final String UI_URL = "manager/Role";

	private static final String TABLENAME = "role";

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping(value = "/addRoleUI", method = RequestMethod.GET)
	public ModelAndView addRoleUI() {
		return new ModelAndView(UI_URL+"/edit");
	}
	
	/**
	 * 跳转到修改页面
	 * @return
	 */
	@RequestMapping(value = "/editRoleUI", method = RequestMethod.GET)
	public ModelAndView editRoleUI(Integer id) {
		ModelAndView view =  new ModelAndView(UI_URL+"/edit");
		Role role = new Role();
		try {
			role = bRoleService.queryByPK(role, TABLENAME, id);
			view.addObject("role", role);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

	/**
	 * 跳转到列表页面
	 * @return
	 */
	@RequestMapping(value = "/listUI", method = RequestMethod.GET)
	public ModelAndView listUI() {
		return new ModelAndView(UI_URL+"/index");
	}


	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson addUser(Role role) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = MessageConstant.ADD_SUCCESS;
		try {
			if (StringHelper.isEmpty(role.getName())) {
				isSuccess = false;
				message = "角色名称不能为空!";
			} else {
				Role isRole = bRoleService.getRoleByName(role.getName());
				if (isRole != null) {
					isSuccess = false;
					message = "该角色名已经存在，请更换!";
				} else {
					role.setStatu("1");
					role.setCreatetime(DateHelper.nowDate());
					Map<String, Object> map = BeanHelper.objectToMap(role);
					if (bRoleService.insertData(map, TABLENAME) != 1) {
						isSuccess = false;
						message = MessageConstant.ADD_FALIL;
					}
				}
			}
			ajax.setSuccess(isSuccess);
			ajax.setMessage(message);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("服务异常");
			e.printStackTrace();
			return ajax;
		}
		return ajax;
	}

	/**
	 * 获取角色列表
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/queryRoleList", method = RequestMethod.POST)
	@ResponseBody
	public Page<Role> queryRoleList(Page<Role> page,String name) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tableName", TABLENAME);
			if(!StringHelper.isEmpty(name)){
				map.put("name", name);
			}
			page = bRoleService.queryForListAllPage(new Role(), map, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}

	/**
	 * 根据id获取角色信息
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/getRoleByPK", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson getRoleByPK(Integer roleId) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			if (roleId == null) {
				isSuccess = false;
				ajax.setMessage("参数不合理!");
			} else {
				Role role = new Role();
				role = bRoleService.queryByPK(role, TABLENAME, roleId);
				if (role == null) {
					isSuccess = false;
					ajax.setMessage("该角色不存在，不能修改!");
				} else {
					ajax.setData(role);
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
	 * 修改角色信息
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/updateRoleByPK", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson updateRoleByPK(Role role) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = "修改成功";
		try {
			if (role.getId() == null) {
				isSuccess = false;
				message = "参数不合法";
			} else {
				Map<String, Object> map = BeanHelper.objectToMap(role);
				if (bRoleService.updateByPK(map,role.getId(), TABLENAME) != 1) {
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
	 * 删除角色
	 * 
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value = "/deleteRoleByPK", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson deleteRoleByPK(Integer id) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			if (id == null) {
				isSuccess = false;
				ajax.setMessage("参数不合理!");
			} else {
				Map<String,Object> map = new HashMap();
				map.put("id", id);
				map.put("statu", "0");  //不做物理删除，做标记删除
				bRoleService.updateByPK(map,id, TABLENAME);
			}
			ajax.setSuccess(isSuccess);
		} catch (Exception e) {
			ajax.setSuccess(false);
			ajax.setMessage("服务异常");
			e.printStackTrace();
			return ajax;
		}
		return ajax;
	}

}
