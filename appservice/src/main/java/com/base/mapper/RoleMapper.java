package com.base.mapper;

import org.apache.ibatis.annotations.Param;

import com.base.model.Role;

public interface RoleMapper {
	
	/**
	 * 根据name获取role
	 * @param roleName
	 * @return
	 */
	public Role getRoleByName(@Param("roleName") String roleName);
}