package com.base.service;

import com.base.model.Menu;

public interface BMenuService extends BBaseService<Menu> {

	
	/**
	 * 根据菜单名称获取
	 * @param menuName
	 * @return
	 */
	public Menu getMenuByName(String menuName);
}
