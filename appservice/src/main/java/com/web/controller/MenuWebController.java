package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.AjaxJson;
import com.base.model.Menu;
import com.base.model.Page;
import com.base.service.BMenuService;
import com.base.util.BeanHelper;
import com.base.util.StringHelper;


/**
 * 菜单管理
 * @author xsx
 *
 */
@Controller
@RequestMapping("/menu")
public class MenuWebController {

	@Resource
	private BMenuService bMenuService;

	private static final String TABLENAME = "menu";

	@RequestMapping(value = "/menuUI", method = RequestMethod.GET)
	public ModelAndView menuUI() {
		return new ModelAndView("menu/menuList");
	}

	@RequestMapping(value = "/addMenuUI", method = RequestMethod.GET)
	public ModelAndView addUserUI() {
		return new ModelAndView("menu/menuedit");
	}

	@RequestMapping(value = "/editMenuUI", method = RequestMethod.GET)
	public ModelAndView editMenuUI() {
		return new ModelAndView("menu/menuedit");
	}

	/**
	 * 添加角色
	 * 
	 * @param role
	 * @return
	 */
	@RequestMapping(value = "/addMenu", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson addMenu(Menu menu) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = "添加成功!";
		try {
			if (StringHelper.isEmpty(menu.getName()) || StringHelper.isEmpty(menu.getUrl())) {
				isSuccess = false;
				message = "菜单名称和菜单地址不能为空!";
			} else {
				Menu isMenu = bMenuService.getMenuByName(menu.getName());
				if (isMenu != null) {
					isSuccess = false;
					message = "该菜单名已经存在，请更换!";
				} else {
					menu.setStatu("1");
					Map<String, Object> map = BeanHelper.objectToMap(menu);
					if (bMenuService.insertData(map, TABLENAME) != 1) {
						isSuccess = false;
						message = "添加失败!";
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
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryMenuList", method = RequestMethod.POST)
	@ResponseBody
	public Page<Menu> queryMenuList(Page<Menu> page) {
		try {
			page = bMenuService.queryForListAllPage(new Menu(), TABLENAME, page);
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
	@RequestMapping(value = "/getMenuByPK", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson getMenuByPK(Integer id) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		try {
			if (id == null) {
				isSuccess = false;
				ajax.setMessage("参数不合理!");
			} else {
				Menu menu = new Menu();
				menu = bMenuService.queryByPK(menu, TABLENAME, id);
				if (menu == null) {
					isSuccess = false;
					ajax.setMessage("该菜单不存在!");
				} else {
					ajax.setData(menu);
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
	@RequestMapping(value = "/updateMenuByPK", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson updateMenuByPK(Menu menu) {
		AjaxJson ajax = new AjaxJson();
		boolean isSuccess = true;
		String message = "修改成功";
		try {
			if (menu.getId() == null || StringHelper.isEmpty(menu.getName()) || StringHelper.isEmpty(menu.getUrl())) {
				isSuccess = false;
				message = "参数不合法";
			} else {
				Map<String, Object> map = BeanHelper.objectToMap(menu);
				if (bMenuService.updateByPK(map, TABLENAME) != 1) {
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
	@RequestMapping(value = "/deleteMenuByPK", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson deleteMenuByPK(Integer id) {
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
				bMenuService.updateByPK(map, TABLENAME);
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
