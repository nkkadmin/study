package com.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mapper.RoleMapper;
import com.base.model.Role;
import com.base.service.BRoleService;

 
@Service("bRoleService")
public class BRoleServiceImpl extends BBaseServiceImpl<Role> implements BRoleService {

	
	@Resource
	private RoleMapper roleMapper;
	
	@Override
	public Role getRoleByName(String roleName) {
		if(roleName == null) return null;
		return roleMapper.getRoleByName(roleName);
	}
	

}
