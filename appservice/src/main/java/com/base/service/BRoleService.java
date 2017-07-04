package com.base.service;

import com.base.model.Role;

/**
 * 公用角色管理
 * 
 * @author xsx
 *
 */
public interface BRoleService extends BBaseService<Role> {
	
	/**
	 * 根据角色名称获取role
	 * @param roleName
	 * @return
	 */
	public Role getRoleByName(String roleName);
}
