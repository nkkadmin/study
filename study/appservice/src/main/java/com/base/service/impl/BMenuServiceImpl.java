package com.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mapper.MenuMapper;
import com.base.model.Menu;
import com.base.service.BMenuService;
import com.base.util.StringHelper;

/**
 * 菜单service
 * 
 * @author xsx
 *
 */
@Service("bMenuService")
public class BMenuServiceImpl extends BBaseServiceImpl<Menu> implements
		BMenuService {

	@Resource
	private MenuMapper menuMapper;

	@Override
	public Menu getMenuByName(String menuName) {
		if (StringHelper.isEmpty(menuName))
			return null;
		return menuMapper.getMenuByName(menuName);
	}

}
