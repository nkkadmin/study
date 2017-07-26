package com.base.mapper;

import org.apache.ibatis.annotations.Param;

import com.base.model.Menu;


public interface MenuMapper {
    
	

	/**
	 * 根据菜单名称获取
	 * @param menuName
	 * @return
	 */
	public Menu getMenuByName(@Param("menuName") String menuName);
}